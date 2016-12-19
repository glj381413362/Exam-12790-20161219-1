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
import javax.servlet.http.HttpServlet;
@WebFilter(urlPatterns={"/*"},filterName="EncodeFilter", initParams={@WebInitParam(name="encode",value="UTF-8")})
public class EcodingFilter implements Filter {
	private String  encode = null;
	@Override
	public void init(FilterConfig config) throws ServletException {
		//获取初始化参数
	     String encode =config.getInitParameter("encode");
	      if(this.encode == null){
	           this.encode =encode;  //查找配置文件中预设的字符集编码
	      }
		System.out.println("ecodingFilter初始化");
	}

	@Override
	public void doFilter(ServletRequest res, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//如果res未设置编码，则进行设置
		if(null==res.getCharacterEncoding()){
		    res.setCharacterEncoding(encode);
			resp.setCharacterEncoding(encode);
			resp.setContentType("text/html; charset"+encode);
		}
		chain.doFilter(res, resp);
	}

	@Override
	public void destroy() {
		 encode = null;
		System.out.println("ecodingFilter销毁!");
	}

}
