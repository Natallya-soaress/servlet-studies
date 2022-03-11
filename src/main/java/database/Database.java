package database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Company;

public class Database {
	
	private static List<Company> companyList = new ArrayList<>();
	private static Integer key = 1;
	
	static {
		Company oobj = new Company("Oobj");
		oobj.setId(key++);
		Company alura = new Company("Alura");
		alura.setId(key++);
		companyList.add(oobj);
		companyList.add(alura);
	}
	
	public void addCompany(Company company) {
		company.setId(key++);
		companyList.add(company);
	}
	
	public List<Company> getCompany(){
		return companyList;
	}

	public void removeCompany(Integer id) {
		
		Iterator<Company> it = companyList.iterator();
		while(it.hasNext()) {
			Company com = it.next();
			if(com.getId() == id) {
				it.remove();
			}
		}
		
	}

	public Company searchId(Integer id) {
		for (Company company : companyList) {
			if(company.getId() == id) {
				return company;
			}
		}
		return null;
	}

}
