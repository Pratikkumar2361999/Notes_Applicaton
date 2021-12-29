package com.kyu.bean;

import java.sql.Timestamp;

public class Note {
	private int sno;
	private String note;
	private String title;
	private Timestamp ts;
	
	
	
	public Note(String title, String note ) {
		this.note = note;
		this.title = title;
	}
	public Note() {
		
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	@Override
	public String toString() {
		return "Note [sno=" + sno + ", note=" + note + ", title=" + title + "]";
	}
	
	
	
	
}
