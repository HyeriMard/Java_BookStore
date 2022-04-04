package WebShop.Dao;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Dto.ProductDto;
import WebShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {

	private final boolean YES = true;
	private final boolean NO = false;
	// gọi tất cả sản phẩm
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM products ");
		return sql;
	}
	// gọi tất cả sản phẩm mới hoặc sản phẩm nổi bật
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
	// gọi tất cả sản phẩm có id theo category
	private StringBuffer SqlProductByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 AND cateID = " + id + " ");
		return sql;
	}
	// sản phẩm theo số lượng từng khoảng theo id cate
	private String SqlProductPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductByID(id);
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql.toString();
	}
	// gọi tất cả sản phẩm theo số lượng từng khoảng
	private String SqlGetAllProductPaginate(int start, int totalPage) {
		StringBuffer sql = SqlString();
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql.toString();
	}
	// thực thi lấy tất cả sản phẩm mới
	public List<ProductDto> GetNewProducts() {
		String sql = SqlProduct(YES, NO);
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	// thực thi lấy tất cả sản phẩm nổi bật
	public List<ProductDto> GetHighLightProducts() {
		String sql = SqlProduct(NO, YES);
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	// thực thi lấy tất cả sản phẩm random tối đa 6 sản phẩm
	public List<ProductDto> GetDataProducts() {
		String sql = "SELECT * FROM products ORDER BY RAND() LIMIT 6";
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	// thực thi lấy tất cả sản phẩm random tối đa 4 sản phẩm
	public List<ProductDto> GetFourProduct() {
		String sql = "SELECT * FROM `products` ORDER BY RAND() LIMIT 4";
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	// thực thi lấy tất cả sản phẩm theo id cate
	public List<ProductDto> GetAllProductsByID(int id) {
		String sql = SqlProductByID(id).toString();
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	// thực thi lấy tất cả sản phẩm 
	public List<ProductDto> GetAllProduct() {
		String sql = SqlString().toString();
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	// thực thi lấy trang sản phẩm hiện tại theo id cate
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
	// thực thi lấy trang sản phẩm hiện tại
	public List<ProductDto> GetAllProductsPaginate( int start, int totalPage) {
		StringBuffer sqlGetData = SqlString();
		List<ProductDto> listProduct = jdbcTemplate.query(sqlGetData.toString(), new ProductsDtoMapper());
		List<ProductDto> listProducts = new ArrayList<ProductDto>();
		if (listProduct.size() > 0) {
			String sql = SqlGetAllProductPaginate(start, totalPage);
			listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		return listProducts;
	}
	// lấy 1 sản phẩm theo id
	private String SqlOneProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE id = " + id + " ");
		return sql.toString();
	}
	// thực thi câu lệnh trả về 1 danh sách sản phẩm theo id
	public List<ProductDto> GetOneProductsByID(long id) {
		String sql = SqlOneProductByID(id);
		List<ProductDto> listProduct = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProduct;
	}
	// thực thi câu lệnh lấy 1 sản phẩm theo id
	public ProductDto FindProductsByID(long id) {
		String sql = SqlOneProductByID(id);
		ProductDto listProduct = jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return listProduct;
	}
	// thực thi tìm kiếm sản phẩm
	public List<ProductDto> Search(String keyword) {
		List<ProductDto> list = new ArrayList<ProductDto>();
		String sql = "SELECT * FROM `products` WHERE MATCH (name,title) AGAINST ('"+ keyword +"')";
		list = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	// sdfasfas
		private String SqlGetAllProductPaginateKeyWord(int start, int totalPage, String keyword) {
			StringBuffer abc = new StringBuffer();
			abc.append("SELECT * FROM `products` WHERE MATCH (name,title) AGAINST ('"+ keyword +"')");
			abc.append(" LIMIT " + start + ", " + totalPage);
			return abc.toString();
		}
	
	// agdfgd
		public List<ProductDto> GetProductsPaginateKeyWord( int start, int totalPage, String keyword) {
			String sql1 = "SELECT * FROM `products` WHERE MATCH (name,title) AGAINST ('"+ keyword +"')";
			List<ProductDto> listProduct = jdbcTemplate.query(sql1, new ProductsDtoMapper());
			List<ProductDto> listProducts = new ArrayList<ProductDto>();
			if (listProduct.size() > 0) {
				String sql = SqlGetAllProductPaginateKeyWord(start, totalPage, keyword);
				listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
			}
			return listProducts;
		}

	// -=-=-=-==-=-=-=-=-=-=-=
	// Phầm admin
	public List<ProductDto> GetProducts() {
		String sql = "SELECT * FROM `products`";
		List<ProductDto> listProducts = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public int CreateProdut(ProductDto newPro) {

		try {
			StringBuffer sql = new StringBuffer();
			// lấy ngay hien tai
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			sql.append("INSERT INTO `products` ");
			sql.append(
					"(`id`, `cateID`, `name`, `price`, `sale`, `title`, `highlight`, `new_product`, `detail`, `created_at`, `updated_at`, `picture`)");
			sql.append("VALUES ");
			sql.append("(NULL, ");
			sql.append("    '" + newPro.getCateID() + "', "); // cateID
			sql.append("    '" + newPro.getName() + "', "); // name
			sql.append("    '" + newPro.getPrice() + "', "); // price
			sql.append("    ' 0 ', "); // sale
			sql.append("    '" + newPro.getTitle() + "', "); // title
			sql.append("    ' 1 ', "); // highlight
			sql.append("    ' 1 ', "); // new_product
			sql.append("    '" + newPro.getDetail() + "', "); // Detail
			sql.append("    '" + date + "', "); // created_at =>
			sql.append("    '" + date + "', "); // updated_at (create -> created_at=updated_at)
			sql.append("    '" + newPro.getPicture() + "' "); // img
			sql.append(")");
			int insert = jdbcTemplate.update(sql.toString());
			return insert;
		} catch (Exception e) {
			return 0;
		}

	}

	public int DeleteProdut(long id) {
		try {
			String sql = "DELETE FROM `products` WHERE `products`.`id` =" + id;

			int insert = jdbcTemplate.update(sql.toString());
			return insert;
		} catch (Exception e) {
			return 0;
		}

	}

	public int EditProdut(ProductDto pro) {
		 try {

		// lấy ngay hien tai
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE `products` SET ");
		sql.append("`cateID` = '" + pro.getCateID() + "', ");
		sql.append("`name` = '" + pro.getName() + "', ");
		sql.append("`price` = '" + pro.getPrice() + "', ");
		sql.append("`title` = '" + pro.getTitle() + "', ");
		sql.append("`detail` = '" + pro.getDetail() + "', ");
		sql.append("`picture` = '" + pro.getPicture() + "', ");
		sql.append("`updated_at` = '" + date + "' ");
		sql.append(" WHERE `id`= '" + pro.getId()+"' ");
		
		int insert = jdbcTemplate.update(sql.toString());
		return insert;
		 }
		catch (Exception e) {
			return 0;
		}

	}

}
