package WebShop.Controller.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import WebShop.Controller.User.BaseController;
import WebShop.Dto.ProductDto;
import WebShop.Enity.BillsDetail;
import WebShop.Service.User.HomeServiceImpl;

@Controller
public class BillAdminController extends BaseController {
	@Autowired
	HomeServiceImpl _homeService;

	@RequestMapping(value = "/admin/don-hang")
	public ModelAndView Index() {

		mvShare.addObject("bills", _homeService.GetBills());
		mvShare.setViewName("admin/bills/bill");
		return mvShare;
	}

	@RequestMapping(value = "/admin/chi-tiet-don/{id}", method = RequestMethod.GET)
	public ModelAndView Detail(@PathVariable long id) {
		
		mvShare.addObject("bill", _homeService.GetBillByID(id).get(0));
		
		List<BillsDetail> detail= _homeService.GetBillDetailByIDBill(id);
		List<ProductDto> pros= _homeService.GetDataProducts();
	
		   Map<Long, String> names = new HashMap<Long, String>();
		for (BillsDetail billsDetail : detail) {
			for (ProductDto pro : pros) {
				if(billsDetail.getId_product()==pro.getId()) {
					names.put(pro.getId(), pro.getName());
				}
			}
		}
		mvShare.addObject("detail",detail );
		
		mvShare.addObject("pro",  _homeService.GetDataProducts());
		mvShare.setViewName("admin/bills/detailBill");
		
		return mvShare;
	}
}
