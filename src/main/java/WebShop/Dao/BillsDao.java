package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Enity.Bills;
import WebShop.Enity.BillsDetail;
import WebShop.Enity.Categorys;
import WebShop.Enity.MapperBillForAdmin;
import WebShop.Enity.MapperBills;
import WebShop.Enity.MapperBillsDetail;
import WebShop.Enity.MapperCategorys;

@Repository
public class BillsDao extends BaseDao {
	public int AddBills(Bills bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `bills` ");
		sql.append("( `user`, `phone`, `display_name`, `address`, `total`, `quanty`, `note`) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '" + bill.getUser() + "', ");
		sql.append("    '" + bill.getPhone() + "', ");
		sql.append("    '" + bill.getDisplay_name() + "', ");
		sql.append("    '" + bill.getAddress() + "', ");
		sql.append("    '" + bill.getTotal() + "', ");
		sql.append("    '" + bill.getQuanty() + "', ");
		sql.append("    '" + bill.getNote() + "' ");
		sql.append(")");
		int insert = jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long GetIDLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills;");
		long id = jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}

	public int AddBillsDetail(BillsDetail billsDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `billdetail` ");
		sql.append("(`id_product`, `quanty`, `total`, `id_bills`) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '" + billsDetail.getId_product() + "', ");
		sql.append("    '" + billsDetail.getQuanty() + "', ");
		sql.append("    '" + billsDetail.getTotal() + "', ");
		sql.append("    '" + billsDetail.getId_bills() + "' ");
		sql.append(")");
		int insert = jdbcTemplate.update(sql.toString());
		return insert;
	}
	//-=-==--=-=-=-=-Phần admin-=-=-=-=-=-=
	public List<Bills> GetBills() {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "SELECT * FROM `bills`" ;
		list = jdbcTemplate.query(sql, new MapperBills());
		return list;
	}
	public List<Bills> GetBillByID(long id) {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "SELECT * FROM `bills` where id=" +id;
		list = jdbcTemplate.query(sql, new MapperBills());
		return list;
	}
	public List<BillsDetail> GetBillDetailByIDBill(long id) {
		List<BillsDetail> list = new ArrayList<BillsDetail>();
		String sql = "SELECT b.id,b.quanty,b.total,b.id_bills, p.name FROM billdetail b,"
				+ " products p WHERE p.id=b.id_product and b.id_bills=" +id;
		list = jdbcTemplate.query(sql, new MapperBillForAdmin());
		return list;
	}
}
