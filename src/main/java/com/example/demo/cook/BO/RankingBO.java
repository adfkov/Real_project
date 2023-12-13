package com.example.demo.cook.BO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cook.domain.RankingView;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.cook.domain.sort.RankingViewByViewComparator;
import com.example.demo.like.domain.FollowerList;
import com.example.demo.postLike.domain.PostLiker;
import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;

@Service
public class RankingBO {
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private UserBO userBO;

	// 글이 없고 팔로우만 있는 경우가 생긴다.
	public List<RankingView> getRankingView() {
		List<RankingView> rankingViewList = new ArrayList<>();

		List<UserEntity> userList = userBO.getAllUserList();

		for (UserEntity user : userList) {
			// 팔로우 카운트 가져오면 좋은데..
			RankingView rankingView = new RankingView();
			//
			rankingView.setUserId(user.getId());
			rankingView.setProfileImageUrl(user.getProfileImageUrl());
			rankingView.setUserNickName(user.getNickName());
			rankingView.setGrade(user.getGrade());
			rankingView.setInterest(user.getInterest());
			/* ---------------------------유저 정보 끝-------------------------- */
			List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(user.getId());
			int postCount = 0;
			int viewCount = 0;
			int postLikeCount = 0;
			int followerCount = 0;
			for (RecipeView recipeView : recipeViewList) {
				followerCount = 0;
				postCount++;
				/////////////////// 글 수 끝 /////////////////
				viewCount += recipeView.getView(); // 총 조회수
				List<PostLiker> postLiker = recipeView.getPostLiker();
				for (PostLiker liker : postLiker) {
					postLikeCount += 1; // 총 추천 수
				}
				FollowerList followerList = recipeView.getFollowerList();
				List<UserEntity> followers = followerList.getFollowers();
				for (UserEntity follower : followers) {
					followerCount++;
				}
			}

			rankingView.setPostCount_sum(postCount);
			rankingView.setViewCount_sum(viewCount);
			rankingView.setPostLikeCount_sum(postLikeCount);
			rankingView.setFollowerCount(followerCount);

			rankingViewList.add(rankingView);
		}

		return rankingViewList;
	}

	// 정렬 용
	public List<RankingView> getRankingViewByAlignId(int alignId) {
		List<RankingView> rankingViewList = new ArrayList<>();
		
		List<UserEntity> userList = userBO.getAllUserList();
		
		for(UserEntity user : userList) {
			// 팔로우 카운트 가져오면 좋은데..
			RankingView rankingView = new RankingView();
			// 
			rankingView.setUserId(user.getId());
			rankingView.setProfileImageUrl(user.getProfileImageUrl());
			rankingView.setUserNickName(user.getNickName());
			rankingView.setGrade(user.getGrade());
			rankingView.setInterest(user.getInterest());		
		/* ---------------------------유저 정보 끝--------------------------*/
			List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(user.getId());
			int postCount = 0;
			int viewCount = 0;
			int postLikeCount = 0;
			int followerCount = 0;
			for(RecipeView recipeView : recipeViewList) {
				followerCount = 0;
				postCount++;
			/////////////////// 글 수 끝 /////////////////
				viewCount += recipeView.getView(); // 총 조회수
				List<PostLiker> postLiker = recipeView.getPostLiker(); 
				for(PostLiker liker: postLiker) {
					postLikeCount += 1; // 총 추천 수
				}
				FollowerList followerList = recipeView.getFollowerList();
				List<UserEntity> followers = followerList.getFollowers();
				for(UserEntity follower : followers) {
					followerCount++;
				}
			}
		
			
			rankingView.setPostCount_sum(postCount);
			rankingView.setViewCount_sum(viewCount);
			rankingView.setPostLikeCount_sum(postLikeCount);
			rankingView.setFollowerCount(followerCount);
			
			rankingViewList.add(rankingView);
		}
		
			if(alignId == 1) // 조회 
			{
				Collections.sort(rankingViewList, new RankingViewByViewComparator().reversed()); 
			}
		
			return rankingViewList;
	}
	
	}
