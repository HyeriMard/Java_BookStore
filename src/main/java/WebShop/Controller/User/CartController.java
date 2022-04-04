package WebShop.Controller.User;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Dto.CartDto;
import WebShop.Enity.Bills;
import WebShop.Enity.Categorys;
import WebShop.Enity.Users;
import WebShop.Service.User.BillServiceImpl;
import WebShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billService = new BillServiceImpl();
	
	@RequestMapping(value = "/gio-hang")
	public ModelAndView Index() {
		mvShare.addObject("slides", _homeService.GetDataSlide());
		mvShare.addObject("categorys", _homeService.GetDataCategorys());
		mvShare.addObject("products", _homeService.GetDataProducts());
		mvShare.addObject("new_product", _homeService.GetNewProducts());
		mvShare.addObject("highlight", _homeService.GetHighLightProducts());
		mvShare.setViewName("user/cart/list_cart");
		return mvShare;
	}
	// thêm giỏ hàng
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
//		return "redirect:/chi-tiet-san-pham/" + id;
		return "redirect:" + request.getHeader("Referer");
	}
	// edit giỏ hàng
	@RequestMapping(value = "gio-hang/EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable long id,
			@PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	// delete giỏ hàng
	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	// xuất thông tin vào trang thanh toán 
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session) {
		mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Users loginInfo = (Users) session.getAttribute("LoginInfo");
		if (loginInfo != null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getDisplay_name());
			bills.setUser(loginInfo.getUser());
		}
		mvShare.addObject("bills", bills);
		return mvShare;
	}
	// thanh toán đơn hàng 
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String CheckoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bill)
	{
		bill = ConvertCharsets(bill);
		bill.setQuanty((Integer) session.getAttribute("TotalQuantyCart"));
		bill.setTotal((Double) session.getAttribute("TotalPriceCart"));
		if (billService.AddBill(bill) > 0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>) session.getAttribute("Cart");
			billService.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}
	
	
	
	Bills ConvertCharsets(Bills bill) {
		// phan ten
		byte[] bytes = bill.getNote().getBytes(StandardCharsets.ISO_8859_1);
		bill.setNote(new String(bytes, StandardCharsets.UTF_8));
		
		bytes = bill.getDisplay_name().getBytes(StandardCharsets.ISO_8859_1);
		bill.setDisplay_name(new String(bytes, StandardCharsets.UTF_8));
		
		bytes = bill.getAddress().getBytes(StandardCharsets.ISO_8859_1);
		bill.setAddress(new String(bytes, StandardCharsets.UTF_8));
		// phan title
		return bill;
	}
}
