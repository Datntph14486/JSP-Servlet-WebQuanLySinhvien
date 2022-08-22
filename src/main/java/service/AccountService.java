package service;

import model.Userr;
import respository.AccountRespository;

public class AccountService {
	private AccountRespository accountRespository;

	public AccountService() {
		accountRespository=new AccountRespository();
	}
	public Userr authentication(String username, String password) {
		Userr userr=accountRespository.getByUserName(username);
		if(userr == null) {
			return null;
			
		}
		if(!userr.getPassword().equals(password)) {
			return null;
		}
		return userr;
	}
	public Userr getByuser(String username) {
		Userr userr=accountRespository.getByUserName(username);
		return userr;
	}
	

}
