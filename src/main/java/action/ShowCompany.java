package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Company;

public class ShowCompany implements Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String getId = request.getParameter("id");
		Integer id = Integer.valueOf(getId);
		
		Database database = new Database();
		Company company = database.searchId(id);
		request.setAttribute("company", company);
		
;
		return "forward:formEditCompany.jsp";
	}
}
