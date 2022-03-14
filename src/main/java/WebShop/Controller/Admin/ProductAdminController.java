package WebShop.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Locale.Category;

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

@Controller
public class ProductAdminController extends BaseController {
	@Autowired
	HomeServiceImpl _homeService;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/admin/san-pham")
	public ModelAndView Index() {
		// lấy day sách
		mvShare.addObject("highlight", _homeService.GetProducts());
		// lấy danh sách thể loại
		mvShare.addObject("cates", _homeService.GetDataCategorys());

		mvShare.setViewName("admin/products/product");
		return mvShare;
	}

	// Them san pham
	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.GET)
	public ModelAndView Create(ModelMap model) {
		mvShare.setViewName("admin/products/createProduct");
		// add Attribute
		model.addAttribute("newPro", new ProductDto());
		// lấy danh sách cate
		mvShare.addObject("cates", _homeService.GetDataCategorys());

		return mvShare;
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.POST)
	public ModelAndView Create(@ModelAttribute("newPro") ProductDto newPro,
			@RequestParam(value = "img", required = false) MultipartFile photo) {

		// chuyen charset sang UTF-8
		ProductDto pro = ConvertCharsets(newPro);

		System.out.print(pro.getName());
		System.out.print("Chuyện Con Mèo Dạy Hải Âu Bay ");
		// kiem tra xem đủ thông tin chưa
		if (photo.isEmpty() || pro.getDetail().equals("") || pro.getName().equals("") || pro.getTitle().equals("")
				|| pro.getPrice() == 0.0) {
			mvShare.addObject("status", "Vui lòng nhập đầy đủ thông tin");
			mvShare.setViewName("admin/products/createProduct");
		} else {
			try {
				// lấy tên hình-> lưu xuông data
				String name = photo.getOriginalFilename();
				// lấy path
				String fath = context.getRealPath("/assets/user/img/products/" + name);
				// copy hình
				photo.transferTo(Path.of(fath));
				// set value cho thuộc tính hình của san phẩm
				pro.setPicture(name);
				// tạo product
				int count = _homeService.CreateProduct(pro);
				// nếu trả về 1 -> tạo thành công
				if (count > 0) {
					// thành công
					mvShare.setViewName("redirect:san-pham");
					return mvShare;
				} else {
					// thất bại
					mvShare.addObject("status", "fail");
					mvShare.setViewName("admin/products/createProduct");
				}
			} catch (Exception e) {
				mvShare.addObject("status", "fail");
				mvShare.setViewName("admin/products/createProduct");
			}
		}
		mvShare.addObject("cates", _homeService.GetDataCategorys());
		return mvShare;

	}

	// xóa
	@RequestMapping(value = "/admin/comfirm-xoa-san-pham/{id}", method = RequestMethod.GET)
	public ModelAndView ComfirmDelete(@PathVariable long id) {
		// lấy ra pro dc chọn
		ProductDto pro = _homeService.GetProductByID(id).get(0);

		mvShare.addObject("product", pro);
		// lấy thể loại thằng dc chọn
		mvShare.addObject("cate", _homeService.GetCatetByID(pro.getCateID()).get(0));

		mvShare.setViewName("admin/products/deleteProduct");
		return mvShare;
	}

	@RequestMapping(value = "/admin/xoa-san-pham/{id}", method = RequestMethod.POST)
	public ModelAndView Delete(@PathVariable long id) {
		// xóa
		int count = _homeService.DeleteProduct(id);
		// nếu trả về 1 -> thành công
		if (count > 0) {
			// thành công
			mvShare.addObject("status", "");
			mvShare.setViewName("redirect:/admin/san-pham");
			return mvShare;
		} else {
			// thất bại
			mvShare.addObject("status", "Xóa thất bại");
			mvShare.addObject("product", _homeService.GetProductByID(id).get(0));
			mvShare.setViewName("admin/products/deleteProduct");
		}

		return mvShare;
	}

	// sửa
	@RequestMapping(value = "/admin/sua-san-pham/{id}", method = RequestMethod.GET)
	public ModelAndView Edit(@PathVariable long id) {
		// lấy ra pro dc chọn
		ProductDto pro = _homeService.GetProductByID(id).get(0);
		mvShare.addObject("editPro", pro);

		mvShare.addObject("status", "");
		// lấy ra cate của pro dc chọn
		mvShare.addObject("cates", _homeService.GetDataCategorys());

		mvShare.setViewName("admin/products/editProduct");
		return mvShare;
	}

	@RequestMapping(value = "/admin/upload-san-pham/{id}", method = RequestMethod.POST)
	public ModelAndView Edit(@PathVariable long id, @ModelAttribute("editPro") ProductDto editPro,
			@RequestParam(value = "img", required = false) MultipartFile photo) {
		// chuyen charset sang UTF-8
		ProductDto pro = ConvertCharsets(editPro);
		// gán id cho pro này
		pro.setId(id);
		//lấy id để tìm pro trong database
		ProductDto pro_temp = _homeService.GetProductByID(id).get(0);
		//set img cũ tạm
		pro.setPicture(pro_temp.getPicture());

		// kiem tra xem chon hình ko neu ko ko sua hình
		if (!photo.isEmpty()) {
			String name = photo.getOriginalFilename();
			String fath = context.getRealPath("/assets/user/img/products/" + name);

			try {
				photo.transferTo(Path.of(fath));
			} catch (Exception e) {
				System.out.println(e);
			}
			//set hình mới
			pro.setPicture(name);
		}
		//check valid
		if (pro.getDetail().equals("") || pro.getName().equals("") || pro.getTitle().equals("")
				|| pro.getPrice() == 0.0) {
			mvShare.addObject("status", "Vui lòng nhập đầy đủ thông tin");
			mvShare.setViewName("admin/products/editProduct");
		} else {
			try {
				//Sửa 
				int count = _homeService.EditProduct(pro);
				// nếu trả về 1 -> thành công
				if (count > 0) {
					// thành công
					mvShare.setViewName("redirect:/admin/san-pham");
					return mvShare;

				} else {
					// thất bại
					mvShare.addObject("status", "fail");
					// gán lại value để giữ giá trị cũa sản pham63
					mvShare.addObject("editPro", pro);
					mvShare.setViewName("admin/products/editProduct/");
				}
			} catch (Exception e) {
				// thất bại
				mvShare.addObject("status", "fail");
				// gán lại value để giữ giá trị cũa sản pham63
				mvShare.addObject("editPro", pro);
				mvShare.setViewName("admin/products/editProduct");
			}
		}
		//gán danh sách thể loại 
		mvShare.addObject("cates", _homeService.GetDataCategorys());
		return mvShare;
	}

	ProductDto ConvertCharsets(ProductDto pro) {
		// phan ten
		byte[] bytes = pro.getName().getBytes(StandardCharsets.ISO_8859_1);
		pro.setName(new String(bytes, StandardCharsets.UTF_8));
		// phan Detail
		bytes = pro.getDetail().getBytes(StandardCharsets.ISO_8859_1);
		pro.setDetail(new String(bytes, StandardCharsets.UTF_8));
		// phan title
		bytes = pro.getTitle().getBytes(StandardCharsets.ISO_8859_1);
		pro.setTitle(new String(bytes, StandardCharsets.UTF_8));

		return pro;
	}

}
