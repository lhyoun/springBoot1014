package com.cos.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class BoardTest {
	@Test
	public void lombokTest() {
		System.out.println("===== ===== ===== =====");
		// 1. Board 모델
		Board board1 = new Board();
		board1.setTitle("title");
		board1.setId(1);
		System.out.println(board1);
		System.out.println("===== ===== ===== =====");
		
		Board board2 = new Board(
				2,
				"제목2",
				"내용2",
				0,
				Timestamp.valueOf(LocalDateTime.now())
		);
		
		System.out.println(board2);
		
		Board board3 = Board.builder().title("제목").content("content").build();
		System.out.println(board3);
	}
}
