package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*@WebFilter("/WEB-INF/jsp/*.jsp")
*/@WebFilter(urlPatterns = { "/*" }, filterName = "UserFilter", initParams = {
		@WebInitParam(name = "excludedPages", value = "/login.do,/login_jsp.do,/login.jsp") })
public class UserFilter implements Filter {

	/**
	 * 需要排除的页面
	 */

	private String excludedPages;
	private String[] excludedPageArray;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		boolean isExcludedPage = false;
		String path = ((HttpServletRequest) req).getServletPath();
		for (String page : excludedPageArray) {// 判断是否在过滤url之外
			if (path.equals(page) || path.equals(" ")) {
				isExcludedPage = true;
				break;
			}
		}
		if (isExcludedPage) {// 在过滤url之外
			chain.doFilter(req, resp);
		} else {// 不在过滤url之外，判断session是否存在
			HttpSession session = ((HttpServletRequest) req).getSession();
			if (session == null || session.getAttribute("user") == null) {
				req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
			} else {
				chain.doFilter(req, resp);
			}
		}
	}

	/**
	 * 初始化函数，获取需要排除在外的url
	 */

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		excludedPages = fConfig.getInitParameter("excludedPages");
		if (excludedPages != null) {
			excludedPageArray = excludedPages.split(",");
		}
		return;
	}

}
