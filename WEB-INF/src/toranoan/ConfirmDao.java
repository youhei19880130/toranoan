package toranoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.regexp.internal.recompile;

public class ConfirmDao {
	
	private static final String LASTID_SQL = "SELECT LAST_INSERT_ID() FROM ORDERLIST";
	private static final String ORDERITEMLIST_SQL = "INSERT INTO ORDERITEMLIST (ORDERID,ITEMID,ITEM,PRICE,UNIT) VALUES (?,?,?,?,?)";


	public static int postOrder(int amount) {
		String sqlin = "INSERT INTO ORDERLIST (AMOUNT) VALUES ("+amount+")";
		String sqlid = LASTID_SQL;
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		int a = 0;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sqlin);
			rs = smt.executeQuery(sqlid);
			rs.next();
			a = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("SQLException:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ihnore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		return a;
	}
	
	
	public static void postOrderitem(String[] strBind) {
		String strSQL =ORDERITEMLIST_SQL;
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(strSQL);
			if(strBind != null) {
				for(int i=0; i<strBind.length; i++) {
					ps.setString(i + 1, strBind[i]);
				}
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ihnore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
