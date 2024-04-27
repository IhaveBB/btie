package com.nicebao.springbook.mapper;

import com.nicebao.springbook.model.BookInfo;
import com.nicebao.springbook.model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface BookInfoMapper {
	@Insert("insert into book_info (book_name,author," +
			"count,price,publish) values (#{bookName},#{author},#{count},#{price},#{publish})")
	Integer insertBook(BookInfo bookInfo);

	@Select("select count(1) from book_info where `status` <> 0")
	Integer count();

	@Select("select * from book_info where `status` <>0 order by id desc limit" +
			" #{offset},#{pageSize}")
	List<BookInfo> queryListByPage(PageRequest pageRequest);

	@Select("select * from book_info where `status`<>0 and id = #{id};")
	BookInfo queryBookByID(Integer id);

	Integer updateBook(BookInfo bookInfo);

	Integer batchDelete(List<Integer> ids);


}
