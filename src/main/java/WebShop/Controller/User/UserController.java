package WebShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Enity.Users;
import WebShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		mvShare.setViewName("user/account/register");
		mvShare.addObject("user",new Users());
		return mvShare;
	}
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") Users user) {
		int count = accountService.AddAccount(user);
		if(count > 0) {
			mvShare.addObject("status", "Đăng ký thành công");
		}else {
			mvShare.addObject("status", "Đăng ký thất bại");
		}
		mvShare.setViewName("user/account/register");
		return mvShare;
	}
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
		user = accountService.CheckAccount(user);
		if(user != null) {
			mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
		}else {
			mvShare.addObject("statusLogin", "Đăng nhập thất bại");
		}
		return mvShare;
	}
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	}
}
