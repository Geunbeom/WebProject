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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;
import com.project.model.service.RoutineBoardService;

@RestController
@RequestMapping("/routineboard")
public class RoutineBoardRestController {
	
	private final RoutineBoardService service;
	
	@Autowired
	public RoutineBoardRestController(RoutineBoardService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public ResponseEntity<?> routineBoardList() {
		return new ResponseEntity<List>(service.getRoutineBoardList(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> routineBoardCreate(@RequestBody RoutineBoard routineBoard) {
		service.createRoutineBoard(routineBoard);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> routineBoardDetail(@PathVariable("id") int id) {
		return new ResponseEntity<RoutineBoard>(service.getRoutineBoard(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> routineBoardDelete(@PathVariable("id") int id) {
		service.deleteRoutineBoard(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<?> routineBoardUpdate(@RequestBody RoutineBoard routineBoard) {
		service.putRoutineBoard(routineBoard);
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
