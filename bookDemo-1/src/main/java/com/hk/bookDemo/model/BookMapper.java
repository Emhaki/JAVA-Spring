package com.hk.bookDemo.model;

import org.apache.ibatis.annotations.Mapper;

import com.hk.bookDemo.vo.BookVO;

@Mapper
public class BookMapper {
	
	int insert(BookVO bookVO);
}
