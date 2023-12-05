package com.example.demo.comment.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
	
	public void insertCommentByPostUserIdPostId(
			@Param("postUserId") int postUserId, 
			@Param("postId") int postId, 
			@Param("userId") int userId
			,@Param("commentText") String commentText);
}
