package WebShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import WebShop.Enity.BillsDetail;

@Service
public interface IBillDetailService {
	public List<BillsDetail> GetBillDetailByIDBill(long id);
}
