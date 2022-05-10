package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Dto.Categorys;
import WebShop.Enity.MapperCategorys;

@Repository
public class CategorysDao extends BaseDao{

	public List<Categorys> GetDataCategorys(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM `categorys`";
		list = jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
	//-=-=-=-=-=-=-=-=-===-=-=- phần admin
	public List<Categorys> GetCateByID(long id) {
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM `categorys` WHERE id = " + id;
		list = jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
	
	
	//thêm cate
	public int CreateCategory(Categorys newCate) {

		try {
			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO `categorys` ");
			sql.append("(`id`, `name`, `description`)");
			sql.append("VALUES ");
			sql.append("(NULL, ");
			sql.append("    '" + newCate.getName() + "', "); // name
			sql.append("    '" + newCate.getDescription() + "'"); // Detail
			sql.append(")");
			int insert = jdbcTemplate.update(sql.toString());
			return insert;
		} catch (Exception e) {
			System.out.print(e);
			return 0;
		}
		

	}
	
	//xóa cate
	public int DeleteCate(long id) {
		try {
			String sql = "DELETE FROM `categorys` WHERE `categorys`.`id` =" + id;

			int insert = jdbcTemplate.update(sql.toString());
			return insert;
		} catch (Exception e) {
			return 0;
		}

	}
	//sửa cate
	public int EditCategory(Categorys editCate) {

		try {
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE `categorys` SET ");
			sql.append("  `name` =  '" + editCate.getName() + "', "); // name
			sql.append("    `description` = '" + editCate.getDescription() + "'"); // Detail
			sql.append(" WHERE `id`= '" + editCate.getId()+"' ");
			
			int insert = jdbcTemplate.update(sql.toString());
			return insert;
		} catch (Exception e) {
			System.out.print(e);
			return 0;
		}
		

	}
	
	



	
	
	
}
