package WebShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebShop.Dao.CartDao;
import WebShop.Dto.Cart;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartDao cartDao = new CartDao();

	@Override
	public HashMap<Long, Cart> AddCart(long id, HashMap<Long, Cart> cart) {
		return cartDao.AddCart(id, cart);
	}

	@Override
	public HashMap<Long, Cart> EditCart(long id, int quanty, HashMap<Long, Cart> cart) {
		return cartDao.EditCart(id, quanty, cart);
	}

	@Override
	public HashMap<Long, Cart> DeleteCart(long id, HashMap<Long, Cart> cart) {
		return cartDao.DeleteCart(id, cart);
	}

	@Override
	public int TotalQuanty(HashMap<Long, Cart> cart) {
		return cartDao.TotalQuanty(cart);
	}

	@Override
	public double TotalPrice(HashMap<Long, Cart> cart) {
		return cartDao.TotalPrice(cart);
	}

}
