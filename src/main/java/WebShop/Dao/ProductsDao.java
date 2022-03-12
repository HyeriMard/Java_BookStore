package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Dto.ProductDto;
import WebShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {

	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM products ");
		return sql;
	}

	private String SqlProduct(boolean newProduct, boolean highlight) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (highlight) {
			sql.append("AND highlight = true ");
		}
		if (newProduct) {
			sql.append("AND new_product = true ");
		}
		sql.append(" ORDER BY RAND() ");
		if (highlight) {
			sql.append("LIMIT 6 ");
		}
		if (newProduct) {
			sql.append("LIMIT 8 ");
		}
		return sql.toString();
	}

	private StringBuffer SqlProductByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 AND cateID = " + id + " ");
		return sql;
	}

	private String SqlProductPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductByID(id);
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql.toString();
	}

	public List<ProductDto> GetNewProducts() {
		String sql = SqlProduct(YES, NO);
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public List<ProductDto> GetHighLightProducts() {
		String sql = SqlProduct(NO, YES);
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public List<ProductDto> GetDataProducts() {
		String sql = "SELECT * FROM products ORDER BY RAND() LIMIT 6";
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	
	public List<ProductDto> GetDataThreeProduct() {
		String sql = "SELECT * FROM `products` ORDER BY RAND() LIMIT 3";
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public List<ProductDto> GetAllProductsByID(int id) {
		String sql = SqlProductByID(id).toString();
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public List<ProductDto> GetDataProductsPaginate(Integer id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductByID(id);
		List<ProductDto> listProductsByID = jdbcTemplate.query(sqlGetDataByID.toString(), new ProductsDtoMapper());
		List<ProductDto> listProducts = new ArrayList<ProductDto>();
		if (listProductsByID.size() > 0) {
			String sql = SqlProductPaginate(id, start, totalPage);
			listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		return listProducts;
	}

	private String SqlOneProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE id = " + id + " ");
		return sql.toString();
	}

	public List<ProductDto> GetOneProductsByID(long id) {
		String sql = SqlOneProductByID(id);
		List<ProductDto> listProduct = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProduct;
	}

	public ProductDto FindProductsByID(long id) {
		String sql = SqlOneProductByID(id);
		ProductDto listProduct = jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return listProduct;
	}
}
