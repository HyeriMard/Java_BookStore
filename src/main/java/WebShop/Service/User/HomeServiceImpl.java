package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.BaseDao;
import WebShop.Dao.BillsDao;
import WebShop.Dao.CategorysDao;
import WebShop.Dao.MenusDao;
import WebShop.Dao.ProductsDao;
import WebShop.Dao.SlidesDao;
import WebShop.Dto.Bills;
import WebShop.Dto.BillsDetail;
import WebShop.Dto.Categorys;
import WebShop.Dto.Menus;
import WebShop.Dto.Product;
import WebShop.Dto.Slides;

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
	@Autowired
	private BillsDao billDao;
	
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}

	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategorys();
	}
	
	public List<Menus> GetDataMenus() {
		return menusDao.GetDataMenus();
	}

	public List<Product> GetDataProducts() {
		List<Product> listProduct = productsDao.GetDataProducts();
		return listProduct;
	}
	public List<Product> GetNewProducts() {
		List<Product> listProduct = productsDao.GetNewProducts();
		return listProduct;
	}
	public List<Product> GetHighLightProducts() {
		List<Product> listProduct = productsDao.GetHighLightProducts();
		return listProduct;
	}
	public List<Product> GetFourProduct() {
		List<Product> listProduct = productsDao.GetFourProduct();
		return listProduct;
	}
	//-=-=-=-=-=-=-=-=-=-=phan admin-=-=-=-=-=-
	

	//phần categpry
	public List<Categorys> GetCatetByID(long id) {
		return 	categorysDao.GetCateByID(id);
	}
	public int CreateCategory(Categorys newCate) {
		return 	categorysDao.CreateCategory(newCate);
	}
	public int DeleteCate(long id) {
		return 	categorysDao.DeleteCate(id);
	}
	public int EditCategory(Categorys editCate) {
		return 	categorysDao.EditCategory(editCate);
	}

}
