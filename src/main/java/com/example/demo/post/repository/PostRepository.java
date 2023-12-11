package com.example.demo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.post.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{
	public List<PostEntity> findAllByUserId(Integer userId);
	
	public PostEntity findAllByUserIdAndId(int userId, int postId);
	
	@Transactional
	public void deleteByUserIdAndId(int userId, int postId);
	
//	@Modifying(clearAutomatically = true) 
//	@Query("UPDATE post SET post.subject = :subject, post.intro = :intro, post.foodTypeId = :foodTypeId, post.ingredientId = :ingredientId, post.degree = :degree, post.mainImageUrl = :mainImageUrl, post.ingredient = :ingredient, post.cookStepText = :cookStepText, post.cookTip =:cookTip WHERE post.id =:postId AND post.userId =:userId ")
//	public int updateRecipe(
//					@Param("postId") int postId,
//					@Param("userId") int userId,
//					@Param("subject") String subject,
//					@Param("intro") String intro,
//					@Param("foodTypeId") String foodTypeId,
//					@Param("ingredientId") String ingredientId,
//					@Param("portion") String portion,
//					@Param("degree") String degree,
//					@Param(value="mainImageUrl") String mainImageUrl,
//					@Param("ingredient") String ingredient,
//					@Param("cookStepText") String cookStepText,
//					@Param("cookTip") String cookTip
//			);
	
	
	
}
