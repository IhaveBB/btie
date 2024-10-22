package com.nicebao.mapper;

import com.nicebao.model.LoginLog;
import com.nicebao.model.OperationLog;
import com.nicebao.model.User;
import com.nicebao.model.UserActionLog;

import java.util.List;

/**
 * @name: UserMapper
 * @author: IhaveBB
 * @date: 2024-10-19 22:40
 **/
public interface UserMapper {
	void insertUser(User user);
	User findUserByUsername(String username);
	void insertLoginLog(LoginLog log);
	void updateUser(User user);
	List<LoginLog> getLoginLogs(int userId);
	List<LoginLog> getAllLoginLogs();

	void insertUserActionLog(UserActionLog actionLog);

	List<OperationLog> getAllOperationLogs();
}
