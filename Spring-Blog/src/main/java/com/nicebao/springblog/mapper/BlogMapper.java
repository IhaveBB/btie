package com.nicebao.springblog.mapper;

import com.nicebao.springblog.model.BlogInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BlogMapper {
	/** @description: 查询全部博客，根据创建时间排序
			* @param: java.util.List<com.nicebao.springblog.model.BlogInfo>
			* @return: java.util.List<com.nicebao.springblog.model.BlogInfo>
			* @author: IhaveBB
			* @date: 2024/4/13
			*/
	@Select("select * from blog where delete_flag = 0 order by create_time desc")
	List<BlogInfo> selectAllBlog();
	/** @description: 根据博客ID查询博客
			* @param: com.nicebao.springblog.model.BlogInfo
			* @return: com.nicebao.springblog.model.BlogInfo
			* @author: IhaveBB
			* @date: 2024/4/13
			*/
	@Select("select * from blog where delete_flag = 0 and id = #{blogId}")
	BlogInfo selectById(Integer blogId);

	Integer updateBlog(BlogInfo blogInfo);
	@Select("insert into blog(title,content,user_id)values (#{title},#{content},#{userId})")
	Integer insetBlog(BlogInfo blogInfo);

}
