package com.nicebao.controller;

import com.nicebao.common.ApiResponse;
import com.nicebao.enums.ApiResponseCodeEnum;
import com.nicebao.mapper.InfoMapper;
import com.nicebao.model.Info;
import com.nicebao.utils.DataTimeUtils;
import com.nicebao.utils.MybatisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @name: submit
 * @author: IhaveBB
 * @date: 2024-09-09 19:49
 **/
@WebServlet("/submit")
@MultipartConfig
@Slf4j
public class submit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Info info = new Info();
		info.setName(req.getParameter("name"));
		info.setStudentId(req.getParameter("studentId"));
		info.setPhoneNumber(req.getParameter("phoneNumber"));
		info.setLeaveReason(req.getParameter("leaveReason"));
		//时间戳转换为Data
		Date predictLeaveTime = new Date(Long.parseLong(req.getParameter("predictLeaveTime")));
		Date predictReturnTime = new Date(Long.parseLong(req.getParameter("predictReturnTime")));
		info.setPredictLeaveTime(predictLeaveTime);
		info.setPredictReturnTime(predictReturnTime);
		info.setSubmitTime(new Date(System.currentTimeMillis()));
		info.setUpdateTime(new Date(System.currentTimeMillis()));
		info.setStatus("pending");
		//校验部分
		if(predictLeaveTime.after(predictReturnTime)){
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			ApiResponse<String> apiResponse = ApiResponse.fail(ApiResponseCodeEnum.PARAM_DATE_IS_ERROR);
			String jsonResponse = mapper.writeValueAsString(apiResponse);
			resp.getWriter().write(jsonResponse);
			return;
		}

		// 文件上传部分
		Part filePart = req.getPart("file"); // 获取上传的文件
		String uploadPath = req.getServletContext().getRealPath("/") + "upload";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs(); // 如果目录不存在，创建
		}
		// 保存文件到服务器指定路径
		String fileName = filePart.getSubmittedFileName();
		String filePath = uploadPath + File.separator + fileName;
		filePart.write(filePath); // 保存文件
		// 将文件路径存储到 info 对象
		info.setProofPath(filePath);

		//提交到数据库
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			infoMapper.insertInfo(info);
			sqlSession.commit();  // 提交事务
		}

		// 提交成功时返回统一格式的 JSON 响应
		resp.setContentType("application/json");
		ApiResponse<Info> apiResponse = ApiResponse.success(info);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = mapper.writeValueAsString(apiResponse);
		resp.getWriter().write(jsonResponse);

	}
}