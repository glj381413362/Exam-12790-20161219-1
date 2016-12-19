package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.bean.Film;
import com.dao.IFilmDao;
import com.dao.IUserDao;
import com.dao.impl.FilmDao;
import com.dao.impl.UserDao;

@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
	
		/**  描述   (@author: 龚梁钧) */      
	    
	private static final long serialVersionUID = -3273399521617947867L;
	private IUserDao userDao = new UserDao();
	private IFilmDao filmDao = new FilmDao();
	private String op = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		op = getAction(req);
		switch (op) {
		case "login_jsp.do":
			handlerLogin_jsp(req, resp);
			break;
		case "login.do":
			handlerLogin(req, resp);
			break;

		default:
			break;
		}

	}

	private void handlerLogin(HttpServletRequest req, HttpServletResponse resp) {
		String userName = req.getParameter("username").trim();
		String pwd = req.getParameter("pwd").trim();
		Customer customer = userDao.getCustomerByName(userName);
		System.out.println(customer);
		try {
			if (customer != null) {
				List<Film> fList = filmDao.queryByUsePage(1);
				req.getSession().setAttribute("fList", fList);
				req.getSession().setAttribute("user", customer);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				req.setAttribute("errorMsg", "账户或密码错误！");
				resp.sendRedirect("login_jsp.do");
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void handlerLogin_jsp(HttpServletRequest req,
			HttpServletResponse resp) {
		String userString = req.getParameter("user");
		try {
			if (userString == null) {
				req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,
						resp);
			} else {
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private String getAction(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String substring = uri.substring(uri.lastIndexOf("/") + 1);
		if ("login".equals(substring) || "".equals(substring)) {
			substring = "login.do";
		}
		return substring;
	}

}
