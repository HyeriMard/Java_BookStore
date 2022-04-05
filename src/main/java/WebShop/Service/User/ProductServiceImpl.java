package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.BaseDao;
import WebShop.Dao.ProductsDao;
import WebShop.Dto.Product;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductsDao productsDao = new ProductsDao();

	@Override
	public Product GetOneProductsByID(long id) {
		List<Product> listProduct = productsDao.GetOneProductsByID(id);
		return listProduct.get(0);
	}

	@Override
	public List<Product> GetOneProductsByIDCategory(int id) {
		return productsDao.GetAllProductsByID(id);
	}

	@Override
	public List<Product> GetAllProduct() {
		return productsDao.GetAllProduct();
	}

	@Override
	public List<Product> GetAllProductsPaginate(int start, int totalPage) {
		return productsDao.GetAllProductsPaginate(start, totalPage);
	}

	// -=-=-=-=-=admin-=-=--=-=-=
	@Override
	public List<Product> GetProducts() {
		List<Product> listProduct = productsDao.GetProducts();
		return listProduct;
	}

	@Override
	public int CreateProduct(Product newPro) {
		return productsDao.CreateProdut(newPro);
	}

	@Override
	public List<Product> GetProductByID(long id) {
		return productsDao.GetOneProductsByID(id);
	}

	@Override
	public int DeleteProduct(long id) {
		return productsDao.DeleteProdut(id);
	}

	@Override
	public int EditProduct(Product pro) {
		return productsDao.EditProdut(pro);
	}

}
