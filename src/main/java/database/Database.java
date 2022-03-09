package database;

import java.util.ArrayList;
import java.util.List;

import model.Company;

public class Database {
	
	private static List<Company> companyList = new ArrayList<>();
	
	static {
		Company oobj = new Company("Oobj"); 
		Company alura = new Company("Alura");
		companyList.add(oobj);
		companyList.add(alura);
	}
	
	public void addCompany(Company company) {
		companyList.add(company);
	}
	
	public List<Company> getCompany(){
		return companyList;
	}

}
