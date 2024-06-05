package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.FreeBoard;
import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;
import com.project.model.service.FreeBoardService;

@RestController
@RequestMapping("/freeboard")
public class FreeBoardRestController {
	
	private final FreeBoardService service;
	
	@Autowired
	public FreeBoardRestController(FreeBoardService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public ResponseEntity<?> freeBoardList() {
		return new ResponseEntity<List>(service.getFreeBoardList(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> freeBoardCreate(@RequestBody FreeBoard freeBoard) {
		service.createFreeBoard(freeBoard);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> freeBoardDetail(@PathVariable("id") int id) {
		return new ResponseEntity<FreeBoard>(service.getFreeBoard(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> freeBoardDelete(@PathVariable("id") int id) {
		service.deleteFreeBoard(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<?> freeBoardUpdate(@RequestBody FreeBoard freeBoard) {
		service.putFreeBoard(freeBoard);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> routineBoardSearch(@ModelAttribute SearchCondition searchCondition) {
		List<RoutineBoard> list = service.search(searchCondition);
		
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}
	
}
