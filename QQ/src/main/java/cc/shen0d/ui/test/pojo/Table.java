package cc.shen0d.ui.test.pojo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Table extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		// out.print("<tr>");
		// out.print("<td>"+username+"");
		// out.print("</td>");
		// out.print("</tr>");
		sb.append("<tr>");
		sb.append("<td>" + username);
		sb.append("<tr>");
		sb.append("<tr>");
		sb.append("<tr>");
		sb.append("</table>");
		try {
			out.print(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return TagSupport.EVAL_PAGE;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
