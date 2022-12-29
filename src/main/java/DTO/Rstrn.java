package DTO;

public class Rstrn {
	private int order_number;
	private String cust_name;
	private String food_name;
	private int pay;
	private String order_addr;
	private String pay_t;
	
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getPay_t() {
		return pay_t;
	}
	public void setPay_t(String pay_t) {
		this.pay_t = pay_t;
	}
	
	
}
