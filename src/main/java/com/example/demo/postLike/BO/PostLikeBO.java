package com.example.demo.postLike.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.postLike.domain.PostLiker;
import com.example.demo.postLike.mapper.PostLikeMapper;

@Service
public class PostLikeBO {
	@Autowired
	private PostLikeMapper postLikeMapper;
	
	public void postLikeByUserIdPostId(int postUserId,int postId, int userId) {
		postLikeMapper.insertPostLikeByUserIdPostId(postUserId, postId, userId);
	}
	
	public int getPostLikeCountByUserIdPostId(int postUserId, int postId, Integer userId) {
		return postLikeMapper.selectPostLikeCountByUserIdPostId(postUserId, postId, userId);
	}
	
	
	public void tellLikeToggle(int postUserId, int postId, int userId) {
		  
		if(postLikeMapper.selectPostLikeCountByUserIdPostId(postUserId, postId,userId) == 0) {
			postLikeMapper.insertPostLikeByUserIdPostId(postUserId,postId, userId);
		} else {
			postLikeMapper.deletePostLikeByUserIdPostId(postUserId,postId, userId);	
		}
		 
	}
	
	public boolean filledLike(int postUserId ,int postId, Integer userId) {
		// 비로그인
		if(userId == null) {			
			return false;
		} 
		return postLikeMapper.selectPostLikeCountByUserIdPostId(postUserId,postId, userId) > 0;
		
	}
//	public boolean getIfPostLikeByUserIdPostId(int postUserId,int postId, int userId) {
//		if(postLikeMapper.selectIfPostLikeByUserIdPostId(postUserId, postId, userId) >= 1) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	// 좋아요 취소
//	public void deleteLikeByUserIdPostId(int postUserId, int postId, int userId) {
//		postLikeMapper.deletePostLikeByUserIdPostId(postUserId, postId, userId);
//	}
	
	// 좋아요한 사람들 불러오기
	public List<PostLiker> getPostLikersByPostUserIdPostId(int postUserId, int postId) {
		return postLikeMapper.selectPostLikerByUserIdPostId(postUserId, postId);
	}
}
