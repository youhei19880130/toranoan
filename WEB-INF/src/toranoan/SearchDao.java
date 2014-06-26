package toranoan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * 検索を操作するビジネスロジック
 */
public class SearchDao {
	/*
	 * シングルトンのインスタンス
	 */
	private static SearchDao controller = new SearchDao();
	
	/*
	 * このクラスのインスタンスを取得します。
	 * 
	 * @return SerchItemのインスタンス
	 */
	public static SearchDao getInstance() {
		return controller;
	}

	private static String searchitem;
    private static String searchcategory;
//    private static String searchorder;
	
	/*
	 * 最近の(というか全部の)トピックを取得します。
	 * @return トピックのリスト
	 */
	public List getSearch(String searchitem,String searchcategory/*,String seachorder*/) {
		String sql;
		if (searchcategory == null) {
			sql = "SELECT ID,ITEM,PRICE,CATEGORY,HOTCOLD FROM ITEMLIST WHERE ITEM LIKE '%"
				+searchitem+"%' ORDER BY PRICE ASC";
		} else {
			sql = "SELECT ID,ITEM,PRICE,CATEGORY,HOTCOLD FROM ITEMLIST WHERE ITEM LIKE '%"
				+searchitem+"%' and CATEGORY = '"+searchcategory+"' ORDER BY PRICE ASC";
		}
/*		if (searchorder != null) {
			if (searchcategory == null) {
				sql = "SELECT ID,ITEM,PRICE,CATEGORY,HOTCOLD FROM ITEMLIST WHERE ITEM LIKE '%"
						+searchitem+"%' ORDER BY PRICE "+searchorder;
			} else {
				sql = "SELECT ID,ITEM,PRICE,CATEGORY,HOTCOLD FROM ITEMLIST WHERE ITEM LIKE '%"
						+searchitem+"%' and CATEGORY = '"+searchcategory+"' ORDER BY PRICE "+searchorder;
			}
		} else {
			if (searchcategory == null) {
				sql = "SELECT ID,ITEM,PRICE,CATEGORY,HOTCOLD FROM ITEMLIST WHERE ITEM LIKE '%"
						+searchitem+"%' ORDER BY PRICE ASC";
			} else {
				sql = "SELECT ID,ITEM,PRICE,CATEGORY,HOTCOLD FROM ITEMLIST WHERE ITEM LIKE '%"
						+searchitem+"%' and CATEGORY = '"+searchcategory+"' ORDER BY PRICE ASC";			
			}
		}*/
		List searchsqllist = new ArrayList();
		
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			while (rs.next()) {
				Bean searchrow = new Bean();
				searchrow.setId(rs.getString("id"));
				searchrow.setItem(rs.getString("item"));
				searchrow.setPrice(rs.getInt("price"));
				searchrow.setCategory(rs.getString("category"));
				searchrow.setHotcold(rs.getString("hotcold"));
				searchsqllist.add(searchrow);
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
		return searchsqllist;
	}
	
	public static void main(String[] args) {
		SearchDao ctrl = new SearchDao();
		List searchlist = ctrl.getSearch(searchitem, searchcategory/*,searchorder*/);
		for (int i = 0; i<searchlist.size(); i++) {
			System.out.println(searchlist.get(i));
		}
	}		
}
