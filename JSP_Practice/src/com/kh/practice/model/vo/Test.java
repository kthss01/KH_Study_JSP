package com.kh.practice.model.vo;

import java.sql.Date;

public class Test {
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;

	public Test() {
	}

	public Test(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	int getSeq() {
		return seq;
	}

	void setSeq(int seq) {
		this.seq = seq;
	}

	String getWriter() {
		return writer;
	}

	void setWriter(String writer) {
		this.writer = writer;
	}

	String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	String getContent() {
		return content;
	}

	void setContent(String content) {
		this.content = content;
	}

	Date getRegdate() {
		return regdate;
	}

	void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
