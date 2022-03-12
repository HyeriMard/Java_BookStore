package WebShop.Dao;

import org.springframework.stereotype.Repository;

import WebShop.Enity.Bills;
import WebShop.Enity.BillsDetail;

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
}
