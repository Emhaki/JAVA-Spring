package com.hk.bookDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.bookDemo.model.BookMapper;
import com.hk.bookDemo.vo.BookVO;

@Service
public class BookService {
	
	@Autowired
	BookMapper bookMapper;
	
	public long create(BookVO bookVO) {
		
		int affectRowCount = bookMapper.insert(bookVO);
		if (affectRowCount == 1) {
			return bookVO.getBook_id();
		}
		return 0;
	}
}
