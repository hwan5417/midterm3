package com.jjh.midterm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class PostService {

	@Autowired
	PostDao postDao;

	Logger logger = LogManager.getLogger();

	// 글쓰기
	public void post() {
		Post post = new Post();
		post.setUserId("17");
		post.setName("정재환");
		post.setContent("ㄹㄴㅇㄹㅇㄴㄴㅁㅇㄹㄴㅁㅇㄹㄴㅁㅇㄹㄴㅁㅇㄹㄴㅇㄹㄴㅇㅁㄹㄴ");
		postDao.addPost(post);
		logger.info("글을 등록했습니다.");
	}

	// 목록 최신 50개
	public void list() {
		List<Post> postList = postDao.listPosts(0, 50);
		logger.info(postList);
	}

	// 좋아요.
	public void like() {
		String postId = "40";
		postDao.likePost(postId);
		Post post = postDao.getPost(postId);
		logger.info(post);
	}

}