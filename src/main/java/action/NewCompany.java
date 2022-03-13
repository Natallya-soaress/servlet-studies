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

public class NewCompany {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String openingDate = request.getParameter("date");
		Date date = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			date = sdf.parse(openingDate);
		} catch (ParseException e){
			throw new ServletException(e);
		}
		
		
		Company company = new Company(name);
		company.setOpeningDate(date);
		
		Database database = new Database();
		database.addCompany(company);
		
		response.sendRedirect("entrance?action=companyList");
		
	}

}
