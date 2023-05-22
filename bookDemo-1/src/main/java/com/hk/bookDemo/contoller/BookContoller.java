package com.hk.bookDemo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookContoller {
	
	@GetMapping("/")
	public String home () {
		return "home";
	}

}
