package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Dto.Menus;
import WebShop.Enity.MapperMenus;

@Repository
public class MenusDao extends BaseDao{
	public List<Menus> GetDataMenus(){
		List<Menus> list = new ArrayList<Menus>();
		String sql = "SELECT * FROM menus";
		list = jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}
}
