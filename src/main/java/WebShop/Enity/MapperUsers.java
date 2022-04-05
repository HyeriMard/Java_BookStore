package WebShop.Enity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WebShop.Dto.Users;

public class MapperUsers implements RowMapper<Users>{
	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt("id"));
		user.setUser(rs.getString("user"));
		user.setPassword(rs.getString("password"));
		user.setDisplay_name(rs.getString("display_name"));
		user.setAddress(rs.getString("address"));
		return user;
	}
}
