package com.nicebao.Dao;

import com.nicebao.Bean.Employee;
import com.nicebao.util.Conn;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @param:
 * @return:
 * @author: IhaveBB
 * @date: 2024/11/5
 **/
public class EmpDAO {
	public boolean verify(Employee ep,String ipAddress) {
		Conn cn = new Conn();

		boolean temp = false;
		String sql = "SELECT * FROM employee WHERE name=?";
		try {
			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setObject(1, ep.getName());
			cn.rs = cn.pr.executeQuery();

			if (cn.rs.next()) {
				int failedAttempts = cn.rs.getInt("failed_attempts");
				Timestamp lastFailedTime = cn.rs.getTimestamp("last_failed_time");
				long diffInMinutes = (System.currentTimeMillis() - lastFailedTime.getTime()) / (1000 * 60);

				if (failedAttempts >= 3 && diffInMinutes < 10) {
					return false;
				}

				if (ep.getPassword().equals(cn.rs.getString("password"))) {
					temp = true;
					updateFailedAttempts(ep.getName(), 0);
					recordLoginLog(ep.getName(), ipAddress,"success");
					ep.setRole(cn.rs.getString("role"));
				} else {
					updateFailedAttempts(ep.getName(), failedAttempts + 1);
					recordLoginLog(ep.getName(), ipAddress,"fail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cn.close();
		return temp;
	}


	private void updateFailedAttempts( String username, int failedAttempts) {
		Conn cn = new Conn();
		String sql = "UPDATE employee SET failed_attempts = ?, last_failed_time = NOW() WHERE name = ?";
		try {
			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setInt(1, failedAttempts);
			cn.pr.setString(2, username);
			cn.pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean register(Employee ep) {
		Conn cn = new Conn();

		boolean success = false;
		String sql = "INSERT INTO employee (name, password, failed_attempts, last_failed_time) VALUES (?, ?, 0, NOW())";

		try {

			if (isUserExist(ep)) {
				return false;
			}

			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setObject(1, ep.getName());
			cn.pr.setObject(2, ep.getPassword());
			int rows = cn.pr.executeUpdate();

			if (rows > 0) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return success;
	}



	public boolean isUserExist(Employee ep) {
		Conn cn = new Conn();

		boolean temp = false;
		String sql = "SELECT * FROM employee WHERE name=?";
		try {
			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setObject(1, ep.getName());
			cn.rs = cn.pr.executeQuery();


			if (cn.rs.next()) {
				temp = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cn.close();
		return temp;
	}
	public void recordLoginLog(String username, String ipAddress,String status) {
		Conn cn = new Conn();
		String sql = "INSERT INTO login_logs (username, ip, login_time,status) VALUES (?, ?, NOW(),?)";
		try {
			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setString(1, username);
			cn.pr.setString(2, ipAddress);
			cn.pr.setString(3, status);
			cn.pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
	}


	public List<String> getLoginLogs(String username) {
		Conn cn = new Conn();
		List<String> logs = new ArrayList<>();
		String sql = "SELECT ip, login_time, status FROM login_logs WHERE username=? ORDER BY login_time DESC";
		try {
			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setString(1, username);
			cn.rs = cn.pr.executeQuery();

			while (cn.rs.next()) {
				String log = "IP: " + cn.rs.getString("ip") + " | 登录时间: " + cn.rs.getTimestamp("login_time")+ " | 登录状态: " + cn.rs.getString("status");
				logs.add(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return logs;
	}


	public List<String> getUserActionLogs(String username) {
		Conn cn = new Conn();
		List<String> logs = new ArrayList<>();
		String sql = "SELECT ip_address, url, action_time FROM user_actions WHERE username=? ORDER BY action_time DESC";
		try {
			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setString(1, username);
			cn.rs = cn.pr.executeQuery();


			while (cn.rs.next()) {
				String log = "IP: " + cn.rs.getString("ip_address")
						+ " | URL: " + cn.rs.getString("url")
						+ " | 操作时间: " + cn.rs.getTimestamp("action_time");
				logs.add(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return logs;
	}


	public void recordUserAction(String username, String ip, String url) {
		Conn cn = new Conn();
		String sql = "INSERT INTO user_actions (username, ip_address, url, action_time) VALUES (?, ?, ?, NOW())";
		try {
			cn.pr = cn.cn.prepareStatement(sql);
			cn.pr.setString(1, username);
			cn.pr.setString(2, ip);
			cn.pr.setString(3, url);
			cn.pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
	}
}
