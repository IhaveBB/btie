package com.nicebao.Service;

import com.nicebao.mapper.UserMapper;
import com.nicebao.model.*;
import com.nicebao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

/**
 * @name: UserService
 * @author: IhaveBB
 * @date: 2024-10-20 11:41
 **/
public class UserService {
	private static final int MAX_ATTEMPTS = 3;
	private static final long LOCK_TIME = 10 * 60 * 1000;
	private Map<String, Integer> loginAttempts = new HashMap<>();

	public RegistrationResult register(String username, String password) {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);

			if (userMapper.findUserByUsername(username) != null) {
				return new RegistrationResult(false, "用户名已存在，请尝试其他用户名");
			}

			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			userMapper.insertUser(newUser);
			session.commit();
			return new RegistrationResult(true, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new RegistrationResult(false, "注册失败");
		}
	}


	public LoginResult login(String username, String password, String ip) {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);

			if (isLocked(username)) {
				return new LoginResult(false, "账户已被锁定，请10min后重试.");
			}

			User user = userMapper.findUserByUsername(username);
			if (user != null && password.equals(user.getPassword())) {
				user.setLastLoginTime(new Date());
				user.setLastIp(ip);
				userMapper.updateUser(user);
				logLogin(user.getId(), ip);
				resetAttempts(username);

				return new LoginResult(true, user);
			} else {
				recordFailedAttempt(username);
				return new LoginResult(false, "用户名或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new LoginResult(false, "登录失败");
		}
	}


	private boolean isLocked(String username) {
		Integer attempts = loginAttempts.get(username);
		if (attempts != null && attempts >= MAX_ATTEMPTS) {
			long lastAttemptTime = System.currentTimeMillis();
			return (lastAttemptTime - lastAttemptTime) < LOCK_TIME;
		}
		return false;
	}

	private void recordFailedAttempt(String username) {
		loginAttempts.put(username, loginAttempts.getOrDefault(username, 0) + 1);
	}

	private void resetAttempts(String username) {
		loginAttempts.remove(username);
	}
	public void logLogin(int userId, String ip) {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);

			LoginLog log = new LoginLog();
			log.setUserId(userId);
			log.setLoginTime(new Date());
			log.setLoginIp(ip);

			userMapper.insertLoginLog(log);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<LoginLog> getLoginLogs(int userId) {

		List<LoginLog> list = null;
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			list = userMapper.getLoginLogs(userId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<LoginLog> getAllLoginLogs() {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			return userMapper.getAllLoginLogs();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<OperationLog> getAllOperationLogs() {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			return userMapper.getAllOperationLogs();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
