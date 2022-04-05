package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dto.Categorys;
import WebShop.Dto.Menus;
import WebShop.Dto.Product;
import WebShop.Dto.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Categorys> GetDataCategorys();
	public List<Menus> GetDataMenus();
	public List<Product> GetDataProducts();
	
}
