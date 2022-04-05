package WebShop.Enity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WebShop.Dto.BillsDetail;

public class MapperBillsDetail implements RowMapper<BillsDetail>{
	@Override
	public BillsDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillsDetail bills = new BillsDetail();
		bills.setId(rs.getInt("id"));
		bills.setId_product(rs.getInt("id_product"));
		bills.setQuanty(rs.getInt("quanty"));
		bills.setTotal(rs.getDouble("total"));
		bills.setId_bills(rs.getInt("id_bills"));
		return bills;
	}
}
