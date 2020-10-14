package com.cos.board.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.board.config.ex.MyArgsNouFound;

// 
@ControllerAdvice
@RestController
public class ExceptionController {
	
	// 해당 ex가 터지면 아래 함수를 실행
	@ExceptionHandler(value=MyArgsNouFound.class)
	public String IllegalArgumentException(Exception e) {
		return e.getMessage();
	}
	
}
