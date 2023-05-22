package com.hk.bookDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.bookDemo.model.BookMapper;
import com.hk.bookDemo.vo.BookVO;

@Service
public class BookService {
	
	@Autowired
	BookMapper bookMapper;
	
	public long create(BookVO bookVO) {
		// TODO Auto-generated method stub
		// DAO/Repository/Mapper에 사용자에게 받은 bookVO를
		// 실제 insert 하도록 요청
		// 성공이면 book_id 
		// 실패면 0
		
		// Mapper 호출, interface
		int affectRowCount = bookMapper.insert(bookVO);
		if (affectRowCount == 1) {
			return bookVO.getBook_id();
		} 
		return 0;
	}
	
	public List<BookVO> selectAll() {
		List<BookVO> list = bookMapper.selectAll();
		
		return list;
	}

}
