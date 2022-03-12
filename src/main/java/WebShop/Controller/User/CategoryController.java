package WebShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Dto.PaginatesDto;
import WebShop.Service.User.CategoryServiceImpl;
import WebShop.Service.User.PaginatesServiceImpl;

@Controller
public class CategoryController extends BaseController {
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginatesService;

	private int totalProductsPage = 9;

	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage, 1);
		mvShare.addObject("categoryid", id);
		mvShare.addObject("paginateInfo", paginateInfo);
		mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id), 0 , paginateInfo.getEnd()));
		return mvShare;
	}

	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
		mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage, Integer.parseInt(currentPage));
		mvShare.addObject("categoryid", id);
		mvShare.addObject("paginateInfo", paginateInfo);
		mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id), 0, paginateInfo.getEnd()));
		return mvShare;
	}
}
