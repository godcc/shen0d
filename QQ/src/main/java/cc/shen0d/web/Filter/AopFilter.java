package cc.shen0d.web.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * ί�ɴ���
 * @author sihan
 *
 */
public class AopFilter implements Filter {
	List<Filter> filters = new ArrayList<Filter>();

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��ʼ����");
		for (Filter filter : filters) {
			filter.init(filterConfig);
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		// ���￼�ǵ���ִ�����ǵ�
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURL = httpRequest.getRequestURL().toString();
		if (requestURL.endsWith("map") || requestURL.endsWith("css") || requestURL.endsWith("js")
				|| requestURL.endsWith("login.do") || requestURL.endsWith("login.jsp")) {
			chain.doFilter(httpRequest, response);
		} else {
			new AopFilterChain(chain, filters).doFilter(request, response);
		}
	}

	public void destroy() {
		for (Filter filter : filters) {
			filter.destroy();
		}
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

}
