package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Film;
import com.bean.Language;
import com.dao.IFilmDao;
import com.dao.ILanguageDao;
import com.dao.impl.FilmDao;
import com.dao.impl.LanguageDao;

@WebServlet("/film/*")
public class FilmServlet extends HttpServlet {
	private String op = null;
	private IFilmDao filmDao = new FilmDao();
	private ILanguageDao LanguageDao = new LanguageDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String n1 =req.getParameter("id");
		List<Language> languages = LanguageDao.queryAll();
		op = getAction(req);
		switch (op) {
		case "add.do":
			req.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(req, resp);
			System.out.println("add.do");
			break;
		case "addSave.do":
			String title1 = req.getParameter("title");
			String description1 = req.getParameter("description");
			Film film3 = new Film();
			film3.setTitle(title1);
			film3.setDescription(description1);
			film3.setLanguage_id(1); /////////////////////////////
			filmDao.add(film3);
			handlerDelete(req, resp, 1);
			System.out.println("addSave.do");
			break;
		case "delete.do":
			int page = 1;////////////////////////////////////////////////////////////
			int film_id1 = Integer.parseInt(req.getParameter("film_id").trim());
			System.out.println(film_id1);
			filmDao.remove(film_id1);
			handlerDelete(req, resp, page);
			break;
		case "changePage.do":
			int pages = Integer.parseInt(req.getParameter("nowPage").trim());
			handlerChangePage(req, resp, pages);
			break;

		case "update.do":
			int film_id = Integer.parseInt(req.getParameter("film_id").trim());
			Film film = filmDao.get(film_id);
			req.getSession().setAttribute("languages", languages);
			System.out.println(film.getTitle());
			req.getSession().setAttribute("film_id", film_id);
			req.getSession().setAttribute("film", film);
			req.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(req, resp);
			break;

		case "updateSave.do":
			String n = req.getParameter("film_id");
			int film_id2 = 0;
			if (n != null) {
				film_id2 = Integer.parseInt(n);
			}

			String title = req.getParameter("title");
			String description = req.getParameter("description");
			Film film2 = new Film();
			film2.setFilm_id(film_id2);
			film2.setTitle(title);
			film2.setDescription(description);
			film2.setLanguage_id(1);/////////////////////////////
			filmDao.update(film2);
			handlerDelete(req, resp, 1);
			System.out.println("updateSave.do");
			break;
		default:
			break;
		}
	}

	/**
	 * @discription 处理分页请求
	 * @author 龚梁钧
	 * @created 2016年12月19日 下午9:20:20
	 * @param req
	 * @param resp
	 * @param pages
	 */
	private void handlerChangePage(HttpServletRequest req, HttpServletResponse resp, int pages) {
		List<Film> fList = filmDao.queryByUsePage(pages);
		try {
			req.getSession().setAttribute("fList", fList);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @discription 处理删除请求
	 * @author 龚梁钧
	 * @created 2016年12月19日 下午9:20:48
	 * @param req
	 * @param resp
	 * @param page
	 */
	private void handlerDelete(HttpServletRequest req, HttpServletResponse resp, int page) {
		List<Film> fList = filmDao.queryByUsePage(page);
		try {
			req.getSession().setAttribute("fList", fList);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @discription 获得引擎类型
	 * @author 龚梁钧
	 * @created 2016年12月19日 下午9:21:14
	 * @param req
	 * @return
	 */
	private String getAction(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String substring = uri.substring(uri.lastIndexOf("/") + 1);
		if ("film".equals(substring) || "".equals(substring)) {
			substring = "update.do";
		}
		return substring;
	}

}
