package tn.cloudnerds.entities;

import java.io.Serializable;

public class CartLine implements Serializable {
	private static final long serialVersionUID = 1L;
	int cartLineId;
	int cartId ;
	int quantityChoosed ;
	Product product ;
	
	public CartLine() {
	}

	
	
	
	public CartLine(int cartLineId, int cartId, int quantityChoosed, Product product) {
		this.cartLineId = cartLineId;
		this.cartId = cartId;
		this.quantityChoosed = quantityChoosed;
		this.product = product;
	}




	public int getQuantityChoosed() {
		return quantityChoosed;
	}




	public void setQuantityChoosed(int quantityChoosed) {
		this.quantityChoosed = quantityChoosed;
	}




	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCartLineId() {
		return cartLineId;
	}

	public void setCartLineId(int cartLineId) {
		this.cartLineId = cartLineId;
	}

}
