package com.example.demo.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.like.BO.LikeBO;
import com.example.demo.view.BO.ViewBO;

@RestController
@RequestMapping("/like")
public class LikeRestController {
	@Autowired
	private LikeBO likeBO;
	@Autowired
	private ViewBO viewBO;
	// 팔로우 기능
	@PostMapping("/follow-user")
	public Map<String, Object> followUser(
			@RequestParam("followingUserId") int followingUserId
			,@RequestParam("followedUserId") int followedUserId,
			@RequestParam("postId") int postId
			){
		Map<String, Object> result = new HashMap<>();
		
		// db insert
		likeBO.followUserById(followingUserId, followedUserId);
		viewBO.minusViewByUserIdPostId(followedUserId, postId, followingUserId);
		
		result.put("followingUserId", followingUserId);
		result.put("code", 200);
		
		return result;
	}
	
	// 팔로우 여부 확인
	@PostMapping("/is-following")
	public Map<String, Object> isFollowingCheck(
			@RequestParam("followingUserId") int followingUserId
			,@RequestParam("followedUserId") int followedUserId) {
		Map<String, Object> result = new HashMap<>();
		// db select
		boolean isFollowing = likeBO.isFollowingCheck(followingUserId, followedUserId);
		
		
		result.put("isFollowing", isFollowing);
		
		return result;
		}


	@DeleteMapping("/unfollow")
	public Map<String, Object> unfollowById(
			@RequestParam("followingUserId") int followingUserId
			,@RequestParam("followedUserId") int followedUserId
			,@RequestParam("postId") int postId
			,HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		// db delete
		likeBO.unfollowUserById(followingUserId, followedUserId);

		viewBO.minusViewByUserIdPostId(followedUserId, postId, followingUserId);
		
		result.put("code", 200);
		return result;
	}
	
	@PostMapping("/get-follower-count")
	public Map<String, Object> getFollowerCount(
			@RequestParam("userId") int userId) {
		Map<String, Object> result = new HashMap<>();
		
		int followerCount = likeBO.getFollowerCount(userId);
		
		result.put("followerCount", followerCount);
		
		return result;
		
		
	}
}
