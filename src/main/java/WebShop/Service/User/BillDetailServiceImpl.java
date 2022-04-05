package WebShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.BillsDao;
import WebShop.Dto.BillsDetail;
@Service
public class BillDetailServiceImpl implements IBillDetailService{
	
	@Autowired
	private BillsDao billDao;
	@Override
	public List<BillsDetail> GetBillDetailByIDBill(long id) {
		return 	billDao.GetBillDetailByIDBill(id);
	}
}
