package com.cos.board.model;

public class Hello {

	private String title;
	private String content;
	
	public static Hello builder() {
		return new Hello();
	}
	
	public Hello title(String title) {
		this.title = title;
		return this;
	}
	
	public Hello content(String content) {
		this.content = content;
		return this;
	}
	
	public static void main(String[] args) {
		Hello hello = Hello.builder().title("title");
	}
}
