package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.Categorys;
import WebShop.Dto.Product;

@Service
public interface ICategoryService {
	public List<Product> GetAllProductsByID(int id);

	public List<Product> GetDataProductsPaginate(int id, int start, int end);
	
	public List<Categorys> GetCatetByID(long id);
	
	public int CreateCategory(Categorys newCate);
	
	public int DeleteCate(long id);
	
	public int EditCategory(Categorys editCate);
	
	
	public List<Categorys> GetDataCategorys();
	public List<Product> Search(String keyword);
	public List<Product> GetProductsPaginateKeyWord(int start, int totalPage, String keyword);
}
