package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.CategorysDao;
import WebShop.Dao.ProductsDao;
import WebShop.Dto.Categorys;
import WebShop.Dto.Product;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductsDao productsDao;
	@Autowired
	private CategorysDao categorysDao;

	@Override
	public List<Product> Search(String keyword) {
		return productsDao.Search(keyword);
	}
	
	@Override
	public List<Product> GetProductsPaginateKeyWord(int start, int totalPage, String keyword) {
		return productsDao.GetProductsPaginateKeyWord(start, totalPage, keyword);
	}


	@Override
	public List<Product> GetAllProductsByID(int id) {
		return productsDao.GetAllProductsByID(id);
	}

	@Override
	public List<Product> GetDataProductsPaginate(int id, int start, int totalPage) {
		return productsDao.GetDataProductsPaginate(id, start, totalPage);
	}

	// categoryAdmin
	@Override
	public List<Categorys> GetCatetByID(long id) {
		return categorysDao.GetCateByID(id);
	}

	@Override
	public int CreateCategory(Categorys newCate) {
		return categorysDao.CreateCategory(newCate);
	}

	@Override
	public int DeleteCate(long id) {
		return categorysDao.DeleteCate(id);
	}

	@Override
	public int EditCategory(Categorys editCate) {
		return categorysDao.EditCategory(editCate);
	}

	@Override
	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategorys();
	}

	
}
