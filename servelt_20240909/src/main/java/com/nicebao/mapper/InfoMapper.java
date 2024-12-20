package com.nicebao.mapper;
import com.nicebao.model.Info;

import java.util.List;

/**
 * @name: InfoMapper
 * @author: IhaveBB
 * @date: 2024-09-10 23:21
 **/
public interface InfoMapper {

	void insertInfo(Info info);
	Info getInfoById(int id);

	List<Info> getAllInfo();
}
