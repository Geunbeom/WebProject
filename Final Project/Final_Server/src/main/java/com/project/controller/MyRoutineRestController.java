package com.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.dto.MyRoutine;
import com.project.model.dto.ResultAttend;
import com.project.model.dto.Routine;
import com.project.model.service.MyRoutineService;

@RestController
@RequestMapping("/api-myRoutine")
public class MyRoutineRestController {
	
	private final MyRoutineService service;
	
	@Autowired
	public MyRoutineRestController(MyRoutineService service) {
		this.service = service;
	}
	
	// 유저 이름을 받아 출석 정보 가져오기
	@GetMapping("/attendlist")
	public ResponseEntity<?> getAttendList(@RequestParam String userId) {
		return new ResponseEntity<List<ResultAttend>>(service.getAttendList(userId), HttpStatus.OK);
	}

	// 출석하기
	@PostMapping("/attend")
	public ResponseEntity<?> doAttend(@RequestBody MyRoutine attend) {
		service.doAttend(attend);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	// 출석 한것 중 해당 일자 가져오기.
	@GetMapping("/attend/date")
	public ResponseEntity<?> likeCheck(@RequestParam String userId, String regDate) {
		return new ResponseEntity<ResultAttend>(service.getAttend(userId, regDate), HttpStatus.OK);
	}
	
	// 유저 이름을 받아 내 루틴리스트 가져오기
	@GetMapping("/myRoutineList")
	public ResponseEntity<?> getMyRoutineList(@RequestParam String userId) {
		return new ResponseEntity<List<ResultAttend>>(service.getMyRoutineList(userId), HttpStatus.OK);
	}

	// 내 루틴에 저장하기.
	@PostMapping("/myRoutine")
	public ResponseEntity<?> insertMyRoutine(@RequestBody MyRoutine myRoutine) {
		if (service.findMyRoutine(myRoutine)) {
			return new ResponseEntity<String>("이미 저장한 루틴입니다.", HttpStatus.BAD_REQUEST);
		}
		service.insertMyRoutine(myRoutine);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	// 루틴 한개 가져오기.
	@GetMapping("/myRoutine")
	public ResponseEntity<?> getMyRoutine(@RequestParam String userId, int routineId) {
		System.out.println("여기는 올까");
		System.out.println(userId +" " + routineId);
		return new ResponseEntity<Routine>(service.getMyRoutine(userId, routineId), HttpStatus.OK);
	}
	
	// 루틴 삭제 하기.
	@DeleteMapping("/myRoutine")
	public ResponseEntity<?> deleteMyRoutine(@RequestParam String userId, int routineId) {
		service.deleteMyRoutine(userId, routineId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
