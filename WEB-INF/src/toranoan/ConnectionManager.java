package toranoan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * シンプルなコネクション管理クラス
 */
public class ConnectionManager {

	/*
	 * JDBCドライバのクラス名
	 */
	final static String DRIVER = "com.mysql.jdbc.Driver";
	
	/*
	 * データべースのURL
	 */
	final static String URL = "jdbc:mysql://localhost/mydb";
	
	/*
	 * データベースのユーザー
	 */
	final static String USER = "root";
	
	/*
	 * データベースのパスワード
	 */
	final static String PASS = "Gurragu777";
	
	/*
	 * Connectionを取得します。
	 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("Fail to class load : "+e.getMessage());
		}
		Connection con = DriverManager.getConnection(URL,USER,PASS);
		return con;
	}
}
