package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Database database = new Database();
		
		List<Company> companyList = database.getCompany();
		request.setAttribute("companyList", companyList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/companyList.jsp");
		rd.forward(request, response);

	}

}
