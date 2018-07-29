package com.teamJ3.homepage.dto;

public class Board {
	
	private int board_id;
	private String board_writer;
	private String board_subject;
	private String board_Reg_date;
	private String board_contents;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_Reg_date() {
		return board_Reg_date;
	}
	public void setBoard_Reg_date(String board_Reg_date) {
		this.board_Reg_date = board_Reg_date;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	
	
}
