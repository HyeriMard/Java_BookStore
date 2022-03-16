package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.ProductDto;
import WebShop.Enity.Categorys;

@Service
public interface ICategoryService {
	public List<ProductDto> GetAllProductsByID(int id);

	public List<ProductDto> GetDataProductsPaginate(int id, int start, int end);
	
	//-=-=-=-=-=--==-=-=phần  admin-=-=-=-=-=-=-
	public List<Categorys> GetCatetByID(long id);
	public List<Categorys> GetDataCategorys();
}
