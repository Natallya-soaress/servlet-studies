package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Company;


@WebServlet("/showCompany")
public class showCompany extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String getId = request.getParameter("id");
		Integer id = Integer.valueOf(getId);
		
		Database database = new Database();
		Company company = database.searchId(id);
		request.setAttribute("company", company);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formEditCompany.jsp");
		rd.forward(request, response);
	}

}
