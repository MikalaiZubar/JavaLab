package com.epam.library.entity;

public class Book {
	private int bookId;
	private String brief;
	private int publishYear;
	private String author;
	
	
	public Book(int bookId, String brief, int publishYear, String author) {
		this.bookId = bookId;
		this.brief = brief;
		this.publishYear = publishYear;
		this.author = author;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBrief() {
		return brief;
	}


	public void setBrief(String brief) {
		this.brief = brief;
	}


	public int getPublishYear() {
		return publishYear;
	}


	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
