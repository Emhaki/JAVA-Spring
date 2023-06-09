package com.hk.bookDemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
	
	long book_id;
	String title;
	String category;
	int price;
	Date insert_date; // java.util.date(년월일시간) , java.sql.date(년원일)
	
}
