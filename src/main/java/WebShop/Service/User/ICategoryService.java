package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.ProductDto;

@Service
public interface ICategoryService {
	public List<ProductDto> GetAllProductsByID(int id);

	public List<ProductDto> GetDataProductsPaginate(int id, int start, int end);
}
