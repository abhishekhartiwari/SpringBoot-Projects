package com.abhishek.journalApp;

	class Book {
	    String title;
	    int pages;

	    // Default constructor
	    Book() {
	        this.title = "Unknown";
	        this.pages = 0;
	    }

	    // Parameterized constructor
	    Book(String t, int p) {
	        this.title = t;
	        this.pages = p;
	    }
	}

	public class Constructor {
	    public static void main(String[] args) {
	    	Book b1 = new Book();               // Uses default constructor
	    	Book b2 = new Book("Java", 350);    // Uses parameterized constructor

	        System.out.println(b1.title);  // Unknown
	        System.out.println(b2.title);  // Java
	    }
	}

