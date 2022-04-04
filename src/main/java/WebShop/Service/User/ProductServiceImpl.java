package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.BaseDao;
import WebShop.Dao.ProductsDao;
import WebShop.Dto.ProductDto;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductsDao productsDao = new ProductsDao();

	@Override
	public ProductDto GetOneProductsByID(long id) {
		List<ProductDto> listProduct = productsDao.GetOneProductsByID(id);
		return listProduct.get(0);
	}

	@Override
	public List<ProductDto> GetOneProductsByIDCategory(int id) {
		return productsDao.GetAllProductsByID(id);
	}

	@Override
	public List<ProductDto> GetAllProduct() {
		return productsDao.GetAllProduct();
	}

	@Override
	public List<ProductDto> GetAllProductsPaginate(int start, int totalPage) {
		return productsDao.GetAllProductsPaginate(start, totalPage);
	}

	// -=-=-=-=-=admin-=-=--=-=-=
	@Override
	public List<ProductDto> GetProducts() {
		List<ProductDto> listProduct = productsDao.GetProducts();
		return listProduct;
	}

	@Override
	public int CreateProduct(ProductDto newPro) {
		return productsDao.CreateProdut(newPro);
	}

	@Override
	public List<ProductDto> GetProductByID(long id) {
		return productsDao.GetOneProductsByID(id);
	}

	@Override
	public int DeleteProduct(long id) {
		return productsDao.DeleteProdut(id);
	}

	@Override
	public int EditProduct(ProductDto pro) {
		return productsDao.EditProdut(pro);
	}

}
