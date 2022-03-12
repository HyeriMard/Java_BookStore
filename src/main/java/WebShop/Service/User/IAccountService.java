package WebShop.Service.User;

import org.springframework.stereotype.Service;

import WebShop.Enity.Users;

@Service
public interface IAccountService {
	public int AddAccount(Users user);
	
	public Users CheckAccount(Users user);
}
