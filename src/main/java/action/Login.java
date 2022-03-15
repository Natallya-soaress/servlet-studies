package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.User;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		
		Database database = new Database();
		User user = database.userExists(name, password);
		
		if(user != null) {
			return "redirect:entrance?action=CompanyList";
		} else {
			return "redirect:entrance?action=LoginForm";
		}
		
	}

}
