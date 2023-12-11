package com.example.demo.cook.BO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cook.domain.RankingView;
import com.example.demo.cook.domain.RecipeView;
import com.example.demo.like.domain.FollowerList;
import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;

@Service
public class RankingBO {
	@Autowired
	private RecipeBO recipeBO;
	@Autowired
	private UserBO userBO;
	
	public List<RankingView> getRankingView() {
	List<RankingView> rankingViewList = new ArrayList<>();

	List<UserEntity> allUserList = userBO.getAllUserList();
	for(UserEntity user : allUserList) {
		RankingView rankingView = new RankingView();
		// postCount_sum.viewCount_sum.postLikeCount_sum
		int postCount_sum = rankingView.getPostCount_sum();
		int viewCount_sum = rankingView.getViewCount_sum();
		int postLikeCount_sum = rankingView.getPostLikeCount_sum();
		
		rankingView.setUserNickName(user.getNickName());
		rankingView.setGrade(user.getGrade());
		rankingView.setProfileImageUrl(user.getProfileImageUrl());
		rankingView.setInterest(user.getInterest());
	
		/* 
		  유저의 아이디로 recipeBO 에서 recipeView generate
		 */
		List<RecipeView> recipeViewList = recipeBO.generateRecipeViewList(user.getId());
		if(recipeViewList.isEmpty() == false) {
			rankingView.setFollowerList(recipeViewList.get(0).getFollowerList()); 
		}
	
		// 글 여러 개
		if(recipeViewList.isEmpty()) {
			return null;
		}
		for(RecipeView recipeView: recipeViewList) {
			// 숫자 카운팅
				postCount_sum += 1;
				viewCount_sum += recipeView.getView();
				postLikeCount_sum += recipeView.getPostLikeCount();
				rankingView.setPostCount_sum(postCount_sum);
				rankingView.setViewCount_sum(viewCount_sum);
				rankingView.setPostLikeCount_sum(postLikeCount_sum);
			}
				rankingViewList.add(rankingView);
			}
			return rankingViewList;
			}
		}
