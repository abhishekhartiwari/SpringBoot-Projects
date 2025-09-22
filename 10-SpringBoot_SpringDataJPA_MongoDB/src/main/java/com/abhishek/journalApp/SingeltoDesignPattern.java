package com.abhishek.journalApp;

public class SingeltoDesignPattern {

	public static void main(String[] args) {
		
		
		

	}

}

class Single{
	private Single() {	}
	private static Single instance;

	public static Single getSingeltonObject() {
		
		if(instance == null ) {
			instance = new Single();
		}
		return instance;
	}
} 