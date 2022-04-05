package WebShop.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.Bills;
import WebShop.Dto.Cart;


@Service
public interface IBillService {
	public int AddBill(Bills bills);
	public void AddBillsDetail(HashMap<Long, Cart> carts);
	//-=-=-=-=admin-=-=-=-=
	public List<Bills> GetBills();
	public List<Bills> GetBillByID(long id);
	
}
