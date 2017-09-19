package cc.shen0d.web.Filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AopFilterChain implements FilterChain {
	final private FilterChain chain;
	final private List<Filter> filters;
	private int a = 0;

	AopFilterChain(FilterChain chain, List<Filter> filters) {
		System.out.println("自定义过滤链条");
		this.chain = chain;
		this.filters = filters;
	}

	public void doFilter(ServletRequest request, ServletResponse response)
			throws IOException, ServletException
	{
		System.out.println(this.hashCode());
		if (filters.size() == a) {
			chain.doFilter(request, response);
		} else {
			a++;
			filters.get(a - 1).doFilter(request, response, this);
			;
		}
	}

}
