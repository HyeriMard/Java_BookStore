package WebShop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Controller.User.BaseController;
import WebShop.Service.User.HomeServiceImpl;
@Controller
public class CategoryAdminController  extends BaseController{
	@Autowired
	HomeServiceImpl _homeService;
	
	
	@RequestMapping(value = "/admin/the-loai")
	public ModelAndView Index() {
		
	
		// lấy danh sách thể loại
		mvShare.addObject("cates", _homeService.GetDataCategorys());

		mvShare.setViewName("admin/categoris/category");
		return mvShare;
	}
}
