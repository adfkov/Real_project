package com.example.demo.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.comment.domain.Comment;

@Repository
public interface CommentMapper {
	
	public void insertCommentByPostUserIdPostId(
			@Param("postUserId") int postUserId, 
			@Param("postId") int postId, 
			@Param("userId") int userId
			,@Param("commentText") String commentText);
	
	public List<Comment> selectCommentListByPostUserIdPostId(
			@Param("postUserId") int postUserId, 
			@Param("postId") int postId);	
	
	public void deleteCommentByIdsAndCommentText(
			@Param("postUserId") int postUserId, 
			@Param("postId") int postId, 
			@Param("userId") int userId
			,@Param("commentId") int commentId);
	public int updateCommentByIdsAndCommentText(
			@Param("postUserId") int postUserId, 
			@Param("postId") int postId, 
			@Param("commentId") int commentId
			,@Param("commentText") String commentText);
	
}
