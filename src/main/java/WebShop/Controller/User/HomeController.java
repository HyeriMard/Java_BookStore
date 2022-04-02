package WebShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {
		mvShare.addObject("slides", _homeService.GetDataSlide());
		mvShare.addObject("categorys", _homeService.GetDataCategorys());
		mvShare.addObject("products", _homeService.GetDataProducts());
		mvShare.addObject("new_product", _homeService.GetNewProducts());
		mvShare.addObject("highlight", _homeService.GetHighLightProducts());
		mvShare.addObject("fourproduct", _homeService.GetFourProduct());
		mvShare.setViewName("user/index");
		return mvShare;
	}
}
