package com.example.demo.view.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.view.mapper.ViewMapper;

@Service
public class ViewBO {
	@Autowired
	private ViewMapper viewMapper;
	
	public void addViewByUserIdPostId(int userId, int postId, int serverUserId) {
		viewMapper.insertViewByUserIdPostId(userId, postId, serverUserId);
	}
	
	public int getViewByUserIdPostId(int userId, int postId) {
		return viewMapper.selectViewByUserIdPostId(userId, postId);
	}
}
