package com.example.demo.like.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.like.domain.Follower;
import com.example.demo.like.mapper.LikeMapper;

@Service
public class LikeBO {
	@Autowired
	private LikeMapper likeMapper;
	
	public void followUserById(int followingUserId, int followedUserId) {
		likeMapper.followUserById(followingUserId, followedUserId);
	}
	
	public boolean isFollowingCheck(int followingUserId, int followedUserId) {
		int count = likeMapper.isFollowingCheck(followingUserId, followedUserId);
		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void unfollowUserById(int followingUserId, int followedUserId) {
		likeMapper.deleteFollowById(followingUserId, followedUserId);
	}
	
	public int getFollowerCount(int userId) {
		return likeMapper.selectFollowerCount(userId);
	}
	
	public List<Follower> getFollowersList(int postUserId) {
		return likeMapper.selectFollowersList(postUserId);
	}
}
