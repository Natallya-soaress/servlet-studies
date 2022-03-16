package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import database.Database;
import model.Company;

@WebServlet("/companyService")
public class companyService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Company> companyList = new Database().getCompany();
		
		String value = request.getHeader("Accept");
		
		if(value.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("company", Company.class);
			String xml = xstream.toXML(companyList);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml); 
		} else if(value.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(companyList);
			
			response.setContentType("application/json");
			response.getWriter().print(json); 
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'No content'}");
		}	
		
	}

}
