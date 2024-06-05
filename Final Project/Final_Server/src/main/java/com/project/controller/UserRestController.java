package com.project.controller;

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

import com.project.model.dto.User;
import com.project.model.service.UserService;

@RestController
@RequestMapping("/api-user")
public class UserRestController {
	
	private final UserService service;
	
	@Autowired
	public UserRestController(UserService service) {
		this.service = service;
	}
	
	// 유저 정보를 가져온다.
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id")String id) {
		return new ResponseEntity<User>(service.getUser(id), HttpStatus.OK);
	}
	
	// 로그인을 한다.
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User user) {
		if (service.doLogin(user))
			return new ResponseEntity<String>(user.getName(), HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>("로그인 실패", HttpStatus.BAD_REQUEST);
	}
	
	// 회원 등록
	@PostMapping("/regist")
	public ResponseEntity<?> doRegist(@RequestBody User user) {
		if (service.getUser(user.getId()) != null) {
			return new ResponseEntity<String>(" 아이디가 중복됩니다. \n 아이디를 수정해주세요.", HttpStatus.BAD_REQUEST);
		}else if(service.searchNickName(user.getNickName()) != null) {
			return new ResponseEntity<String>(" 닉네임이 중복됩니다. \n 닉네임을 수정해주세요.", HttpStatus.BAD_REQUEST);
		}else {
			service.doRegist(user);
			return new ResponseEntity<String>("등록 성공", HttpStatus.CREATED);
		}
	}
	
	// 회원 정보 수정.
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		String currNickname = service.searchNickName(user.getNickName());
		if (currNickname != null && !currNickname.equals(user.getId())) {
			return new ResponseEntity<String>("닉네임이 중복됩니다.", HttpStatus.BAD_REQUEST);
		}else {
			service.doUpdate(user);
			return new ResponseEntity<String>("수정 성공", HttpStatus.ACCEPTED);
		}
	}
	
	
}
