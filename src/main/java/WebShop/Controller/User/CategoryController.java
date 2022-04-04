package WebShop.Controller.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Dto.PaginatesDto;
import WebShop.Dto.ProductDto;
import WebShop.Service.User.CategoryServiceImpl;
import WebShop.Service.User.PaginatesServiceImpl;
import WebShop.Service.User.ProductServiceImpl;

@Controller
public class CategoryController extends BaseController {
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginatesService;
	@Autowired
	private ProductServiceImpl productService;
	
	// đối số 9 sản phẩm
	private int totalProductsPage = 9;

	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage, 1);
		mvShare.addObject("categoryid", id);
		mvShare.addObject("paginateInfo", paginateInfo);
		mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),
				paginateInfo.getStart(), totalProductsPage));
		return mvShare;
	}

	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
		mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("categoryid", id);
		mvShare.addObject("paginateInfo", paginateInfo);
		mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),
				paginateInfo.getStart(), totalProductsPage));
		return mvShare;
	}
}
