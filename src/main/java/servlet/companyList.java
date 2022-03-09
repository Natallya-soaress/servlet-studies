package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Company;

@WebServlet(urlPatterns = "/companyList")

public class companyList extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Database database = new Database();
		List<Company> companyList = database.getCompany();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html> <body>");
		out.println("<ul>");
		for(Company company : companyList){
			out.println("<li>" + company.getName() + "</li>");
		}
		out.println("</ul>");
		out.println("</body> </html>");
	}

}
