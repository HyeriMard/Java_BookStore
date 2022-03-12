package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Enity.Categorys;
import WebShop.Enity.MapperCategorys;

@Repository
public class CategorysDao extends BaseDao{

	public List<Categorys> GetDataCategorys(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM `categorys`";
		list = jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
}
