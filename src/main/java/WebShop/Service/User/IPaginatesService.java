package WebShop.Service.User;

import org.springframework.stereotype.Service;

import WebShop.Dto.Paginates;

@Service
public interface IPaginatesService {
	public Paginates GetInfoPaginates(int totalData,int limit,int currentPage);
}
