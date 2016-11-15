package com.example.bean;

public class MySelfData {
	private int img;
	private String content;
	int type;
	public MySelfData() {
		// TODO Auto-generated constructor stub
	}

	public MySelfData(int img, String content) {
		super();
		this.img = img;
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
