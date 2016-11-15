package com.example.bean;

public class OrderData {
	private String number;
	private String state;
	private int img;
	private String title;
	private String content;
	private String prive;
	private String btn_content;

	public OrderData() {
		// TODO Auto-generated constructor stub
	}

	public OrderData(String number, String state, int img, String title,
			String content, String prive) {
		super();
		this.number = number;
		this.state = state;
		this.img = img;
		this.title = title;
		this.content = content;
		this.prive = prive;
	}
	

	public OrderData(String number, String state, int img, String title,
			String content, String prive, String btn_content) {
		super();
		this.number = number;
		this.state = state;
		this.img = img;
		this.title = title;
		this.content = content;
		this.prive = prive;
		this.btn_content = btn_content;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getPrive() {
		return prive;
	}

	public void setPrive(String prive) {
		this.prive = prive;
	}

	public String getBtn_content() {
		return btn_content;
	}

	public void setBtn_content(String btn_content) {
		this.btn_content = btn_content;
	}
	

}
