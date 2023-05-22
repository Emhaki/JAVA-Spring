package com.hk.bookDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.bookDemo.service.BookService;
import com.hk.bookDemo.vo.BookVO;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "home"; // JSP는 WEB-INF/views/home.jsp를 찾았지만
				// Thymeleaf는 src/main/resources/templates에서 home.html을 찾는다.
				// 관련 설정 application.properties
	}
	
	@GetMapping("/create") // url에 매핑
	public String create() {
		return "book/create"; // 해당 파일을 찾는 루트, 기본설정이 html 확장자
	}
	
	@PostMapping("/create")
	public String createPost(BookVO bookVO) {
		// service 호출
		// DB에 사용자가 입력한 값을 저장하고..
		// 입력된 book_id를 가지고 상세페이지로 넘기기
		// if문으로 로직 처리
		
		// 1. bookService에 create method를 호출
		long book_id = bookService.create(bookVO);
		if (book_id == 0) {
			// 에러
			return "redirect:/create"; 
		} else {
			// 성공
			return "redirect:/detail?bookId=" + book_id;
		}
		// 2. 호출한 결과를 long리턴 why? VO에 long으로 book_id가 되어있기 떄문
	}
	
	
	// Controller + ResponsBody = RestController
	// ResponseBody Return에 있는 변수의 값을 브라우저로 전송
	@GetMapping("/list")
	//@ResponseBody
	public String selectAll(Model model) {
		List<BookVO> list = bookService.selectAll();
		// 보관소 (application, Session, Request)
		// -> Model
		// model에 저장해서 book/list.html에서 꺼내서 사용
		model.addAttribute("list", list); // list란 이름이 변수명하고도 같고
		// thymeleaf에서 $list로 해서 꺼냄
		return "book/list";
	}
}
