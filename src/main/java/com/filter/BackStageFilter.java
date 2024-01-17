package com.filter;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.emp.model.Emp;

@Component
//@WebFilter("*.html")
public class BackStageFilter implements Filter{

	private ServletContext sc;
	
	private static HashSet<String> path = new HashSet<>();
	
	static {
		//設定後台過濾器網頁
		path.add("addEmp");
		path.add("funlist");
		path.add("goEditFun");
		path.add("memlist");
		path.add("addLddApp");
		path.add("listAllLddApp");
		path.add("EmpSelect");
		
	}
	
	public void init(FilterConfig fig) {
		sc = fig.getServletContext();
		System.out.println("後台過濾器 -> 啟動");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		final String uri = httpRequest.getRequestURI();
		final String htmlName = uri.substring(uri.lastIndexOf("/") + 1);
		
		System.out.println("htmlName:" + htmlName);
		System.out.println("uri:" + uri);
		System.out.println();
		
		if(uri.contains("/BackStage") && path.contains(htmlName)) {
			final Emp emp = getClassFromSession(httpRequest, "EmpSuccess", Emp.class);
			System.out.println(emp);
			
			if(emp == null) {
				httpResponse.sendRedirect("/BackStage/login");
				return;
			}
		}
		
		chain.doFilter(request, response);
		
		
	}
	
	
	public void destroy() {
		sc = null;
	}
	
	//透過Session取得參數
	private <T> T getClassFromSession(final HttpServletRequest req, final String attrKey, final Class<T> clazz) {
		final Object obj = req.getSession().getAttribute(attrKey);
		if(obj != null && clazz.isInstance(obj)) {
			return clazz.cast(obj);
		}
		return null;
	}

}
