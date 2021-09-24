package com.kh.practice.model.vo;

public class Practice {
	private String test;

	public Practice() {
		// TODO Auto-generated constructor stub
	}

	public Practice(String test) {
		super();
		this.test = test;
	}

	String getTest() {
		return test;
	}

	void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Practice [test=" + test + "]";
	}

}
