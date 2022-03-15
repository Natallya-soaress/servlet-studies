package database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Company;
import model.User;

public class Database {
	
	private static List<Company> companyList = new ArrayList<>();
	private static List<User> userList = new ArrayList<>();
	private static Integer key = 1;
	
	static {
		Company oobj = new Company("Oobj");
		oobj.setId(key++);
		Company alura = new Company("Alura");
		alura.setId(key++);
		companyList.add(oobj);
		companyList.add(alura);
		
		User user1 = new User("Nat", "2468");
		User user2 = new User("Root", "0000");
		userList.add(user1);
		userList.add(user2);
		
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

	public User userExists(String userName, String password) {
		
		for(User user : userList) {
			if(user.login(userName, password)) {
				return user;
			}
		}
		
		return null;
	}

}
