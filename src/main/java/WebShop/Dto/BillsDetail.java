package WebShop.Dto;

public class BillsDetail {
	private long id;
	private long id_product;
	private int quanty;
	private double total;
	private long id_bills;
	private String name_product;
	public BillsDetail() {
		super();
	}

	public BillsDetail(long id, long id_product, long id_bills, int quanty) {
		super();
		this.id = id;
		this.id_product = id_product;
		this.id_bills = id_bills;
		this.quanty = quanty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public long getId_bills() {
		return id_bills;
	}

	public void setId_bills(long id_bills) {
		this.id_bills = id_bills;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	

}
