package cc.shen0d.web.WebSocket;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import cc.shen0d.pojo.entity.User;

public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor {

	// 建立握手包之前
	@Override
	public boolean beforeHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1,
			WebSocketHandler arg2, Map<String, Object> arg3) throws Exception
	{
		ServletServerHttpRequest req = (ServletServerHttpRequest) arg0;
		ServletServerHttpResponse resp = (ServletServerHttpResponse) arg1;
		HttpServletRequest request = req.getServletRequest();
		HttpServletResponse response = resp.getServletResponse();
		User user = (User) request.getSession(false).getAttribute("user");
		if (user == null) {
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			String script = "<script type=\"text/javascript\" charset=\"UTF-8\">  if(window.top!= window.self){"
					+ "window.top.location.href='" + request.getContextPath() + "/login.jsp'; }"
					+ "else { top.location.href='" + request.getContextPath() + "/login.jsp'; } "
					+ "</script>";
			PrintWriter writer = response.getWriter();
			writer.write(script);
			writer.flush();
			return true;
		}
		return super.beforeHandshake(arg0, arg1, arg2, arg3);
	}

}
