package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.ProductDto;

@Service
public interface IProductService {
	public ProductDto GetOneProductsByID(long id);
	public List<ProductDto> GetOneProductsByIDCategory(int id);
	
	public List<ProductDto> GetAllProduct();
	public List<ProductDto> GetAllProductsPaginate( int start, int end);
}
