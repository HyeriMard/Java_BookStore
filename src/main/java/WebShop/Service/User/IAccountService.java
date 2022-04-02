package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Enity.Categorys;
import WebShop.Enity.Users;

@Service
public interface IAccountService {
	public int AddAccount(Users user);
	
	public Users CheckAccount(Users user);
	
	//---------------------
	public Users LoginAmin(Users user);
	
	public List<Users> GetUsersAdmin();
}
