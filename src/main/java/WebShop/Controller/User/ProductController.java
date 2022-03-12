package WebShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductServiceImpl productService;
	
	@RequestMapping(value = "/chi-tiet-san-pham/{id}")
	public ModelAndView Product(@PathVariable long id) {
		mvShare.setViewName("user/products/product");
		int idCategory = productService.GetOneProductsByID(id).getCateID();
		mvShare.addObject("ProductsByIDCategory", productService.GetOneProductsByIDCategory(idCategory));
		mvShare.addObject("product", productService.GetOneProductsByID(id));
		return mvShare;
	}
}
