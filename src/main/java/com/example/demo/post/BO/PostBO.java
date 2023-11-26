package com.example.demo.post.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.post.entity.PostEntity;
import com.example.demo.post.repository.PostRepository;

@Service
public class PostBO {
	@Autowired
	private PostRepository postRepository;
	
	
	public Integer addRecipe(int userId
			,String subject
			,String intro
			,String foodTypeId
			,String ingredientId
			,String portion
			,String degree
			,String ingredient
			,String cookStepText
			,String cookTip) {
		
		PostEntity postEntity = postRepository.save(
				PostEntity.builder()
				.userId(userId)
				.subject(subject)
				.intro(intro)
				.foodTypeId(foodTypeId)
				.ingredientId(ingredientId)
				.portion(portion)
				.degree(degree)	
				.ingredient(ingredient)
				.cookStepText(cookStepText)
				.cookTip(cookTip)
				.build());
		return postEntity == null? null : postEntity.getId();
	}
}
