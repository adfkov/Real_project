package com.example.demo.comment.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.comment.domain.Comment;
import com.example.demo.comment.mapper.CommentMapper;

@Service
public class CommentBO {
	@Autowired
	private CommentMapper commentMapper;

	public void addCommentByPostUserIdPostId(int postUserId, int postId, int userId, String commentText) {
		commentMapper.insertCommentByPostUserIdPostId(postUserId, postId, userId, commentText);
	}
	
	public List<Comment> getCommentListByPostUserIdPostId(int postUserId, int postId) {
		return commentMapper.selectCommentListByPostUserIdPostId(postUserId, postId);
	}
	
	public void deleteCommentByIdsAndCommentText(int postUserId, int postId, int userId, String commentText) {
		commentMapper.deleteCommentByIdsAndCommentText(postUserId, postId, userId, commentText);
	}

}