package com.example.demo.postLike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.postLike.domain.PostLiker;

@Repository
public interface PostLikeMapper {
	public void insertPostLikeByUserIdPostId(
			@Param("postUserId") int postUserId
			,@Param("postId") int postId
			,@Param("userId") int userId);
	
	public int selectPostLikeCountByUserIdPostId(
			@Param("postUserId") int postUserId,
			@Param("postId") int postId
			, @Param("userId") Integer userId);
	
//	public int selectIfPostLikeByUserIdPostId(
//			@Param("postUserId") int postUserId,
//			@Param("postId") int postId,
//			@Param("userId") int userId);
	
	public void deletePostLikeByUserIdPostId(
			@Param("postUserId") int postUserId
			,@Param("postId") int postId
			,@Param("userId") int userId);
	
	public List<PostLiker> selectPostLikerByUserIdPostId(
			@Param("postUserId") int postUserId
			,@Param("postId") int postId);

}
