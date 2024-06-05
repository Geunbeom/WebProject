package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.FreeBoard;
import com.project.model.dto.Routine;
import com.project.model.service.RoutineService;

@RestController
@RequestMapping("/routine")
public class RoutineRestController {
	
	private final RoutineService service;
	
	@Autowired
	public RoutineRestController(RoutineService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public ResponseEntity<?> routineList() {
		return new ResponseEntity<List<Routine>>(service.getRoutineList(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> routineDetail(@PathVariable("id") int id) {
		return new ResponseEntity<Routine>(service.getRoutine(id), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> routineCreate(@RequestBody Routine routine) {
		service.createRoutine(routine);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
