package WebShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Dto.Paginates;
import WebShop.Service.User.PaginatesServiceImpl;
import WebShop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private PaginatesServiceImpl paginatesService;
	
	@RequestMapping(value = "/chi-tiet-san-pham/{id}")
	public ModelAndView Product(@PathVariable long id) {
		mvShare.setViewName("user/products/product");
		int idCategory = productService.GetOneProductsByID(id).getCateID();
		mvShare.addObject("ProductsByIDCategory", productService.GetOneProductsByIDCategory(idCategory));
		mvShare.addObject("product", productService.GetOneProductsByID(id));
		return mvShare;
	}
	
	private int totalProductsPage = 9;

	@RequestMapping(value = "/tat-ca-san-pham")
	public ModelAndView Product() {
		mvShare.setViewName("user/products/all_product");
		int totalData = productService.GetAllProduct().size();
		Paginates paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage, 1);
		mvShare.addObject("paginateInfo", paginateInfo);
		mvShare.addObject("productsPaginate", productService.GetAllProductsPaginate(paginateInfo.getStart(), totalProductsPage));
		return mvShare;
	}

	@RequestMapping(value = "/tat-ca-san-pham/{currentPage}")
	public ModelAndView Product(@PathVariable String currentPage) {
		mvShare.setViewName("user/products/all_product");
		int totalData = productService.GetAllProduct().size();
		Paginates paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage, Integer.parseInt(currentPage));
		mvShare.addObject("paginateInfo", paginateInfo);
		mvShare.addObject("productsPaginate", productService.GetAllProductsPaginate(paginateInfo.getStart(), totalProductsPage));
		return mvShare;
	}
}
