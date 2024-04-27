package com.nicebao.springbook.service;

import com.nicebao.springbook.enums.BookStautsEnums;
import com.nicebao.springbook.mapper.BookInfoMapper;
import com.nicebao.springbook.model.BookInfo;
import com.nicebao.springbook.model.PageRequest;
import com.nicebao.springbook.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
	@Autowired
	private BookInfoMapper bookInfoMapper;

	public Integer insertBook(BookInfo bookInfo) {
		return bookInfoMapper.insertBook(bookInfo);
	}


	public PageResult<BookInfo> getListByPage(PageRequest pageRequest) {
		Integer count = bookInfoMapper.count();
		List<BookInfo> bookInfos = bookInfoMapper.queryListByPage(pageRequest);
		for (BookInfo bookInfo : bookInfos) {
			bookInfo.setStateCN(BookStautsEnums.getDescByCode(bookInfo.getStatus()).getDesc());
		}
		return new PageResult<>(bookInfos, count, pageRequest);
	}

	public BookInfo queryBookById(Integer bookId) {
		return bookInfoMapper.queryBookByID(bookId);
	}

	public Integer updateBook(BookInfo bookInfo) {
		return bookInfoMapper.updateBook(bookInfo);
	}

	public Integer batchDelete(List<Integer> ids) {
		return bookInfoMapper.batchDelete(ids);
	}
}
