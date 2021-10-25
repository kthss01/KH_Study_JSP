package com.kh.practice.model.vo;

import java.sql.Date;

public class Board {
	private int no;
	private String title;
	private String content;
	private String writer;
	private String status;
	private Date createDate;
	private Date updateDate;

	public Board() {
	}

	public Board(int no, String title, String content, String writer, String status, Date createDate, Date updateDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	int getNo() {
		return no;
	}

	void setNo(int no) {
		this.no = no;
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

	String getWriter() {
		return writer;
	}

	void setWriter(String writer) {
		this.writer = writer;
	}

	String getStatus() {
		return status;
	}

	void setStatus(String status) {
		this.status = status;
	}

	Date getCreateDate() {
		return createDate;
	}

	void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	Date getUpdateDate() {
		return updateDate;
	}

	void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", status="
				+ status + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
