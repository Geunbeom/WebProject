package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.FreeBoard;
import com.project.model.dto.FreeBoardReply;
import com.project.model.service.FreeBoardReplyService;
import com.project.model.service.FreeBoardService;

@RestController
@RequestMapping("/freeboardreply")
public class FreeBoardReplyRestController {
	
	private final FreeBoardReplyService service;
	
	@Autowired
	public FreeBoardReplyRestController(FreeBoardReplyService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> freeBoardReplyList(@PathVariable("id") int id) {
		return new ResponseEntity<List>(service.getFreeBoardReplyList(id), HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> freeBoardReplyCreate(@PathVariable("id") int id, @RequestBody FreeBoardReply freeBoardReply) {
		freeBoardReply.setBoardId(id);
		service.createFreeBoardReply(freeBoardReply);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/reply/{rid}")
	public ResponseEntity<?> freeBoardReplyDetail(@PathVariable("rid") int rid) {
		return new ResponseEntity<FreeBoardReply>(service.getFreeBoardReply(rid), HttpStatus.OK);
	}
	
	@DeleteMapping("/reply/{rid}")
	public ResponseEntity<?> freeBoardReplyDelete(@PathVariable("rid") int rid) {
		service.deleteFreeBoardReply(rid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/reply")
	public ResponseEntity<?> freeBoardUpdate(@RequestBody FreeBoardReply freeBoardReply) {
		service.putFreeBoardReply(freeBoardReply);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
}
