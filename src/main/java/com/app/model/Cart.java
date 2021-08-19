package com.app.model;

public class Cart {
	private int SerialNo;
	private int productId;
	private int CustomerId;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public int getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	@Override
	public String toString() {
		return "Cart [SerialNo=" + SerialNo + ", productId=" + productId + ", CustomerId=" + CustomerId + "]";
	}

}
