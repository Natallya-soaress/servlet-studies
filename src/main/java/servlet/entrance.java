package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ChangeCompany;
import action.CompanyList;
import action.NewCompany;
import action.RemoveCompany;
import action.ShowCompany;

@WebServlet("/entrance")
public class entrance extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String getAction = request.getParameter("action");
		
		if(getAction.equals("showCompany")) {
			
			ShowCompany showCompany = new ShowCompany();
			showCompany.execute(request, response);
			
		} else if (getAction.equals("changeCompany")) {
			
			ChangeCompany changeCompany = new ChangeCompany();
			changeCompany.execute(request, response);
			
		} else if (getAction.equals("removeCompany")) {
			
			RemoveCompany removeCompany = new RemoveCompany();
			removeCompany.execute(request, response);
			
		} else if (getAction.equals("newCompany")) {
			
			NewCompany newCompany = new NewCompany();
			newCompany.execute(request, response);
			
		} else if (getAction.equals("companyList")) {
			
			CompanyList companyList = new CompanyList();
			companyList.execute(request, response);
			
		}
	}

}
