package com.example.demo.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.post.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{
	public List<PostEntity> findAllByUserId(Integer userId);
	
	public PostEntity findAllByUserIdAndId(int userId, int postId);
}
