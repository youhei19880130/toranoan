package toranoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthDao {

	private static final String IDPASS_SQL = "SELECT USERPASS FROM USERLIST WHERE USERID = ? and USERPASS = ? ";

	public static String returnCorrectPass(String entryid, String entrypass) {
		if (entryid == null || entryid.length() == 0 || entrypass == null || entrypass.length() == 0){
			return null;
		} 
		String strSQL = IDPASS_SQL;
		String[] strBind = {entryid,entrypass};
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
			rs = ps.executeQuery();
		    if (rs.next()){
		    	String correctpass = rs.getString("USERPASS");
		    	return correctpass;
		    }else{
		    	return null;
		    }			
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
	return null;
	}
	
}
