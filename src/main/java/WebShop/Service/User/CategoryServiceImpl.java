package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.ProductsDao;
import WebShop.Dto.ProductDto;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<ProductDto> GetAllProductsByID(int id) {
		return productsDao.GetAllProductsByID(id);
	}
	
	@Override
	public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		return productsDao.GetDataProductsPaginate(id, start, totalPage);
	}

}
