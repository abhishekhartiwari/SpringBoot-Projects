package com.abhishek.journalApp;

public class FactoryPattern {

	public static void main(String[] args) {

		ShapeFactory sf = new ShapeFactory();
		Shape s = sf.getShape("triangle");
		s.draw();
	}

}

interface Shape {
	void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Drawing the circle");

	}
}

class Triangle implements Shape {

	@Override
	public void draw() {
		System.err.println("printing triangle");

	}

}

class ShapeFactory {

	public Shape getShape(String s) {
		Shape shape = null;
		if (s.equals("circle")) {
			shape = new Circle();
			return shape;
		} else if(s.equals("triangle")){
			shape = new Triangle();
			return shape;
		}
		return null;
	}
}
