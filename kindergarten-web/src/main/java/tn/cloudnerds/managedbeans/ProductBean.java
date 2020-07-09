package tn.cloudnerds.managedbeans;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;

import tn.cloudnerds.entities.Cart;
import tn.cloudnerds.entities.CartLine;
import tn.cloudnerds.entities.PointsLoyalty;
import tn.cloudnerds.entities.Product;
import tn.cloudnerds.services.ProductService;

@ManagedBean
@SessionScoped
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	ProductService productService;
	


	List<Cart> listAllCartByParentId;
	List<Product> listAllProduct ;

	
	@PostConstruct
	public void init() {
		listAllCartByParentId = productService.GetAllCartByParentId(1);
		listAllProduct = productService.GetAllProduct();

	}
	
	public void initOrReloadIfNeeded(){
		System.out.println("test");
	}

	private String quantityChoosedFromView;

	public String getQuantityChoosedFromView() {
		return quantityChoosedFromView;
	}

	public void setQuantityChoosedFromView(String quantityChoosedFromView) {
		this.quantityChoosedFromView = quantityChoosedFromView;
	}

	

	public Product productFromView;

	public void setProductFromView(Product productFromView) {
		this.productFromView = productFromView;
	}

	

//	public void setQuantityChoosedFromView(int quantityChoosedFromView) {
//		this.quantityChoosedFromView = quantityChoosedFromView;
//	}

	

	

	public List<Product> GetlistAllProduct() {

	

		for (Product product : listAllProduct) {
			System.out.println(product.getName());
			// System.out.println(product.getImg());
		}
		String version = FacesContext.class.getPackage().getImplementationVersion();
		System.out.println(version);
		return listAllProduct;
	}
	
	
	public List<Cart> GetAllCartByParentId() {


//		for (CartLine cartLine : listAllParentCartLine) {
//			System.out.println(cartLine.getProduct().getName());
//			}

		return listAllCartByParentId;
	}

	public String ConfirmPurchase() {
		int parentId = 1;
		productService.ConfirmPurchase(parentId);
		return "ProductHome.jsf";
		
	}

	public void AddProductToCart() {
		productService.AddProductToCart(productFromView.id, Integer.parseInt(quantityChoosedFromView));

		showPopup = false;
		clear();
	}

	public List<Product> GetProductByCartLinesIds() {
		int parentId = 1;
		if(productService.GetNotYetPurchasedCartByParentId(parentId) == null) {
			return null ;
		}
		return productService.GetProductByCartLinesIds(parentId);
	}
	
	public Cart GetNotYetPurchasedCartByParentId() {
		int parentId = 1;
		Cart cart = productService.GetNotYetPurchasedCartByParentId(parentId);
		if(cart != null) {
			return cart ;
		}
		return null;
	}
	
	public PointsLoyalty GetPointsLoyalty() {
		int parentId = 1;
		return productService.GetPointsLoyalty(parentId);
	}
	
	
	public int theAmountYouHaveToPay() {
		int amount = (GetNotYetPurchasedCartByParentId().getCartTotalPrice() - GetPointsLoyalty().getPoints());
		if (amount < 0) {
			return 0 ;
		}
		return amount;
	}
	
	

	public void test1() {
		productService.UpdatePointsLoyalty(1, 50);
	}

	/** Start Popup add Product to cart functions **/

	private boolean showPopup;

	public Product show() {

		showPopup = true;
		return productFromView;

	}

	public void hide() {
		showPopup = false;
	}

	public boolean isShowPopup() {
		return showPopup;
	}

	public void setShowPopup(boolean showPopup) {
		this.showPopup = showPopup;
	}

	/** End Popup add Product to cart functions **/

	/** Start Popup my cart functions **/

	private boolean showPopup2;

	public void show2() {
		showPopup2 = true;
	}

	public void hide2() {
		showPopup2 = false;
	}

	public boolean isShowPopup2() {
		return showPopup2;
	}

	public void setShowPopup2(boolean showPopup2) {
		this.showPopup2 = showPopup2;
	}

	/** End Popup my cart functions **/

	public void clear() {
		setQuantityChoosedFromView(null);
	}
	
	/***************************************************************/
	

}
