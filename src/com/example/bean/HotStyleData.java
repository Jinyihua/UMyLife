package com.example.bean;

public class HotStyleData {
	private int img;
	private String title;
	private String content;

	public HotStyleData() {
		// TODO Auto-generated constructor stub
	}

	public HotStyleData(int img, String title, String content) {
		super();
		this.img = img;
		this.title = title;
		this.content = content;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
