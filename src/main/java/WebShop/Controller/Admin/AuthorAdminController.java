package WebShop.Controller.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Dto.Users;
import WebShop.Service.User.AccountServiceImpl;

@Controller
public class AuthorAdminController extends BaseAdminController {

	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	@RequestMapping(value = "/login")
	public ModelAndView Index() {

		if (isLogin()==false) {	
			mvShare.clear();
			mvShare.addObject("userLogin", new Users());
			mvShare.setViewName("redirect:/login/");
			
		}
		
		return mvShare;
	}

	@RequestMapping(value = "/admin")
	public ModelAndView Admin() {
		mvShare.clear();
		if (isLogin()==false) {		
			mvShare.setViewName("redirect:/login/");
			return mvShare;
		}
		return mvShare;
	}

	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public ModelAndView Login() {

		if (isLogin()==false) {	
			mvShare.clear();
			mvShare.addObject("userLogin", new Users());
			mvShare.setViewName("admin/login");
		}
		
		return mvShare;
	}

	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest request, HttpSession session_,
			@ModelAttribute("userLogin") Users user) {

		Users userAdmin = accountService.LoginAmin(user);
		mvShare.clear();
		if (userAdmin != null) {
			
			createSS(request, session_);
			session.setAttribute("userAdmin", userAdmin.getId());
			System.out.print("-----B2-----");
			mvShare.setViewName("redirect:/admin/san-pham");
		} else {

			mvShare.setViewName("admin/login");
			mvShare.addObject("status", "Thất bại");
		}

		return mvShare;
	}
	//logout 
	@RequestMapping(value = "admin/logout")
	public ModelAndView Logout() {
		session.removeAttribute("userAdmin");
		mvShare.setViewName("redirect:/");
		return mvShare;
	}
}
