package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Dto.Categorys;
import WebShop.Dto.Users;
import WebShop.Enity.MapperCategorys;
import WebShop.Enity.MapperUsers;

@Repository
public class UsersDao extends BaseDao {
	// câu lệnh thêm tài khoản
	public int AddAccount(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `users` ");
		sql.append("(`user`, `password`, `display_name`, `address`, `roleID`) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("     '" + user.getUser() + "', ");
		sql.append("     '" + user.getPassword() + "', ");
		sql.append("     '" + user.getDisplay_name() + "', ");
		sql.append("     '" + user.getAddress() + "', ");
		sql.append("     '" + 2 + "' ");
		sql.append(")");
		int insert = jdbcTemplate.update(sql.toString());
		return insert;
	};
	// thực thi câu lệnh thêm tài khoản
	public Users GetUserByAcc(Users user) {
		String sql = "SELECT * FROM users WHERE user = '" + user.getUser() + "'";
		Users result = jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	};
	//-=-=--=-=-
	public Users GetUserAdmin(Users user) {
		try {
			String sql = "SELECT * FROM users WHERE `roleID` = 1 and user = '" + user.getUser() + "'";
					
			Users result = jdbcTemplate.queryForObject(sql, new MapperUsers());
		
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	};
	
	public List<Users> GetUsersAdmin() {
		try {
			String sql = "SELECT * FROM users WHERE `roleID` = 2";
			List<Users> list = new ArrayList<Users>();
					
			list = jdbcTemplate.query(sql, new MapperUsers());
		
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	};
	
}
