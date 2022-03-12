package WebShop.Dao;

import org.springframework.stereotype.Repository;

import WebShop.Enity.MapperUsers;
import WebShop.Enity.Users;

@Repository
public class UsersDao extends BaseDao {
	public int AddAccount(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `users` ");
		sql.append("(`user`, `password`, `display_name`, `address`, `roleID`) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("     '" + user.getUser() + "', ");
		sql.append("     '" + user.getPassword() + "', ");
		sql.append("     '" + user.getDisplay_name() + "', ");
		sql.append("     '" + user.getAddress() + "' ");
		sql.append("     '" + 2 + "' ");
		sql.append(")");
		int insert = jdbcTemplate.update(sql.toString());
		return insert;
	};

	public Users GetUserByAcc(Users user) {
		String sql = "SELECT * FROM users WHERE user = '" + user.getUser() + "'";
		Users result = jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	};
}
