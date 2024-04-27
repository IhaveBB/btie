package com.nicebao.springbook.controller;

import com.nicebao.springbook.mapper.BookInfoMapper;
import com.nicebao.springbook.model.*;
import com.nicebao.springbook.service.BookService;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.nicebao.springbook.constans.Constans.USER_SESSION_KEY;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/getList")
	public List<BookInfo> getList() {
		//1.从数据库获取数据
		//数据采用Mock方式
		List<BookInfo> bookInfos = mockBookData();
		//2.对数据进行处理：状态转换
		for (BookInfo bookInfo : bookInfos) {
			if (bookInfo.getStatus() == 1) {
				bookInfo.setStateCN("可借阅");
			} else if (bookInfo.getStatus() == 2) {
				bookInfo.setStateCN("不可借阅");
			}
		}
		//3.返回数据
		return bookInfos;
	}

	public List<BookInfo> mockBookData() {
		List<BookInfo> bookInfos = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			BookInfo bookInfo = new BookInfo();
			bookInfo.setBookName("西游记" + i);
			bookInfo.setAuthor("吴承恩" + i);
			bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
			bookInfo.setCount(100 + i);
			bookInfo.setPublish("清华大学出版社" + i);
			bookInfo.setStatus(i % 5 == 0 ? 2 : 1);
			bookInfo.setId(i);
			bookInfos.add(bookInfo);
		}
		return bookInfos;
	}

	@RequestMapping("/addBook")
	public String addBook(BookInfo bookInfo) {
		log.info("添加图书,bookInfo:{}", bookInfo);
		if (!StringUtils.hasLength(bookInfo.getBookName()) || !StringUtils.hasLength(bookInfo.getAuthor())) {
			return "参数错误";
		}
		try {
			bookService.insertBook(bookInfo);
		} catch (Exception E) {
			return "内部发生错误，请联系管理员";
		}
		return "";
	}

	@RequestMapping("/getListByPage")
	public Result<PageResult<BookInfo>> getListByPage(PageRequest pageRequest, HttpSession session) {
		log.info("查询到列表信息,pageRequest", pageRequest);
		if (pageRequest.getCurrPage() == -1) {
			return Result.fail("非法参数");
		}
		PageResult<BookInfo> pageResult = bookService.getListByPage(pageRequest);
		return Result.success(pageResult);
	}

	@RequestMapping("/queryBookById")
	public BookInfo queryBookById(Integer bookId) {
		log.info("查询图书信息,图书ID", bookId);
		return bookService.queryBookById(bookId);
	}

	@RequestMapping("/updateBook")
	public boolean updateBook(BookInfo bookInfo) {
		log.info("更新图书", bookInfo);
		if (bookInfo.getId() < 0) {
			return false;
		}
		try {
			Integer result = bookService.updateBook(bookInfo);
			if (result <= 0) {
				return false;
			}
		} catch (Exception e) {
			log.info("更新图书失败，e{}", e);
			return false;
		}
		return true;
	}

	@RequestMapping("/batchDelete")
	public boolean batchDelete(@RequestParam List<Integer> ids) {
		log.info("删除图书", ids);
		try {
			Integer result = bookService.batchDelete(ids);
			if (result <= 0) {
				return false;
			}
		} catch (Exception e) {
			log.error("批量删除操作失败ids:{},e:{}", ids, e);
			return false;
		}
		return true;
	}
}
