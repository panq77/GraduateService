package pq.empm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();

	    if(session.getAttribute("username")!=null||session.getAttribute("p_username")!=null) {
	        // 重定向到登录页面
            return true;
	    }
        response.sendRedirect("http://localhost:8080/web/login.html");
        return false;
        // 放行


    }
}
