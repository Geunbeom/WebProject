package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.RoutineBoardReply;
import com.project.model.service.RoutineBoardReplyService;

@RestController
@RequestMapping("/routineboardreply")
public class RoutineBoardReplyRestController {
	
	private final RoutineBoardReplyService service;
	
	@Autowired
	public RoutineBoardReplyRestController(RoutineBoardReplyService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> routineBoardReplyList(@PathVariable("id") int id) {
		return new ResponseEntity<List>(service.getRoutineBoardReplyList(id), HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> routineBoardReplyCreate(@PathVariable("id") int id, @RequestBody RoutineBoardReply routineBoardReply) {
		routineBoardReply.setBoardId(id);
		service.createRoutineBoardReply(routineBoardReply);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/reply/{rid}")
	public ResponseEntity<?> routineBoardReplyDetail(@PathVariable("rid") int rid) {
		return new ResponseEntity<RoutineBoardReply>(service.getRoutineBoardReply(rid), HttpStatus.OK);
	}
	
	@DeleteMapping("/reply/{rid}")
	public ResponseEntity<?> routineBoardReplyDelete(@PathVariable("rid") int rid) {
		service.deleteRoutineBoardReply(rid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/reply")
	public ResponseEntity<?> routineBoardUpdate(@RequestBody RoutineBoardReply routineBoardReply) {
		service.putRoutineBoardReply(routineBoardReply);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
}
