package WebShop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import WebShop.Controller.User.BaseController;
import WebShop.Service.User.HomeServiceImpl;

@Controller
public class ProductAdminController extends BaseController{
	@Autowired
	HomeServiceImpl _homeService;
	
	@RequestMapping(value = "/admin/san-pham")
	public ModelAndView Index() {
		mvShare.addObject("highlight", _homeService.GetHighLightProducts());
		mvShare.setViewName("admin/products/product");
		return mvShare;
	}
}
