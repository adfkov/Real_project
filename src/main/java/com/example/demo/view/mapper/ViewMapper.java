package com.example.demo.view.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewMapper {
	public void insertViewByUserIdPostId(
			@Param("userId") int userId
			,@Param("postId") int postId
			,@Param("serverUserId") int serverUserId);
	
	public int selectViewByUserIdPostId(
			@Param("userId") int userId
			,@Param("postId") int postId);
}
