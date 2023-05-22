package com.hk.bookDemo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
	
	long book_id;
	String title;
	String category;
	int price;
	Date insert_date;
}
