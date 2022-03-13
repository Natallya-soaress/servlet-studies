package action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Company;

public class ChangeCompany {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String openingDate = request.getParameter("date");
		String getId = request.getParameter("id");
		Integer id = Integer.valueOf(getId);
		Date date = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			date = sdf.parse(openingDate);
		} catch (ParseException e){
			throw new ServletException(e);
		}
		
		Database database = new Database();
		Company company = database.searchId(id);
		
		company.setName(name);
		company.setOpeningDate(date);
		
		response.sendRedirect("entrance?action=companyList");
		
	}
}
