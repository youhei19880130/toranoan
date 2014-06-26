package toranoan;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	
		//　注文情報の送信
		HashMap<String, Object> ordermap = (HashMap<String, Object>) session.getAttribute("ordermap");
		Iterator it = ordermap.keySet().iterator();
		int amount = 0;
        while(it.hasNext()){
            Object obj = it.next();
            Item itm = (Item) ordermap.get(obj);
    		int anamount = itm.getPrice()*itm.getVolume();
    		amount += anamount;
        }
        int a = ConfirmDao.postOrder(amount);
		
		//　注文詳細情報の送信
		it = ordermap.keySet().iterator();
        while(it.hasNext()){
            Object obj = it.next();
            Item itm = (Item) ordermap.get(obj);
    		String[] strBind = {String.valueOf(a), itm.getId(), itm.getItem(), String.valueOf(itm.getPrice()), String.valueOf(itm.getVolume())};
    		ConfirmDao.postOrderitem(strBind);
        }
        
    	//注文情報をセッションから削除
    	session.removeAttribute("ordermap");
		
		// 次に遷移するページ(初期値)
		String nextPage = "/confirm.jsp";
			
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}	
}
