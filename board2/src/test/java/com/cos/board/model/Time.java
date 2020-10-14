package com.cos.board.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class Time {

	@Test
	public void time() {
		System.out.println(new Date());
		
		System.out.println(new java.sql.Time(1));
		
		System.out.println(LocalDate.now().toString());
		System.out.println(LocalDateTime.now().toString());
	}
}
