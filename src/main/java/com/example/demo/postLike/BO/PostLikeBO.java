package com.example.demo.postLike.BO;

import java.util.List;

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
	
	// 좋아요 취소
	public void deleteLikeByUserIdPostId(int postUserId, int postId, int userId) {
		postLikeMapper.deletePostLikeByUserIdPostId(postUserId, postId, userId);
	}
	
	// 좋아요한 사람들 불러오기
//	public List<Integer> getPostLikersByPostUserIdPostId(int postUserId, int postId) {
//		return selectPostLikersByPostUserIdPostId(postUserId, postId);
//	}
}
