package WebShop.Enity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WebShop.Dto.Product;

public class MapperProducts implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setCateID(rs.getInt("cateID"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setSale(rs.getInt("sale"));
		product.setTitle(rs.getString("title"));
		product.setHighlight(rs.getBoolean("highlight"));
		product.setNew_product(rs.getBoolean("new_product"));
		product.setDetail(rs.getString("detail"));
		product.setCreated_at(rs.getDate("created_at"));
		product.setUpdated_at(rs.getDate("updated_at"));
		product.setPicture(rs.getString("picture"));
		return product;
	}

}
