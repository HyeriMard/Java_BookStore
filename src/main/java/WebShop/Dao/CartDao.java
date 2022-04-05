package WebShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import WebShop.Dto.Cart;
import WebShop.Dto.Product;

@Repository
public class CartDao extends BaseDao {

	@Autowired
	ProductsDao productsDao = new ProductsDao();

	public HashMap<Long, Cart> AddCart(long id, HashMap<Long, Cart> cart) {
		Cart itemCart = new Cart();
		Product product = productsDao.FindProductsByID(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty() + 1);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, Cart> EditCart(long id, int quanty, HashMap<Long, Cart> cart) {
		if (cart == null) {
			return cart;
		}
		Cart itemCart = new Cart();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			double totalPrice = quanty * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, Cart> DeleteCart(long id, HashMap<Long, Cart> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuanty(HashMap<Long, Cart> cart) {
		int totalQuanty = 0;
		for (Map.Entry<Long, Cart> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<Long, Cart> cart) {
		double totalPrice = 0;
		for (Map.Entry<Long, Cart> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
