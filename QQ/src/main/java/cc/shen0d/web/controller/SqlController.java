package cc.shen0d.web.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.shen0d.ui.JDBCUtil;

/**
 * sql◊¢»Î≤‚ ‘
 * @author sihan
 *
 */
@Controller
public class SqlController {

	@RequestMapping("/sqlInject")
	@ResponseBody
	public Object sqlInJect(@RequestParam("username") String username,
			@RequestParam("password") String password)
	{
		Object obj = null;
		Connection conn = null;
		Statement createStatement = null;
		String sql = "select * from user where username='" + username + "'and password='" + password
				+ "' order by id desc";
		System.out.println(sql);
		try {
			conn = JDBCUtil.getInstance().getConn();
			createStatement = conn.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			List list = new ArrayList<String>();
			while (executeQuery.next()) {
				StringBuffer sb = new StringBuffer();
				sb.append("id" + "------------" + executeQuery.getString(1) + "------------"
						+ "username" + "------------" + executeQuery.getString(2) + "------------"
						+ "password" + "------------" + executeQuery.getString(3) + "------------"
						+ executeQuery.getString(4) + "------------" + executeQuery.getString(5));
				list.add(sb.toString());
			}
			obj = list;

		} catch (Exception e) {
			e.printStackTrace();
			obj = e.getMessage();
		} finally {
			try {
				createStatement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return obj;
	}

}
