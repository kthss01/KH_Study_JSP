package com.kh.board.model.vo;

import java.sql.Date;

public class Board {

	private int id;
	private String title;
	private String writer;
	private String content;
	private Date date;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public Board(int id, String title, String writer, String content) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public Board(int id, String title, String writer, String content, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
