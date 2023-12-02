package com.example.demo.like.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeMapper {
	public void followUserById(@Param("followingUserId") int followingUserId
			,@Param("followedUserId") int followedUserId); 
	
	public int isFollowingCheck(@Param("followingUserId") int followingUserId
			,@Param("followedUserId") int followedUserId);
	
	public void deleteFollowById(@Param("followingUserId") int followingUserId
			,@Param("followedUserId") int followedUserId);
	
	public int selectFollowerCount(int userId);
}
