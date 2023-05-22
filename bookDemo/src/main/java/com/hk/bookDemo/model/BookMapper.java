package com.hk.bookDemo.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.bookDemo.vo.BookVO;

@Mapper
public interface BookMapper {
	
	// application.properties에서 있는 설정중
	// mapper-locations ...SQL.xml
	// id 
	// Mapper package명은
	// mybatis.type-aliases-package와 동일
	int insert(BookVO bookVO);
	
	// 전체목록: selectAll
	List<BookVO> selectAll();
}
