package com.example.demo.cook.BO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.comment.BO.CommentBO;
import com.example.demo.comment.domain.Comment;
import com.example.demo.comment.domain.CommentView;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.like.BO.LikeBO;
import com.example.demo.like.domain.Follower;
import com.example.demo.like.domain.FollowerList;
import com.example.demo.post.BO.PostBO;
import com.example.demo.post.entity.PostEntity;
import com.example.demo.postLike.BO.PostLikeBO;
import com.example.demo.postLike.domain.PostLiker;
import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;
import com.example.demo.view.BO.ViewBO;

@Service
public class RecipeBO {
	@Autowired
	private UserBO userBO;
	@Autowired
	private PostBO postBO;

	@Autowired
	private PostLikeBO postLikeBO;
	@Autowired
	private LikeBO likeBO;
	@Autowired
	private ViewBO viewBO;
	@Autowired
	private CommentBO commentBO;
	
	
	public List<RecipeView> generateRecipeViewList(Integer postUserId) {
		
		
		List<RecipeView> recipeViewList = new ArrayList<>();
		
 		List<PostEntity> postList = postBO.getUserPost(postUserId);
		
		if(postList.isEmpty() == false) {
			for(PostEntity post : postList) {
				RecipeView recipeView = new RecipeView();
				recipeView.setPost(post);
				
				UserEntity user = userBO.getUserEntityById(post.getUserId());
				recipeView.setUser(user);
				
				int userPostLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(postUserId, post.getId(), null);
				recipeView.setPostLikeCount(userPostLikeCount);
				
				// postLiker
				List<PostLiker> postLiker = postLikeBO.getPostLikersByPostUserIdPostId(postUserId, post.getId());
				recipeView.setPostLiker(postLiker);
				List<UserEntity> postLikerUser = new ArrayList<>();
				for(PostLiker liker : postLiker) {
					UserEntity userLike = userBO.getUserEntityById(liker.getUserId());
					postLikerUser.add(userLike);
				}
				recipeView.setPostLikerUser(postLikerUser);
				// view
				int view = viewBO.getViewByUserIdPostId(postUserId, post.getId());
				recipeView.setView(view);
				// comment
				List<CommentView> commentViewList = new ArrayList<>();
	
				List<Comment> commentList = commentBO.getCommentListByPostUserIdPostId(postUserId, post.getId());
				
				for(Comment comment : commentList) {
					CommentView commentView = new CommentView();
					UserEntity commentUser = userBO.getUserEntityById(comment.getUserId());
					commentView.setUser(commentUser);
					commentView.setComment(comment);
					commentViewList.add(commentView);
				}
				recipeView.setCommentViewList(commentViewList);
				
				// 팔로워 
				FollowerList followerList = new FollowerList();
				followerList.setFollowedUserId(postUserId);
				List<Follower> followers = likeBO.getFollowersList(postUserId);
			
				List<UserEntity> list = new ArrayList<>();
				
				for(Follower follower : followers) {
					UserEntity followingUser = userBO.getUserEntityById(follower.getFollowingUserId());
					list.add(followingUser);
				}
				followerList.setFollowers(list); // 팔로워 리스트 완성
				
				recipeView.setFollowerList(followerList);
				recipeViewList.add(recipeView);
					}
				return recipeViewList;
			} else {
				return recipeViewList;
			}
	}
	
	
	
	
	
	
	
	
	
	
	public List<RecipeView> generateRecipeViewListAll(Integer postUserId) {
		
		
		List<RecipeView> recipeViewList = new ArrayList<>();
		
		List<PostEntity> postList = postBO.getAllPost();
		
		
		if(postList.isEmpty() == false) {
			for(PostEntity post : postList) {
				RecipeView recipeView = new RecipeView();
				recipeView.setPost(post);
				
				UserEntity user = userBO.getUserEntityById(post.getUserId());
				recipeView.setUser(user);
				
				int userPostLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(post.getUserId(), post.getId(), null);
				recipeView.setPostLikeCount(userPostLikeCount);
				
				// postLiker
				List<PostLiker> postLiker = postLikeBO.getPostLikersByPostUserIdPostId(post.getUserId(), post.getId());
				recipeView.setPostLiker(postLiker);
				List<UserEntity> postLikerUser = new ArrayList<>();
				for(PostLiker liker : postLiker) {
					UserEntity userLike = userBO.getUserEntityById(liker.getUserId());
					postLikerUser.add(userLike);
				}
				recipeView.setPostLikerUser(postLikerUser);
				// view
				
				// comment
				List<CommentView> commentViewList = new ArrayList<>();
	
				List<Comment> commentList = commentBO.getCommentListByPostUserIdPostId(post.getUserId(), post.getId());
				
				for(Comment comment : commentList) {
					CommentView commentView = new CommentView();
					UserEntity commentUser = userBO.getUserEntityById(comment.getUserId());
					commentView.setUser(commentUser);
					commentView.setComment(comment);
					commentViewList.add(commentView);
				}
				recipeView.setCommentViewList(commentViewList);
				
				// 팔로워 
				FollowerList followerList = new FollowerList();
				followerList.setFollowedUserId(post.getUserId());
				List<Follower> followers = likeBO.getFollowersList(post.getUserId());
			
				List<UserEntity> list = new ArrayList<>();
				
				for(Follower follower : followers) {
					UserEntity followingUser = userBO.getUserEntityById(follower.getFollowingUserId());
					list.add(followingUser);
				}
				followerList.setFollowers(list); // 팔로워 리스트 완성
				
				recipeView.setFollowerList(followerList);
				recipeViewList.add(recipeView);
					}
			}
		return recipeViewList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	


