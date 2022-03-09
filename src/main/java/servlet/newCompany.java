package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Company;

@WebServlet("/newCompany")

public class newCompany extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		
		Company company = new Company(name);
		
		Database database = new Database();
		database.addCompany(company);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Empresa " + name + " cadastrada!!");
		out.println("</body>");
		out.println("</html>");
	}

}
