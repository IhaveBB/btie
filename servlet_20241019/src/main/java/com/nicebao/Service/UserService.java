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
			return registerUser(userMapper, username, password, session);
		} catch (Exception e) {
			e.printStackTrace();
			return new RegistrationResult(false, "注册失败");
		}
	}

	private RegistrationResult registerUser(UserMapper userMapper, String username, String password, SqlSession session) {
		if (userMapper.findUserByUsername(username) != null) {
			return new RegistrationResult(false, "用户名已存在，请尝试其他用户名");
		}

		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		userMapper.insertUser(newUser);
		session.commit();
		return new RegistrationResult(true, null);
	}

	public LoginResult login(String username, String password, String ip) {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			if (isAccountLocked(username)) {
				return new LoginResult(false, "账户已被锁定，请10分钟后重试.");
			}

			return authenticateUser(userMapper, username, password, ip, session);
		} catch (Exception e) {
			e.printStackTrace();
			return new LoginResult(false, "登录失败");
		}
	}

	private LoginResult authenticateUser(UserMapper userMapper, String username, String password, String ip, SqlSession session) {
		User user = userMapper.findUserByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			updateUserLoginInfo(user, ip, userMapper, session);
			return new LoginResult(true, user);
		} else {
			recordFailedAttempt(username);
			return new LoginResult(false, "用户名或密码错误");
		}
	}

	private void updateUserLoginInfo(User user, String ip, UserMapper userMapper, SqlSession session) {
		user.setLastLoginTime(new Date());
		user.setLastIp(ip);
		userMapper.updateUser(user);
		logLogin(user.getId(), ip);
		resetAttempts(user.getUsername());
	}

	private boolean isAccountLocked(String username) {
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
			createLoginLog(userId, ip, userMapper, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createLoginLog(int userId, String ip, UserMapper userMapper, SqlSession session) {
		LoginLog log = new LoginLog();
		log.setUserId(userId);
		log.setLoginTime(new Date());
		log.setLoginIp(ip);
		userMapper.insertLoginLog(log);
		session.commit();
	}

	public List<LoginLog> getLoginLogs(int userId) {
		return fetchLoginLogs(userId, false);
	}

	public List<LoginLog> getAllLoginLogs() {
		return fetchAllLoginLogs(false);
	}



	private List<LoginLog> fetchLoginLogs(int userId, boolean commitSession) {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			List<LoginLog> list = userMapper.getLoginLogs(userId);
			if (commitSession) session.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	private List<LoginLog> fetchAllLoginLogs(boolean commitSession) {
		try (SqlSession session = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			return userMapper.getAllLoginLogs();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}


}
