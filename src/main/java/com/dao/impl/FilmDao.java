package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Film;
import com.dao.IFilmDao;
import com.dao.db.DBUtil;


public class FilmDao implements IFilmDao {
	private int pageSize = 5;// 每页记录数

	@Override
	public Film get(int id) {
		Film film = null;
		String sql = "SELECT F.FILM_ID,F.TITLE,F.DESCRIPTION,F.LANGUAGE_ID FROM FILM F WHERE F.FILM_ID=? ";
		Object[] pramas = new Object[] { id };
		ResultSet rs = DBUtil.executeQuery(sql, pramas);
		try {
			while(rs.next()){
				film = new Film();
				film.setFilm_id(rs.getInt("FILM_ID"));
				film.setTitle(rs.getString("TITLE"));
				film.setDescription(rs.getString("DESCRIPTION"));
				film.setLanguage_id(rs.getInt("LANGUAGE_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public int remove(int id) {
		String sql1= "SET FOREIGN_KEY_CHECKS = 0";
		String sql2 = " delete from  FILM  where FILM_ID="+id;
		String sql3= "SET FOREIGN_KEY_CHECKS = 1";
		return DBUtil.executeUpdateTwo(sql1, sql2, sql3);
	}

	@Override
	public int add(Film film) {
		String sql = "insert into FILM(TITLE,DESCRIPTION,LANGUAGE_ID) values(?,?,?)";
		Object[] pramas = new Object[] {
				film.getTitle(), film.getDescription(),film.getLanguage_id()};
		return DBUtil.executeUpdate(sql, pramas);
	}

	@Override
	public int update(Film film) {
		String sql = "update  FILM F set F.TITLE=?,F.DESCRIPTION=?,F.LANGUAGE_ID=? where F.FILM_ID=?";
		Object[] pramas = new Object[] { film.getTitle(),
				film.getDescription(), film.getLanguage_id(),film.getFilm_id() };
		return DBUtil.executeUpdate(sql, pramas);
	}

	@Override
	public List<Film> queryByExample(Film instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> queryAll() {
		List<Film> fList = new ArrayList<Film>();
		String sql = "select * from FILM";
		ResultSet rs = DBUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				Film film = new Film();
				film.setFilm_id(rs.getInt("FILM_ID"));
				film.setLanguage_id(rs.getInt("LANGUAGE_ID"));
				film.setTitle(rs.getString("TITLE"));
				film.setDescription(rs.getString("DESCRIPTION"));
				fList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}

	@Override
	public List<Film> queryByUsePage(int currentPage) {
		List<Film> fList = new ArrayList<Film>();
		int beginRecord = (currentPage - 1) * pageSize;// 开始记录
		int endRecord = pageSize;// 从开始到结束的记录数
		String sql = "select * from FILM limit ? , ?";
		Object[] params = new Object[] { beginRecord, endRecord };
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Film film = new Film();
				film.setFilm_id(rs.getInt("FILM_ID"));
				film.setLanguage_id(rs.getInt("LANGUAGE_ID"));
				film.setTitle(rs.getString("TITLE"));
				film.setDescription(rs.getString("DESCRIPTION"));
				fList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}

	@Override
	public int getPages() {
		int totalPages = 0;// 总页数totalPages
		String sql = "select * from FILM";
		ResultSet rs = DBUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				int totalRecords = rs.getInt("FILM_ID");// 总记录数totalRecords
				totalPages = totalRecords % 10 == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalPages;
	}

}
