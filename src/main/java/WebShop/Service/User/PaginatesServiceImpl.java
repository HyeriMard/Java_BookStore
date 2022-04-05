package WebShop.Service.User;

import org.springframework.stereotype.Service;

import WebShop.Dto.Paginates;

@Service
public class PaginatesServiceImpl {
	
	public Paginates GetInfoPaginate(int totalData, int limit, int currentPage) {
		Paginates paginate = new Paginates();
		paginate.setLimit(limit);
		paginate.setTotalPage(SetInfoTotalPage(totalData, limit));
		paginate.setCurrentPage(checkCurrentPage(currentPage, paginate.getTotalPage()));
		int start = FindStart(paginate.getCurrentPage(), limit);
		paginate.setStart(start);
		int end = FindEnd(paginate.getStart(), limit, totalData);
		paginate.setEnd(end);
		return paginate;
	}
	// vị trí sản pẩm cuối cùng
	private int FindEnd(int start, int limit, int totalData) {
		return start + limit > totalData ? totalData : (start + limit) - 1;
	}
	// vị trí sản pẩm đầu tiên
	private int FindStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit) + 1;
	}
	// thông tin tổng số trang
	private int SetInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit; // tổng số dữ liệu / tổng số sản phẩm muốn lấy
		// vd:20/9 = 2 và dư mất 2 sản phẩm (nếu 2*9 < 20 thì tổng trang + 1 để chứa các sản phẩm còn lại nếu chia hết thì trả về số trang )
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage; 
		return totalPage;
	}

	public int checkCurrentPage(int currentPage, int totalPage) {
		// nếu trang hiện tại đang là 0 thì đẩy về trang 1
		if (currentPage < 1) {
			return 1;
		}
		// nếu trang hiện tại là 10 mà tổng trang có 5 thì đẩy nó về trang cuối của tổng số trang là 5
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
