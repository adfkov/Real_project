package com.example.demo.post.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.FileManagerService;
import com.example.demo.post.entity.PostEntity;
import com.example.demo.post.repository.PostRepository;
import com.example.demo.user.BO.UserBO;
import com.example.demo.user.Entity.UserEntity;

@Service
public class PostBO {
	@Autowired
	private UserBO userBO;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private FileManagerService fileManager;
	
	public Integer addRecipe(int userId
			,String subject
			,String intro
			,String foodTypeId
			,String ingredientId
			,String portion
			,String degree
			,MultipartFile file
			,String ingredient
			,String cookStepText
			,String cookTip) {
		
		UserEntity user = userBO.getUserEntityById(userId);
		
		String mainImageUrl = null;
		
		if(file != null) {
			mainImageUrl = fileManager.saveFile(user.getLoginId(), file);
		}
		
		PostEntity postEntity = postRepository.save(
				PostEntity.builder()
				.userId(userId)
				.subject(subject)
				.intro(intro)
				.foodTypeId(foodTypeId)
				.ingredientId(ingredientId)
				.portion(portion)
				.degree(degree)
				.mainImageUrl(mainImageUrl)
				.ingredient(ingredient)
				.cookStepText(cookStepText)
				.cookTip(cookTip)
				.build());
		return postEntity == null? null : postEntity.getId();
	}
	
	public List<PostEntity> getUserPost(Integer userId) {
		return postRepository.findAllByUserId(userId);
		
	}
	
	
	public PostEntity getPostpageByUserIdAndPostId(int userId,int postId) {
		return postRepository.findAllByUserIdAndId(userId, postId);
	}
	
	public List<PostEntity> getAllPost() {
		return postRepository.findAll();
	}
	
	public void deletePost(int postUserId, int postId) {
		postRepository.deleteByUserIdAndId(postUserId, postId);
	}
	
}
	