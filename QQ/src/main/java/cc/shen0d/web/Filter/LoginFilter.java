package cc.shen0d.web.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.shen0d.pojo.entity.User;

/**
 * µÇÂ¼¹ýÂËÆ÷
 * 
 * @author sihan
 *
 */
public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		User user = (User) request.getSession().getAttribute("user");
		String string = request.getRequestURL().toString();
		System.out.println(string.contains("WebService"));
		if (string.endsWith("js") || string.endsWith("css") || string.endsWith("jpg")
				|| string.endsWith("png") || string.endsWith("login.jsp")
				|| string.endsWith("login.do") || string.contains("WebService")) {
			arg2.doFilter(arg0, arg1);
		} else {
			if (user == null) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				arg2.doFilter(arg0, arg1);
			}
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
