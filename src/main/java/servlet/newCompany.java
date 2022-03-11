package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
		
		response.sendRedirect("companyList");
		
		/*
		RequestDispatcher rd = request.getRequestDispatcher("/companyList");
		request.setAttribute("company", company.getName());
		rd.forward(request, response); */
	}

}
