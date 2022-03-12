package WebShop.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Controller.User.BaseController;

@Controller
public class DashBoardAdminController {
	@RequestMapping(value = { "/admin/dashboard" })
	public String Index() {
		return "admin/dashboard";
	}
}
