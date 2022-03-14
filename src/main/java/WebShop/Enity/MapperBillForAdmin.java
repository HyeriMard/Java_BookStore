package WebShop.Enity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBillForAdmin implements RowMapper<BillsDetail> {
	@Override
	public BillsDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillsDetail bills = new BillsDetail();
		bills.setId(rs.getInt("id"));
				bills.setQuanty(rs.getInt("quanty"));
		bills.setTotal(rs.getDouble("total"));
		bills.setId_bills(rs.getInt("id_bills"));
		bills.setName_product(rs.getString("name"));
		return bills;
	}

}
