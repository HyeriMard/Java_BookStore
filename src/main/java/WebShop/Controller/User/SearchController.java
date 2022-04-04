package WebShop.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Dto.PaginatesDto;
import WebShop.Dto.ProductDto;
import WebShop.Service.User.CategoryServiceImpl;
import WebShop.Service.User.PaginatesServiceImpl;
import WebShop.Service.User.ProductServiceImpl;

@Controller
public class SearchController extends BaseController {
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginatesService;
	@Autowired
	private ProductServiceImpl productService;

	// đối số 9 sản phẩm
	private int totalProductsPage = 9;
	private static String keyword1;

	// tìm kiếm
	@RequestMapping(value = "search")
	public ModelAndView Search(@RequestParam String keyword) {
		if (keyword != null) {
			keyword1 = keyword;
			List<ProductDto> list = categoryService.Search(keyword.toString());
			mvShare.addObject("list", list);
			mvShare.addObject("keyword", keyword);
			int totalData = categoryService.Search(keyword.toString()).size();
			PaginatesDto paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage, 1);
			mvShare.addObject("paginateInfo", paginateInfo);
			mvShare.addObject("productsPaginate",
					categoryService.GetProductsPaginateKeyWord(paginateInfo.getStart(), totalProductsPage, keyword));
		} else {
			mvShare.addObject("status", "No products were found");
		}
		mvShare.setViewName("user/searchitem/search");
		return mvShare;
	}

//		@RequestMapping(value = "/search")
//		public ModelAndView Product() {
//			mvShare.setViewName("user/searchitem/search");
//			int totalData = productService.GetAllProduct().size();
//			PaginatesDto paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage, 1);
//			mvShare.addObject("paginateInfo", paginateInfo);
//			mvShare.addObject("productsPaginate", productService.GetAllProductsPaginate(paginateInfo.getStart(), totalProductsPage));
//			return mvShare;
//		}

	@RequestMapping(value = "/search/{currentPage}")
	public ModelAndView Product(@PathVariable String currentPage) {
		mvShare.setViewName("user/searchitem/search");
		int totalData = categoryService.Search(keyword1).size();
		PaginatesDto paginateInfo = paginatesService.GetInfoPaginate(totalData, totalProductsPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("paginateInfo", paginateInfo);
		mvShare.addObject("productsPaginate",
				categoryService.GetProductsPaginateKeyWord(paginateInfo.getStart(), totalProductsPage, keyword1));
		return mvShare;
	}
}
