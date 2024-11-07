package com.nicebao.Dao;

import com.nicebao.Bean.Employee;
import com.nicebao.util.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	private Conn conn;

	// 构造函数，用于依赖注入Conn对象
	public EmpDAO(Conn conn) {
		this.conn = conn;
	}

	// verify方法
	public boolean verify(Employee ep, String ipAddress) {
		boolean result = false;
		String sql = "SELECT * FROM employee WHERE name=?";
		try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
			pr.setObject(1, ep.getName());
			ResultSet rs = pr.executeQuery();

			if (rs.next()) {
				int failedAttempts = rs.getInt("failed_attempts");
				Timestamp lastFailedTime = rs.getTimestamp("last_failed_time");
				long diffInMinutes = (System.currentTimeMillis() - lastFailedTime.getTime()) / (1000 * 60);

				if (failedAttempts >= 3 && diffInMinutes < 10) {
					return false;
				}

				if (ep.getPassword().equals(rs.getString("password"))) {
					result = true;
					updateFailedAttempts(ep.getName(), 0);
					recordLoginLog(ep.getName(), ipAddress, "success");
					ep.setRole(rs.getString("role"));
				} else {
					updateFailedAttempts(ep.getName(), failedAttempts + 1);
					recordLoginLog(ep.getName(), ipAddress, "fail");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 更新失败尝试次数
	private void updateFailedAttempts(String username, int failedAttempts) {
		String sql = "UPDATE employee SET failed_attempts = ?, last_failed_time = NOW() WHERE name = ?";
		try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
			pr.setInt(1, failedAttempts);
			pr.setString(2, username);
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 注册新用户
	public boolean register(Employee ep) {
		boolean success = false;
		String sql = "INSERT INTO employee (name, password, failed_attempts, last_failed_time) VALUES (?, ?, 0, NOW())";

		try {
			if (isUserExist(ep)) {
				return false;
			}

			try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
				pr.setObject(1, ep.getName());
				pr.setObject(2, ep.getPassword());
				int rows = pr.executeUpdate();

				if (rows > 0) {
					success = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	// 检查用户是否存在
	public boolean isUserExist(Employee ep) {
		boolean exists = false;
		String sql = "SELECT * FROM employee WHERE name=?";
		try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
			pr.setObject(1, ep.getName());
			ResultSet rs = pr.executeQuery();

			if (rs.next()) {
				exists = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}

	// 记录登录日志
	public void recordLoginLog(String username, String ipAddress, String status) {
		String sql = "INSERT INTO login_logs (username, ip, login_time, status) VALUES (?, ?, NOW(), ?)";
		try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
			pr.setString(1, username);
			pr.setString(2, ipAddress);
			pr.setString(3, status);
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 获取登录日志
	public List<String> getLoginLogs(String username) {
		List<String> logs = new ArrayList<>();
		String sql = "SELECT ip, login_time, status FROM login_logs WHERE username=? ORDER BY login_time DESC";
		try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
			pr.setString(1, username);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				String log = "IP: " + rs.getString("ip") + " | 登录时间: " + rs.getTimestamp("login_time") + " | 登录状态: " + rs.getString("status");
				logs.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logs;
	}

	// 获取用户操作日志
	public List<String> getUserActionLogs(String username) {
		List<String> logs = new ArrayList<>();
		String sql = "SELECT ip_address, url, action_time FROM user_actions WHERE username=? ORDER BY action_time DESC";
		try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
			pr.setString(1, username);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				String log = "IP: " + rs.getString("ip_address") + " | URL: " + rs.getString("url") + " | 操作时间: " + rs.getTimestamp("action_time");
				logs.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logs;
	}

	// 记录用户操作
	public void recordUserAction(String username, String ip, String url) {
		String sql = "INSERT INTO user_actions (username, ip_address, url, action_time) VALUES (?, ?, ?, NOW())";
		try (PreparedStatement pr = conn.getCn().prepareStatement(sql)) {
			pr.setString(1, username);
			pr.setString(2, ip);
			pr.setString(3, url);
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
