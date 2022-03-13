package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Company;

public class CompanyList {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database database = new Database();
		
		List<Company> companyList = database.getCompany();
		request.setAttribute("companyList", companyList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/companyList.jsp");
		rd.forward(request, response);
	}
}
