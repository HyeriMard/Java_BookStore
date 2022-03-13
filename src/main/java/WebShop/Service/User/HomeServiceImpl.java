package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.CategorysDao;
import WebShop.Dao.MenusDao;
import WebShop.Dao.ProductsDao;
import WebShop.Dao.SlidesDao;
import WebShop.Dto.ProductDto;
import WebShop.Enity.Categorys;
import WebShop.Enity.Menus;
import WebShop.Enity.Slides;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategorysDao categorysDao;
	@Autowired
	private MenusDao menusDao;
	@Autowired
	private ProductsDao productsDao;
	
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}

	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategorys();
	}
	
	public List<Menus> GetDataMenus() {
		return menusDao.GetDataMenus();
	}

	public List<ProductDto> GetDataProducts() {
		List<ProductDto> listProduct = productsDao.GetDataProducts();
		return listProduct;
	}
	public List<ProductDto> GetNewProducts() {
		List<ProductDto> listProduct = productsDao.GetNewProducts();
		return listProduct;
	}
	public List<ProductDto> GetHighLightProducts() {
		List<ProductDto> listProduct = productsDao.GetHighLightProducts();
		return listProduct;
	}
	public List<ProductDto> GetDataThreeProduct() {
		List<ProductDto> listProduct = productsDao.GetDataThreeProduct();
		return listProduct;
	}
	//phan admin
	public List<ProductDto> GetProducts() {
		List<ProductDto> listProduct = productsDao.GetProducts();
		return listProduct;
	}
	public int CreateProduct(ProductDto newPro) {
		return 	productsDao.CreateProdut(newPro);
	}
	public List<ProductDto> GetProductByID(long id) {
		return 	productsDao.GetOneProductsByID(id);
	}
	public int DeleteProduct(long id) {
		return 	productsDao.DeleteProdut(id);
	}
}
