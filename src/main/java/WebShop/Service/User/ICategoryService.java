package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.ProductDto;
import WebShop.Enity.Categorys;

@Service
public interface ICategoryService {
	public List<ProductDto> GetAllProductsByID(int id);

	public List<ProductDto> GetDataProductsPaginate(int id, int start, int end);
	
	public List<Categorys> GetCatetByID(long id);
	
	public int CreateCategory(Categorys newCate);
	
	public int DeleteCate(long id);
	
	public int EditCategory(Categorys editCate);
	
	
	
	public List<Categorys> GetDataCategorys();
}
