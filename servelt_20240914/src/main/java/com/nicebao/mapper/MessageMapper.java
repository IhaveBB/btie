package com.nicebao.mapper;

import com.nicebao.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @name: MessageMapper
 * @author: IhaveBB
 * @date: 2024-09-18 16:45
 **/
public interface MessageMapper {
	int insertMessage(@Param("userName") String userName,@Param("content") String content);
	List<Message> getAllMessages();
}
