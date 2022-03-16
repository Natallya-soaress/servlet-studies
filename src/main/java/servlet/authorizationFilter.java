package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrance")
public class authorizationFilter implements Filter {
   
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String getAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean notLoggedUser = (session.getAttribute("loggedUser") == null);
		boolean protectedAction = !(getAction.equals("Login") || getAction.equals("LoginForm"));
		
		if(protectedAction && notLoggedUser) {
			response.sendRedirect("entrance?action=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
