package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloCotroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
