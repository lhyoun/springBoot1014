package com.cos.board.controller;

public class Test {
	Animal a;
	
	public void start() {
		//Animal a = new Animal();
		// 여기서 a는 지역변수. start의 stack이 가지고 있다. start가 호출되면 객체가 생성
		// new animal은 heap에 뜸
		// start가 끝나면 a가 사라지고 new animal은 GC 걸림
		// 이걸 막으려면 아래처럼 하고 Animal a; 를 밖에 정의해야 한다
		a = new Animal();
	}
	
	
}
