package com.ssafy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.model.dto.Review;
import com.ssafy.project.model.dto.SearchCondition;
import com.ssafy.project.model.dto.User;
import com.ssafy.project.model.dto.Video;
import com.ssafy.project.model.service.ReviewService;
import com.ssafy.project.model.service.UserService;
import com.ssafy.project.model.service.VideoService;

@RestController
@RequestMapping("/project")
public class ProjectRestController {
	
	private final VideoService vService;
	private final ReviewService rService;
	private final UserService uService;
	
	@Autowired
	public ProjectRestController(ReviewService rService, VideoService vService, UserService uService) {
		this.vService = vService;
		this.rService = rService;
		this.uService = uService;
	}
	
	@GetMapping("/video")
	public ResponseEntity<?> videoList() {
		return new ResponseEntity<List>(vService.getList(), HttpStatus.OK);
	}
	
	@GetMapping("/video/{id}")
	public ResponseEntity<?> videoDetail(@PathVariable("id") int id) {
		return new ResponseEntity<Video>(vService.getVideo(id), HttpStatus.OK);
	}
	
	@GetMapping("/review/{vid}")
	public ResponseEntity<?> reviewList(@PathVariable("vid") int vid) {
		return new ResponseEntity<List>(rService.getList(vid), HttpStatus.OK);
	}
	
	@GetMapping("/review/{vid}/{rid}")
	public ResponseEntity<?> reviewDetail(@PathVariable("vid") int vid, @PathVariable("rid") int rid) {
		return new ResponseEntity<Review>(rService.getReview(vid, rid), HttpStatus.OK);
	}
	
	@PostMapping("/review/{vid}")
	public ResponseEntity<?> insertReview(@PathVariable("vid")int vid, @RequestBody Review review) {
		review.setVideoId(vid);
		rService.writeReview(review);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/review/{vid}/{rid}")
	public ResponseEntity<?> updateReview(@PathVariable("vid") int vid, @PathVariable("rid") int rid, @RequestBody Review review) {
		review.setVideoId(vid);
		review.setReviewId(rid);
		rService.modifyReview(review);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/review/{vid}/{rid}")
	public ResponseEntity<?> deleteReview(@PathVariable("vid") int vid, @PathVariable("rid") int rid) {
		rService.removeReview(vid, rid);
		return new ResponseEntity<String>("삭제완료", HttpStatus.OK);
	}
	
	
	@GetMapping("/user")
	public ResponseEntity<?> userList() {
		return new ResponseEntity<List<User>>(uService.getUserList(), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> regist(@RequestBody User user) {
		uService.regist(user);
		return new ResponseEntity<String>("등록완료", HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> searchId(@PathVariable("id") String id) {
		return new ResponseEntity<User>(uService.searchUser(id), HttpStatus.OK);
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User loginUser = uService.searchUser(user.getId());
		if(loginUser != null && user.getId().equals(loginUser.getId()) && user.getPassword().equals(loginUser.getPassword())) {
			return new ResponseEntity<String>("로그인 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("로그인 실패", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/review/search/{vid}")
	public ResponseEntity<?> searchByCondition (@PathVariable("vid")int vid, @ModelAttribute SearchCondition searchCon) {
		searchCon.setVideoId(vid);
		return new ResponseEntity<List>(rService.searchByCon(searchCon), HttpStatus.OK);
	}
	
	
}
