package WebShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController extends BaseController{
	@RequestMapping(value = { "/contact" })
	public String Contact() {
//		mvShare.setViewName("user/contact");
		return "user/contact";
	}
}
