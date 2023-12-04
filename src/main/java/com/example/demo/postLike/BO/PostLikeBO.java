package com.example.demo.postLike.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.postLike.mapper.PostLikeMapper;

@Service
public class PostLikeBO {
	@Autowired
	private PostLikeMapper postLikeMapper;
	
	public void postLikeByUserIdPostId(int postUserId,int postId, int userId) {
		postLikeMapper.insertPostLikeByUserIdPostId(postUserId, postId, userId);
	}
	
	public int getPostLikeCountByUserIdPostId(int postUserId, int postId) {
		return postLikeMapper.selectPostLikeCountByUserIdPostId(postUserId, postId);
	}
	
	public boolean getIfPostLikeByUserIdPostId(int postUserId,int postId) {
		if(postLikeMapper.selectIfPostLikeByUserIdPostId(postUserId, postId) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void deleteLikeByUserIdPostId(int postUserId, int postId, int userId) {
		postLikeMapper.deletePostLikeByUserIdPostId(postUserId, postId, userId);
	}
}
