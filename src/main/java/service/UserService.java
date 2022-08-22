package service;

import model.Userr;
import respository.UserRespository;

public class UserService {
	private UserRespository respository;

	public UserService() {
		respository =new UserRespository();
	}
	public void add(Userr userr) {
		respository.add(userr);
	}
	
	

}
