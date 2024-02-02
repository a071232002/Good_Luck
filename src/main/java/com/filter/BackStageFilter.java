package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.springframework.data.redis.core.StringRedisTemplate;

import com.emp.model.Emp;

@WebFilter(urlPatterns = {"/BackStage/*"})
public class BackStageFilter implements Filter{

	private ServletContext sc;
	
	private static List<Set<String>> funPaths = new ArrayList<>();
	static {
		//設定後台過濾器網頁
		
		//0靜態檔案及登入
		funPaths.add(Set.of("/js/", "/css/", "/icon/", "/images/",
							   "/jquery/", ".ico", "/login", "/index", ".svg"));
		
		//1 會員管理
		funPaths.add(Set.of("/mem", "/lddApp"));
		
		//2 物件管理
		funPaths.add(Set.of("/rentApp", "/rent", "/RtnManage"));
		
		//3 購物管理(未新增)
		funPaths.add(Set.of("/unUpdate"));
		
		//4 公告管理(未新增)
		funPaths.add(Set.of("/unUpdate"));
		
		//5 投訴管理
		funPaths.add(Set.of("/report"));
		
		//6 後台管理
		funPaths.add(Set.of("/emp", "/funManager"));
		
		//歸類方式：0 靜態檔案 1 會員管理
		//              2 商品管理 3 公告管理
		//              4 物件管理 5 申訴管理
		//              6 員工管理
		
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
		
//		boolean validator = path.stream()
//								   .allMatch(s -> (!uri.contains(s)));
		boolean validator = funPaths.get(0).stream()
												.allMatch(s -> (!uri.contains(s)));
		
		//靜態檔案及登入會跳過這裡
		if(validator) {
			System.out.println("過濾靜態檔案後的 uri:" + uri);
//			System.out.println(httpRequest.isRequestedSessionIdFromCookie());
			final Emp emp = getClassFromSession(httpRequest, "EmpSuccess", Emp.class);
			System.out.println(httpRequest.getRequestURL());
			System.out.println("後台Session資料：" + emp);
			if(emp == null) {
				System.out.println("儲存uri到後台Session：" + uri);
//				httpRequest.getSession().setAttribute("goBackStageURI", uri);
				httpResponse.sendRedirect(httpRequest.getServletContext().getContextPath() + "/BackStage/login");
				return;
			}
			
			
			//寫權限驗證
//			 boolean funValidator = emp.getEmpFun()
//										   .stream()
//										   .anyMatch(s ->funPaths.get(s).stream().anyMatch(u -> uri.contains(u)));
			String newUri = uri.replace("/Good_Luck/", "/");
			Set<String> pathValidator = funPaths.stream()
					 							 .filter(s -> s.stream().anyMatch(u -> newUri.contains(u)))
					 							 .findAny()
					 							 .orElse(null);
			 
			 if(pathValidator != null) {
				 boolean funValidator = emp.getEmpFun()
						 .stream()
						 .anyMatch(s -> funPaths.get(s).equals(pathValidator));
				 
				 //員工沒有權限
				 if(!funValidator ) {
//					 System.out.println("fun -->" + newUri);
					 httpResponse.sendRedirect(httpRequest.getContextPath() + "/BackStage/noFun");
					 return;
				 }
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
