package com.example.demo.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.comment.domain.CommentView;

@Repository
public interface CommentMapper {
	
	public void insertCommentByPostUserIdPostId(
			@Param("postUserId") int postUserId, 
			@Param("postId") int postId, 
			@Param("userId") int userId
			,@Param("commentText") String commentText);
	
	public List<CommentView> selectCommentListByPostUserIdPostId(
			@Param("postUserId") int postUserId, 
			@Param("postId") int postId);	
}
