package WebShop.Controller.Admin;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Controller.User.BaseController;
import WebShop.Dto.Categorys;
import WebShop.Dto.Product;
import WebShop.Service.User.CategoryServiceImpl;
import WebShop.Service.User.HomeServiceImpl;
@Controller
public class CategoryAdminController  extends BaseAdminController{
	@Autowired
	CategoryServiceImpl _categoryService;
	
	
	@RequestMapping(value = "/admin/the-loai")
	public ModelAndView Index() {
		
		
		if (isLogin()) {
			mvShare.clear();
			// lấy danh sách thể loại
			mvShare.addObject("cates", _categoryService.GetDataCategorys());

			mvShare.setViewName("admin/categoris/category");
		}
		
	
		return mvShare;
	}
	
	
	@RequestMapping(value = "/admin/them-the-loai", method = RequestMethod.GET)
	public ModelAndView CreateCate() {
		
		
		
		if (isLogin()) {
			mvShare.clear();
			// lấy danh sách thể loại
			mvShare.setViewName("admin/categoris/createCategory");
			mvShare.addObject("newCate", new Categorys());
		}
	
		return mvShare;
	}
	
	
	
	@RequestMapping(value = "/admin/them-the-loai", method = RequestMethod.POST)
	public ModelAndView CreateCate(@ModelAttribute("newCate")Categorys newCate ) {
		// chuyen charset sang UTF-8
		Categorys cate = ConvertCharsets(newCate);
		if(cate.getName().equals("")||cate.getDescription().equals("")) {
			mvShare.addObject("status", "Vui lòng nhập đầy đủ thông tin");
			mvShare.setViewName("admin/products/createProduct");
		}
		else {
			try {
				// tạo category
				int count = _categoryService.CreateCategory(cate);
				// nếu trả về 1 -> tạo thành công
				if (count > 0) {
					// thành công
					mvShare.setViewName("redirect:the-loai");
					return mvShare;
				} else {
					// thất bại
					mvShare.addObject("status", count);
					mvShare.setViewName("admin/products/createCategory");
				}
			} catch (Exception e) {
				mvShare.addObject("status", "fail-begin");
				mvShare.setViewName("admin/products/createCategory");
			}
	}
		// lấy danh sách thể loại
		mvShare.setViewName("admin/categoris/createCategory");
		mvShare.addObject("newCate", new Categorys());
		return mvShare;
	}
	
	Categorys ConvertCharsets(Categorys cate) {
		// phan ten
		byte[] bytes = cate.getName().getBytes(StandardCharsets.ISO_8859_1);
		cate.setName(new String(bytes, StandardCharsets.UTF_8));
		// phan Detail
		bytes = cate.getDescription().getBytes(StandardCharsets.ISO_8859_1);
		cate.setDescription(new String(bytes, StandardCharsets.UTF_8));
		// phan title
		return cate;
	}
	
	
	// xóa thể loại
		@RequestMapping(value = "/admin/xoa-the-loai/{id}", method = RequestMethod.GET)
		public ModelAndView ComfirmCategory(@PathVariable long id) {
			
			if (isLogin()) {
				mvShare.clear();
				
				// lấy thể loại 
				mvShare.addObject("cate", _categoryService.GetCatetByID(id).get(0));

				mvShare.setViewName("admin/categoris/deleteCategory");
			}
		
			return mvShare;
		}
		
		
		@RequestMapping(value = "/admin/xoa-the-loai/{id}", method = RequestMethod.POST)
		public ModelAndView deleteCategory(@PathVariable long id) {
			// xóa
			int count = _categoryService.DeleteCate(id);
			// nếu trả về 1 -> thành công
			if (count > 0) {
				// thành công
				
				mvShare.setViewName("redirect:/admin/the-loai");
				return mvShare;
			} else {
				// thất bại
				mvShare.addObject("status", "Xóa thất bại");
				mvShare.addObject("cate", _categoryService.GetCatetByID(id).get(0));
				mvShare.setViewName("admin/categoris/deleteCategory");
			}

			return mvShare;
		}
	
		// sửa thể loại
		@RequestMapping(value = "/admin/sua-the-loai/{id}", method = RequestMethod.GET)
		public ModelAndView editCategory(@PathVariable long id) {
			
			
			if (isLogin()) {
				mvShare.clear();
				
				// lấy thể loại 
				mvShare.addObject("editCate", _categoryService.GetCatetByID(id).get(0));

				mvShare.setViewName("admin/categoris/editCategory");
			}
		
			return mvShare;
		}
		
		
		
		@RequestMapping(value = "/admin/sua-the-loai", method = RequestMethod.POST)
		public ModelAndView Edit(@ModelAttribute("editCate") Categorys editCate) {
			// chuyen charset sang UTF-8
			System.out.print("vao dc");
			Categorys cate = ConvertCharsets(editCate);
			
			cate.setId(editCate.getId());
			if (cate.getName().equals("") || cate.getDescription().equals("")) {
				mvShare.addObject("status", "Vui lòng nhập đầy đủ thông tin");
				mvShare.setViewName("admin/products/editProduct");
			} else {
				try {
					//Sửa 
					int count = _categoryService.EditCategory(cate);
					// nếu trả về 1 -> thành công
					if (count > 0) {
						// thành công
						mvShare.setViewName("redirect:/admin/the-loai");
						return mvShare;

					} else {
						// thất bại
						mvShare.addObject("status", "fail");
						// gán lại value để giữ giá trị cũa sản pham63
						mvShare.addObject("editCate", cate);
						mvShare.setViewName("admin/categoris/editCategory");
					}
				} catch (Exception e) {
					// thất bại
					mvShare.addObject("status", "fail");
					// gán lại value để giữ giá trị cũa sản pham63
					mvShare.addObject("editCate", cate);
					mvShare.setViewName("admin/categoris/editCategory");
				}
			}
			return mvShare;
		}
			
	
}
