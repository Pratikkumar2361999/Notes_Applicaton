package com.kyu.db;

import java.util.ArrayList;

import com.kyu.bean.Note;

public interface DB {
	public abstract boolean insertNotes(Note note);
	public abstract ArrayList<Note> getAllNotes();
	public abstract Note getNoteBySno(int sno);
	public abstract boolean updateNote(Note note);
	public abstract boolean deleteNoteBySno(int sno);
	public abstract boolean deleteAllNote();
	
}
