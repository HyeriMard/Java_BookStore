package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.CategorysDao;
import WebShop.Dao.ProductsDao;
import WebShop.Dto.ProductDto;
import WebShop.Enity.Categorys;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductsDao productsDao;
	@Autowired
	private CategorysDao categorysDao;

	@Override
	public List<ProductDto> GetAllProductsByID(int id) {
		return productsDao.GetAllProductsByID(id);
	}

	@Override
	public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		return productsDao.GetDataProductsPaginate(id, 0, totalPage);
	}
	
	//-=-=-=-=-=-=-=-=phần admin-==-=-=-=-=-=-=
	@Override
	public List<Categorys> GetCatetByID(long id) {
		return 	categorysDao.GetCateByID(id);
	}
	@Override
	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategorys();
	}

}
