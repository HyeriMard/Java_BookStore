package WebShop.Controller.Admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import WebShop.Service.User.BillDetailServiceImpl;
import WebShop.Service.User.BillServiceImpl;


@Controller
public class BillAdminController extends BaseAdminController {

	@Autowired
	BillDetailServiceImpl _BillDetailService;
	@Autowired
	BillServiceImpl _BillService;

	@RequestMapping(value = "/admin/don-hang")
	public ModelAndView Index() {

		if (isLogin()) {
			mvShare.clear();
			// lấy day sách
			mvShare.addObject("bills", _BillService.GetBills());
			mvShare.setViewName("admin/bills/bill");
		}
		return mvShare;
		
	}

	@RequestMapping(value = "/admin/chi-tiet-don/{id}", method = RequestMethod.GET)
	public ModelAndView Detail(@PathVariable long id) {
		
	
		
		if (isLogin()) {
			mvShare.clear();
			mvShare.addObject("bill", _BillService.GetBillByID(id).get(0));
			mvShare.addObject("detail",_BillDetailService.GetBillDetailByIDBill(id) );
		
			mvShare.setViewName("admin/bills/detailBill");
		}
		return mvShare;
	}
}
