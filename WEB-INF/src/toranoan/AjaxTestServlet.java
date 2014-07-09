package toranoan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import model.MessageBean;
import net.arnx.jsonic.JSON;

public class AjaxTestServlet extends HttpServlet {
	private final String REQUEST_STRING = "requestJs";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String parameter = req.getParameter(REQUEST_STRING);
//		String str = (String) JSON.decode(parameter);
		//サーブレットに送信されたメッセージが表示される。
//		System.out.println(bean.getMessage());

		String responseJson = "{\"responseMessage\" : \""+parameter+"を入力しました。\"}";
//		System.out.println(responseJson);
		res.setContentType("application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(responseJson);
	}
}