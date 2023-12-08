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
			// view
			
			// comment
			List<CommentView> commentViewList = new ArrayList<>();
			CommentView commentView = new CommentView();

			List<Comment> commentList = commentBO.getCommentListByPostUserIdPostId(postUserId, post.getId());
			
			for(Comment comment : commentList) {
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
	}
	
	/*
	 * public RecipeView getRecipeViewByUserIdAndPostId(Integer postUserId, int
	 * postId) { RecipeView recipeView = new RecipeView();
	 * 
	 * UserEntity user = userBO.getUserEntityById(postUserId);
	 * recipeView.setUser(user);
	 * 
	 * PostEntity post = postBO.getPostpageByUserIdAndPostId(postUserId, postId);
	 * recipeView.setPost(post);
	 * 
	 * int userPostLikeCount = postLikeBO.getPostLikeCountByUserIdPostId(postUserId,
	 * post.getId(), null); recipeView.setPostLikeCount(userPostLikeCount);
	 * 
	 * // postLiker
	 * 
	 * // view
	 * 
	 * // comment List<CommentView> commentViewList = new ArrayList<>(); CommentView
	 * commentView = new CommentView();
	 * 
	 * List<Comment> commentList =
	 * commentBO.getCommentListByPostUserIdPostId(postUserId, post.getId());
	 * 
	 * for(Comment comment : commentList) { UserEntity commentUser =
	 * userBO.getUserEntityById(comment.getUserId());
	 * commentView.setUser(commentUser); commentView.setComment(comment);
	 * commentViewList.add(commentView); }
	 * recipeView.setCommentViewList(commentViewList);
	 * 
	 * // 팔로워 FollowerList followerList = new FollowerList();
	 * followerList.setFollowedUserId(postUserId); List<Follower> followers =
	 * likeBO.getFollowersList(postUserId);
	 * 
	 * List<UserEntity> list = new ArrayList<>();
	 * 
	 * for(Follower follower : followers) { UserEntity followingUser =
	 * userBO.getUserEntityById(follower.getFollowingUserId());
	 * list.add(followingUser); } followerList.setFollowers(list); // 팔로워 리스트 완성
	 * 
	 * recipeView.setFollowerList(followerList);
	 * 
	 * return recipeView; }
	 */
}
/*
 * public class LikeBO {
 * 
 * @Autowired private LikeMapper likeMapper;
 * 
 * public void tellLikeToggle(int postId, int userId) {
 * 
 * if(likeMapper.selectLikeCountByPostIdOrUserId(postId, userId) == 0) {
 * likeMapper.insertLikeToggle(postId, userId); } else {
 * likeMapper.deleteLikeToggle(postId, userId); }
 * 
 * }
 * 
 * // INPUT: 글번호 / OUTPUT: 개수(COUNT) public int getLikeCountByPostId(int postId)
 * { return likeMapper.selectLikeCountByPostIdOrUserId(postId, null); }
 * 
 * // input: 글번호 ,userId(Integer) output: 채워진지 여부(boolean) public boolean
 * filledLike(int postId, Integer userId) { // 비로그인 if(userId == null) { return
 * false; } return likeMapper.selectLikeCountByPostIdOrUserId(postId, userId) >
 * 0;
 * public List<CardView> generateCardViewList(Integer userId) {
		List<CardView> cardViewList = new ArrayList<>();
		// post로 내리고 있던 것을 cardView 로 변환한다.
		
		// 글 목록을 가져온다. List<PostEntity>를 
		List<PostEntity> postList = postBO.getPostList();
		//
		
		// 반복문으로 순회
		// postEntity => CardView -> cardViewList에 담는다.
		for(PostEntity post: postList) {
			CardView cardView = new CardView();
			cardView.setPost(post);
			
			UserEntity user = userBO.findById(post.getUserId());
			cardView.setUser(user);
			
			// 댓글들
			List<CommentView> commentList = commentBO.generateCommentViewListByPostId(post.getId());
			cardView.setCommentList(commentList);
			
			// 좋아요 카운트
			int likeCount = likeBO.getLikeCountByPostId(post.getId());
			cardView.setLikeCount(likeCount);
			
			// 내가 좋아요 눌렀는지 여부
			// false: 비로그인 또는 누르지 않았을 때
			boolean filledLike = likeBO.filledLike(post.getId(), userId);
			cardView.setFilledLike(filledLike);
			
			// ★★★★★★ 마지막에 CardViewList에 card를 넣는다.
			cardViewList.add(cardView);
			
			
		}
		
		
		
			return cardViewList;
 * }
 * 
 * 
 * }
 */