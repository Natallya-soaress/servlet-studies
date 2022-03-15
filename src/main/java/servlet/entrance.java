package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

@WebServlet("/entrance")
public class entrance extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String functionReturn = null;
		String getAction = request.getParameter("action");
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
