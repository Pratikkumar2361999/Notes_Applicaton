package com.kyu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kyu.bean.Note;

public class DBImpl implements DB {

	@Override
	public boolean insertNotes(Note note) {
		boolean b = false;
		try {
		Connection con = ConnectionProvider.getConnection();
		String q = "insert into notes(title,note) values(?,?)";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, note.getTitle());
		ps.setString(2, note.getNote());
		int i = ps.executeUpdate();
		if (i>0) {
			b=true;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public ArrayList<Note> getAllNotes() {
		ArrayList<Note> list = new ArrayList<>();
		try {
			Connection con  = ConnectionProvider.getConnection();
			String q = "select * from notes";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			rs.afterLast();
			while(rs.previous()) {
				Note note = new Note(rs.getString("title"), rs.getString("note"));
				note.setSno(rs.getInt("sno"));
				note.setTs(rs.getTimestamp(4));
//				note.setNote(rs.getString("note"));
//				note.setTitle(rs.getString("title"));
				list.add(note);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Note getNoteBySno(int sno) {
		Note note = new Note();
		try {
			Connection con  = ConnectionProvider.getConnection();
			String q = "select * from notes where sno = ?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, sno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				note.setSno(rs.getInt("sno"));
				note.setNote(rs.getString("note"));
				note.setTitle(rs.getString("title"));
				note.setTs(rs.getTimestamp(4));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return note;
	}

	@Override
	public boolean updateNote(Note note) {
		boolean b = false;
		try {
			Connection con  = ConnectionProvider.getConnection();
			String q = "update notes set title=? , note=? where sno=?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, note.getTitle());
			ps.setString(2, note.getNote());
			ps.setInt(3, note.getSno());
			int i = ps.executeUpdate();
			if (i>0) {
				b=true;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean deleteNoteBySno(int sno) {
		boolean b = false;
		try {
			Connection con  = ConnectionProvider.getConnection();
			String q = "delete from notes where sno=?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, sno);
			int i = ps.executeUpdate();
			if (i>0) {
				b=true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean deleteAllNote() {
		boolean b = false;
		try {
			Connection con  = ConnectionProvider.getConnection();
			String q = "delete from notes";
			PreparedStatement ps = con.prepareStatement(q);
			int i = ps.executeUpdate();
			if (i>0) {
				b=true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	
	

}
