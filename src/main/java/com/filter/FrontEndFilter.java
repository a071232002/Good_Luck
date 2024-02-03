package com.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;

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

import org.springframework.beans.factory.annotation.Autowired;

import com.ldd.model.Ldd;
import com.ldd.model.LddService;
import com.mem.model.Mem;


@WebFilter(urlPatterns = "/*")
public class FrontEndFilter implements Filter{

	private ServletContext sc;
	
	@Autowired
	private LddService lddservice;
	
	
	
	private static HashSet<String> path = new HashSet<>();
	private static HashSet<String> lddPath = new HashSet<>(); //過濾房東權限
	
	static {
		//設定前台過濾器忽略的網頁
		path.add("/js/");
		path.add("/css/");
		path.add("/icon/");
		path.add("/images/");
		path.add("/jquery/");
		path.add(".ico");
		path.add(".svg");
		
		path.add("/login");
		path.add("/forgetPsw");
		path.add("/addMem");
		path.add("/varify");
		path.add("/memadd");
		path.add("/rent/");
		path.add("/notice/");
		
		
	}
	
	public void init(FilterConfig fig) {
		sc = fig.getServletContext();
		System.out.println("前台過濾器 -> 啟動");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
	
		String uri = httpRequest.getRequestURI();
		String contextPath = httpRequest.getServletContext().getContextPath();
//		System.out.println("uri:" + uri);
//		System.out.println();
		String newUri = uri.replace("/Good_Luck/", "/");
		
		
		boolean validator =path.stream()
					  		.allMatch(s -> !uri.contains(s) && !uri.contains("/BackStage") && !"/".equals(uri));

		if(validator && !"/Good_Luck/".equals(uri)) {
			final Mem member = getClassFromSession(httpRequest, "logsuccess", Mem.class); //取得Session資料
			System.out.println("Member為：" + member);
			if(member == null) {
				if(httpRequest.getParameter("rentNo") != null) {
					newUri = newUri + "?rentNo=" +  httpRequest.getParameter("rentNo");
				}
				System.out.println("儲存uri到Session：" + newUri);
				System.out.println("test " + httpRequest.getParameter("rentNo"));
				httpRequest.getSession().setAttribute("goURI", newUri);
				httpResponse.sendRedirect( contextPath + "/mem/login");
				return;
			}

			//未指定過濾房東權限網頁
//			if(ldd == null || ldd.getLddStatus() == 1) {
//				httpResponse.sendRedirect(contextPath + "/mem/memCenter");
//			}
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
