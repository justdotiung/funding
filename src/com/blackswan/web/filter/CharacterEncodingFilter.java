package com.blackswan.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;



@WebFilter(
		urlPatterns= {"/*"},
		initParams= {@WebInitParam(name="encoding", value="UTF-8")}
		)
public class CharacterEncodingFilter implements Filter{
	
	private String encoding = "UTF-8";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		
	}
	
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		String encoding = filterConfig.getInitParameter("encoding");
//		
//		if(encoding != null && !encoding.equals(""))
//			this.encoding = encoding;
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		request.setCharacterEncoding("UTF-8");
//		
//		chain.doFilter(request, response);
//		
//		
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		
//	}

}
