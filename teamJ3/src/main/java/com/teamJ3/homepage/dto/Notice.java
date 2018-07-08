package com.teamJ3.homepage.dto;

public class Notice {
	
	private int notice_id;
	private String notice_writer;
	private String notice_subject;
	private String notice_Reg_date;
	
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_writer() {
		return notice_writer;
	}
	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}
	public String getNotice_subject() {
		return notice_subject;
	}
	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}
	public String getNotice_Reg_date() {
		return notice_Reg_date;
	}
	public void setNotice_Reg_date(String notice_Reg_date) {
		this.notice_Reg_date = notice_Reg_date;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Notice [notice_id=" + notice_id + ", notice_writer=" + notice_writer + ", notice_subject=" + notice_subject + ", notice_Reg_date=" + notice_Reg_date + "]";
	}
	
	
	
	
}
