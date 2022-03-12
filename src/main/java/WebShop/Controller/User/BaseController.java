package WebShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Service.User.HomeServiceImpl;

@Controller
public class BaseController{
	@Autowired
	HomeServiceImpl _homeService;
	public ModelAndView mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init() {
		mvShare.addObject("menus", _homeService.GetDataMenus());
		return mvShare;
	}
}
