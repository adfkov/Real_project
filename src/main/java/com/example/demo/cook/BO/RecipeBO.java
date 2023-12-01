package com.example.demo.cook.BO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cook.domain.RecipeView;
import com.example.demo.post.BO.PostBO;
import com.example.demo.post.entity.PostEntity;
import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;

@Service
public class RecipeBO {
	@Autowired
	private UserBO userBO;
	@Autowired
	private PostBO postBO;
	
	public List<RecipeView> generateRecipeViewList(Integer userId) {
		List<RecipeView> recipeViewList = new ArrayList<>();
		
		List<PostEntity> postList = postBO.getUserPost(userId);
		
		for(PostEntity post : postList) {
			RecipeView recipeView = new RecipeView();
			recipeView.setPost(post);
			
			UserEntity user = userBO.getUserEntityById(post.getUserId());
			recipeView.setUser(user);
			
			recipeViewList.add(recipeView);
		}
		
		return recipeViewList;
	}
	
	public RecipeView getRecipeView(Integer userId, int postId) {
		RecipeView recipeView = new RecipeView();
		
		UserEntity user = userBO.getUserEntityById(userId);
		recipeView.setUser(user);
		
		PostEntity post = postBO.getPostpageByUserIdAndPostId(userId, postId);
		recipeView.setPost(post);
		
		return recipeView;
	}
}
