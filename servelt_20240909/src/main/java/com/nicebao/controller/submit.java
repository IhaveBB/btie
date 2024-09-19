package com.nicebao.controller;

import com.nicebao.common.ApiResponse;
import com.nicebao.enums.ApiResponseCodeEnum;
import com.nicebao.mapper.InfoMapper;
import com.nicebao.model.Info;
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
	public static long maxSize = 2 * 1024 * 1024;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		Info info = new Info();
		info.setName(req.getParameter("name"));
		info.setStudentId(req.getParameter("studentId"));
		info.setPhoneNumber(req.getParameter("phoneNumber"));
		info.setLeaveReason(req.getParameter("leaveReason"));
		//时间戳转换为Data,让mybatis自己拆包映射为数据库需要的字段
		Date predictLeaveTime = new Date(Long.parseLong(req.getParameter("predictLeaveTime")));
		Date predictReturnTime = new Date(Long.parseLong(req.getParameter("predictReturnTime")));
		info.setPredictLeaveTime(predictLeaveTime);
		info.setPredictReturnTime(predictReturnTime);
		info.setSubmitTime(new Date(System.currentTimeMillis()));
		info.setUpdateTime(new Date(System.currentTimeMillis()));
		info.setStatus("pending");
		//校验部分
		if(predictLeaveTime.after(predictReturnTime)){
			ObjectMapper mapper = new ObjectMapper();
			String jsonResponse = mapper.writeValueAsString(ApiResponse.fail(ApiResponseCodeEnum.PARAM_DATE_IS_ERROR));
			resp.getWriter().write(jsonResponse);
			return;
		}

		// 文件上传部分
		Part filePart = req.getPart("file");
		String fileType = filePart.getContentType();
		long fileSize = filePart.getSize();
		// 限制文件类型为图片 (JPEG 或 PNG)
		if (!"image/jpeg".equals(fileType) && !"image/png".equals(fileType)) {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			String jsonResponse = mapper.writeValueAsString(ApiResponse.fail(ApiResponseCodeEnum.PARAM_FILE_FOMAT_ERROR));
			resp.getWriter().write(jsonResponse);
			return;
		}

		if (fileSize > maxSize) {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			String jsonResponse = mapper.writeValueAsString(ApiResponse.fail(ApiResponseCodeEnum.PARAM_FILE_SIZE_ERROR));
			resp.getWriter().write(jsonResponse);
			return;
		}

		String uploadPath = req.getServletContext().getRealPath("/") + "upload";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// 保存文件到服务器指定路径
		String fileName = filePart.getSubmittedFileName();
		String filePath = uploadPath + File.separator + fileName;
		// 保存文件
		filePart.write(filePath);
		info.setProofPath(filePath);

		//提交到数据库
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
			infoMapper.insertInfo(info);
			sqlSession.commit();
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = mapper.writeValueAsString(ApiResponse.success(info));
		resp.getWriter().write(jsonResponse);

	}
}