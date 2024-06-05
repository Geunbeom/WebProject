package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.UserInfo;
import com.project.model.service.UserInfoService;

@RestController
@RequestMapping("/api-userInfo")
public class UserInfoRestController {
	
	private final UserInfoService service;
	
	@Autowired
	public UserInfoRestController(UserInfoService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getInfo(@PathVariable("id") String id) {
		return new ResponseEntity<UserInfo>(service.getInfo(id), HttpStatus.OK);
	}
	
	@GetMapping("/rank")
	public ResponseEntity<?> getRankList() {
		return new ResponseEntity<List>(service.getRankList(), HttpStatus.OK);
	}
	
	@PostMapping("/regist")
	public ResponseEntity<?> registInfo(@RequestBody UserInfo info) {
		service.registInfo(info);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/mileage")
	public ResponseEntity<?> mileageModify(@RequestBody UserInfo info) {
		service.mileageModify(info);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/exp")
	public ResponseEntity<?> expModify(@RequestBody UserInfo info) {
		UserInfo currUser = service.getInfo(info.getId());
		UserInfo afterUser = service.expModify(info);
		if (currUser.getExp() < 1000 && afterUser.getExp() >= 1000) {
			service.rateUp(afterUser);
		}
		if (currUser.getExp() < 3000 && afterUser.getExp() >= 3000) {
			service.rateUp(afterUser);
		}
		if (currUser.getExp() < 7000 && afterUser.getExp() >= 7000) {
			service.rateUp(afterUser);
		}
		if (currUser.getExp() < 12000 && afterUser.getExp() >= 12000) {
			service.rateUp(afterUser);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/highscore")
	public ResponseEntity<?> highscoreModify(@RequestBody UserInfo info) {
		service.highscoreModify(info);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/highscore/rank")
	public ResponseEntity<?> highscoreRank(){
		return new ResponseEntity<List>(service.highscoreRank(), HttpStatus.OK);
	}
	
}
