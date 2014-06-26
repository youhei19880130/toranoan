package toranoan;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
		try{

			HttpSession session = ((HttpServletRequest)request).getSession(false);

			if (session == null){
				((HttpServletResponse)response).sendRedirect("/toranoan/logout.jsp");
				return;
			}
			chain.doFilter(request, response);
	    }catch (ServletException se){
	    }catch (IOException e){
	    }
	}

	public void init(FilterConfig filterConfig) throws ServletException{
	}

	public void destroy(){
	}
}
