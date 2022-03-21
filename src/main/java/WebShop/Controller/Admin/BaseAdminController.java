package WebShop.Controller.Admin;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import WebShop.Controller.User.BaseController;
import WebShop.Service.User.HomeServiceImpl;

public class BaseAdminController extends HttpServlet {

	public ModelAndView mvShare = new ModelAndView();
	public static HttpSession session;

	public void createSS(HttpServletRequest request, HttpSession session_) {
		
		session = request.getSession(true);
		System.out.print("-----B1-----");
	}
 
	public boolean isLogin() {
		
		//get an integer sessioin attribute
		System.out.print("-----B3-----");
		long ID =0;
		try {
			ID = (long) session.getAttribute("userAdmin");
		}
		
		catch (Exception e) {
			// TODO: handle exception
			
		}
		
		if (ID==0) {
			System.out.print("-----khong dang nhap-----");

			mvShare.setViewName("redirect:/login/");

			return false;
		}
		System.out.print("----dang nhap-----");
		mvShare.setViewName("redirect:/admin/san-pham");
		return true;
	}

}
