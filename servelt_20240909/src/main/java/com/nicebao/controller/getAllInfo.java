package com.nicebao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicebao.common.ApiResponse;
import com.nicebao.mapper.InfoMapper;
import com.nicebao.model.Info;
import com.nicebao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @name: getAllInfo
 * @author: IhaveBB
 * @date: 2024-09-11 22:34
 **/
@WebServlet("/getAllInfo")
public class getAllInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			List<Info> infoList = infoMapper.getAllInfo();
			// 返回 JSON 数据
			ObjectMapper mapper = new ObjectMapper();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			ApiResponse<List<Info>> apiResponse = ApiResponse.success(infoList);
			String jsonResponse = mapper.writeValueAsString(apiResponse);
			resp.getWriter().write(jsonResponse);
		}
	}
}
