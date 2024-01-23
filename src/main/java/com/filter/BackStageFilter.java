package com.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

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

import com.emp.model.Emp;

@WebFilter(urlPatterns = {"/BackStage/*"})
public class BackStageFilter implements Filter{

	private ServletContext sc;
	
	private static HashSet<String> path = new HashSet<>();
	static {
		//設定後台過濾器網頁
		path.add("/js/");
		path.add("/css/");
		path.add("/icon/");
		path.add("/images/");
		path.add("/jquery/");
		
		path.add("/login");
		path.add("/index");
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
//		final String[] htmlName = uri.split("/");
		System.out.println("uri:" + uri);
		
		System.out.println(!urlStaticValidator(uri));
		System.out.println(!uri.contains("login"));
		System.out.println(!uri.contains("index"));
		System.out.println();
		System.out.println(httpRequest.getContextPath());
		
		
		
		//靜態檔案及登入會跳過
		if(!urlStaticValidator(uri)) {
			final Emp emp = getClassFromSession(httpRequest, "EmpSuccess", Emp.class);
			System.out.println("後台Session資料：" + emp);
			
			if(emp == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/BackStage/login");
				return;
			}
			
			//寫權限驗證
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
	
	//路徑是否包含靜態及登入檔案
	public boolean urlStaticValidator(String uri) {
		Iterator<String> it = path.iterator();
		while(it.hasNext()) {
			if(uri.contains(it.next())) return true;
		}
		return false;
	}

}
