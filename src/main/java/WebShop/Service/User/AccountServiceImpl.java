package WebShop.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.UsersDao;
import WebShop.Dto.Categorys;
import WebShop.Dto.Users;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	UsersDao usersDao = new UsersDao();

	public int AddAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return usersDao.AddAccount(user);
	}

	public Users CheckAccount(Users user) {
		String pass = user.getPassword();
		user = usersDao.GetUserByAcc(user);
		if (user != null) {
			if (BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			} else {
				return null;
			}
		}
		return null;
	}
	@Override
	public Users LoginAmin(Users user) {
		String pass = user.getPassword();
		user = usersDao.GetUserAdmin(user);
		if (user != null) {
			if (BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			} else {
				return null;
			}
		}
		return null;
	
		
	}
	@Override
	public List<Users> GetUsersAdmin() {
		return usersDao.GetUsersAdmin();
	}
}
