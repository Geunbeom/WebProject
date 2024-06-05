package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.LikeBoard;
import com.project.model.dto.RoutineBoard;
import com.project.model.service.LikeBoardService;

@RestController
@RequestMapping("/api-like")
public class LikeRestController {
	
	private final LikeBoardService service;
	
	@Autowired
	public LikeRestController(LikeBoardService service) {
		this.service = service;
	}
	
	@GetMapping("/board/{board}")
	public ResponseEntity<?> getBoardLike(@PathVariable("board") int boardId) {
		return new ResponseEntity<List<LikeBoard>>(service.getBoardLike(boardId), HttpStatus.OK);
	}

	@GetMapping("/user/{user}")
	public ResponseEntity<?> getBoardLike(@PathVariable("user") String userId) {
		return new ResponseEntity<List<RoutineBoard>>(service.getUserLike(userId), HttpStatus.OK);
	}
	
	@GetMapping("/check")
	public ResponseEntity<?> likeCheck(@ModelAttribute LikeBoard info) {
		return new ResponseEntity<Integer>(service.likeCheck(info), HttpStatus.OK);
	}
	
	@DeleteMapping("/unLike")
	public ResponseEntity<?> unLike(@ModelAttribute LikeBoard info) {
		service.unLike(info);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/like")
	public ResponseEntity<?> likeBoard(@RequestBody LikeBoard info) {
		service.likeBoard(info);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
