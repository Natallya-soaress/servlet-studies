package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;

public class RemoveCompany implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			String getId = request.getParameter("id");
			Integer id = Integer.valueOf(getId);
			
			Database database = new Database();
			database.removeCompany(id);
	
			return "redirect:entrance?action=CompanyList";
		}
	}
