package cc.shen0d.web.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cc.shen0d.pojo.entity.User;
import cc.shen0d.util.ApplicationContextUtil;

/**
 * µÇÂ¼¹ýÂËÆ÷
 * 
 * @author sihan
 *
 */
public class LoginFilter implements Filter {

	@Autowired
	ApplicationContextUtil util;

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException
	{
		System.err.println(util.getApplicationContext().getApplicationName());
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

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(17);
		list.add(27);
		list.add(7);
		list.add(1017);
		list.add(2017);
		List<Integer> list1 = new ArrayList<Integer>(list);
		for (int i = 0; i < list.size(); i++) {
			Integer integer = list.get(i);
			System.out.println(i);
			if (integer > 1000) {
				Integer integer2 = integer % 1000;
				String substring = integer.toString().substring(0, 1);
				int indexOf = list.indexOf(integer2);
				list1.add(indexOf + Integer.valueOf(substring), integer);
				list1.remove(i + Integer.valueOf(substring));
			}
		}
		System.out.println(Arrays.toString(list1.toArray()));
	}

}
