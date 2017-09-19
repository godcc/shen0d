package cc.shen0d.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ≤‚ ‘sql◊¢»Î
 * @author sihan
 *
 */
public class JDBCUtil {
	private static JDBCUtil jdbc = null;

	private JDBCUtil() {
	}

	public Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql:///WebSocket?createDatabaseIfNotExist=true",
				"root", "root");
	}

	public synchronized static JDBCUtil getInstance() {
		if (jdbc == null) {
			jdbc = new JDBCUtil();
		}
		return jdbc;
	}

}
