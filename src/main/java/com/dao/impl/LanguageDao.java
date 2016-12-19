package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Film;
import com.bean.Language;
import com.dao.ILanguageDao;
import com.dao.db.DBUtil;

public class LanguageDao implements ILanguageDao{

	@Override
	public Language get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> queryAll() {
		List<Language> languageList = new ArrayList<Language>();
		String sql = "select * from LANGUAGE";
		ResultSet rs = DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()){
				Language language = new Language();
				language.setLanguage_id(rs.getInt("LANGUAGE_ID"));
				language.setName(rs.getString("NAME"));
//				language.setLast_update(rs.getTimestamp("LAST_UPDATE"));
				languageList.add(language);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return languageList;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Language obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Language obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Language> queryByExample(Language instance) {
		// TODO Auto-generated method stub
		return null;
	}

}
