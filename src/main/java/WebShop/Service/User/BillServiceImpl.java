package WebShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.BillsDao;
import WebShop.Dto.CartDto;
import WebShop.Enity.Bills;
import WebShop.Enity.BillsDetail;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillsDao billsDao;

	@Override
	public int AddBill(Bills bill) {
		return billsDao.AddBills(bill);
	}

	@Override
	public void AddBillsDetail(HashMap<Long, CartDto> carts) {
		long idBills = billsDao.GetIDLastBills();
		for (Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillsDetail billsDetail = new BillsDetail();
			billsDetail.setId_bills(idBills);
			billsDetail.setId_product(itemCart.getValue().getProduct().getId());
			billsDetail.setQuanty(itemCart.getValue().getQuanty());
			billsDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billsDetail);
		}

	}

}
