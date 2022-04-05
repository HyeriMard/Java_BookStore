package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.Product;

@Service
public interface IProductService {
	public Product GetOneProductsByID(long id);
	public List<Product> GetOneProductsByIDCategory(int id);
	
	public List<Product> GetAllProduct();
	public List<Product> GetAllProductsPaginate( int start, int end);
	public List<Product> GetProducts();
	public int CreateProduct(Product newPro);
	public List<Product> GetProductByID(long id);
	public int DeleteProduct(long id);
	public int EditProduct(Product pro) ;

}
