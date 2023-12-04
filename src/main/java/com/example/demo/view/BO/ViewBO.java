package com.example.demo.view.BO;

import org.springframework.stereotype.Service;

@Service
public class ViewBO {
	public void addViewByUserIdPostId(int userId, int postId, int serverUserId) {
		viewMapper.insertViewByUserIdPostId(userId, postId, serverUserId);
	}
}
