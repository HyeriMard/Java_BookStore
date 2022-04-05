package WebShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import WebShop.Dto.Cart;

@Service
public interface ICartService {
	public HashMap<Long, Cart> AddCart(long id, HashMap<Long, Cart> cart);

	public HashMap<Long, Cart> EditCart(long id, int quanty, HashMap<Long, Cart> cart);

	public HashMap<Long, Cart> DeleteCart(long id, HashMap<Long, Cart> cart);

	public int TotalQuanty(HashMap<Long, Cart> cart);

	public double TotalPrice(HashMap<Long, Cart> cart);
}
