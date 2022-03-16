package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

@WebFilter("/entrance")
public class controllerFilter implements Filter {
   
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String getAction = request.getParameter("action");
		String functionReturn = null;
		String className = "action." + getAction;
				
		try {
			Class cls = Class.forName(className);
			Action action = (Action) cls.newInstance();
			functionReturn = action.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException| IOException e) {
			throw new ServletException(e);
		}
		
		String[] typeAndAdress = functionReturn.split(":");
		
		if(typeAndAdress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeAndAdress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAndAdress[1]);
		}
	}

}
