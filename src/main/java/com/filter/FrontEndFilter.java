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

import com.mem.model.Mem;

@Component
@WebFilter("*.html")
public class FrontEndFilter implements Filter{

	private ServletContext sc;
	
	private static HashSet<String> path = new HashSet<>();
	
	static {
		//設定過濾器經過的網頁
		path.add("addMem");
	}
	
	public void init(FilterConfig fig) {
		sc = fig.getServletContext();
		System.out.println("test");
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
			final Mem member = getClassFromSession(httpRequest, "logsuccess", Mem.class);
			System.out.println(member);
			
			if(member == null) {
				httpResponse.sendRedirect("login");
				return;
			}
		}
		
		chain.doFilter(request, response);
		
		
	}
	
	
	public void destroy() {
		sc = null;
	}
	
	private <T> T getClassFromSession(final HttpServletRequest req, final String attrKey, final Class<T> clazz) {
		final Object obj = req.getSession().getAttribute(attrKey);
		if(obj != null && clazz.isInstance(obj)) {
			return clazz.cast(obj);
		}
		return null;
	}
}
