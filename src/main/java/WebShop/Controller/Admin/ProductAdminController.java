package WebShop.Controller.Admin;




import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import WebShop.Controller.User.BaseController;

import WebShop.Dto.ProductDto;

import WebShop.Service.User.HomeServiceImpl;
import WebShop.Service.User.ProductServiceImpl;



@Controller
public class ProductAdminController extends BaseController{
	@Autowired
	HomeServiceImpl _homeService;
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping(value = "/admin/san-pham")
	public ModelAndView Index() {
		mvShare.addObject("highlight", _homeService.GetProducts());
		mvShare.setViewName("admin/products/product");
		return mvShare;
	}
	//Them san pham

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.GET)
	public ModelAndView Create(ModelMap model) {
	
		mvShare.setViewName("admin/products/createProduct");
		ProductDto a = new ProductDto();
	
		model.addAttribute("newPro",a);
		mvShare.addObject("cates",_homeService.GetDataCategorys() );
	
		return mvShare;
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.POST)
	public ModelAndView Create(@ModelAttribute("newPro") ProductDto newPro,
			@RequestParam(value="img", required = false) MultipartFile photo ) {
		
		mvShare.addObject("cates",_homeService.GetDataCategorys() );
		//kiem tra xem chon hình chưa
		if(photo.isEmpty()||newPro.getDetail().equals("")||newPro.getName().equals("")
				||newPro.getTitle().equals("")||newPro.getPrice()==0.0) {
			mvShare.addObject("status", "Vui lòng nhập đầy đủ thông tin");
			mvShare.setViewName("admin/products/createProduct");
		}
		else {
			try {
				
				String name = photo.getOriginalFilename();
				String fath = context.getRealPath("/assets/user/img/products/"+name);
			
				photo.transferTo(Path.of(fath));
				
				newPro.setPicture(name);
				int count= _homeService.CreateProduct(newPro);
				if(count > 0) {
					//thành công
					mvShare.setViewName("redirect:san-pham");
				}else {
					//thất bại
					mvShare.addObject("status", "fail");
					mvShare.setViewName("admin/products/createProduct");
				}
			}
			catch (Exception e) {
				System.out.println(e);
				
				mvShare.addObject("status", "fail");
				mvShare.setViewName("admin/products/createProduct");
			}
		}
	
			return mvShare;
		
	}
	//xóa
	@RequestMapping(value = "/admin/comfirm-xoa-san-pham/{id}", method = RequestMethod.GET)
	public ModelAndView ComfirmDelete(@PathVariable long id) {
	
		mvShare.addObject("product", _homeService.GetProductByID(id).get(0));
		
		mvShare.addObject("cates",_homeService.GetDataCategorys() );
		mvShare.setViewName("admin/products/deleteProduct");
		return mvShare;
	}

	@RequestMapping(value = "/admin/xoa-san-pham/{id}", method = RequestMethod.POST	)
	public ModelAndView Delete(@PathVariable long id) {
		System.out.print("id="+id);
		int count= _homeService.DeleteProduct(id);
		System.out.print(count);
		if(count > 0) {
			//thành công
			mvShare.setViewName("redirect:/admin/san-pham");
		}else {
			//thất bại
			mvShare.addObject("status", "Xóa thất bại");
			mvShare.addObject("product", _homeService.GetProductByID(id).get(0));
			mvShare.setViewName("admin/products/deleteProduct");
		}
		
		return mvShare;
	}
	

}
