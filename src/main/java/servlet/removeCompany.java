package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;

@WebServlet("/removeCompany")

public class removeCompany extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String getId = request.getParameter("id");
		Integer id = Integer.valueOf(getId);
		
		Database database = new Database();
		database.removeCompany(id);
		
		response.sendRedirect("companyList");
	}
}
