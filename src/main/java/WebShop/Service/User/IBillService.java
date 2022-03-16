package WebShop.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Dto.CartDto;
import WebShop.Enity.Bills;


@Service
public interface IBillService {
	public int AddBill(Bills bills);
	public void AddBillsDetail(HashMap<Long, CartDto> carts);
	//-=-=-=-=admin-=-=-=-=
	public List<Bills> GetBills();
	public List<Bills> GetBillByID(long id);
	
}
