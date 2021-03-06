package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Company;

public class CompanyList implements Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database database = new Database();
		
		List<Company> companyList = database.getCompany();
		request.setAttribute("companyList", companyList);
		
		return "forward:companyList.jsp";
	}
}
