package tn.cloudnerds.services;

import java.util.List;

import javax.ejb.Remote;

import tn.cloudnerds.entities.*;


@Remote
public interface IProductServiceRemote {
	
	List<Product> GetAllProduct();
    List<Cart> GetAllCartByParentId(int parentId);
    void AddProductToCart(int productId , int quantityChoosed);
    List<Product> GetProductByCartLinesIds(int parentId) ;
    void ConfirmPurchase(int parentId);
    PointsLoyalty GetPointsLoyalty(int parentIdWs);
    void ConfirmPurchaseUsingLoyaltyPoints(int parentId);
    void UpdatePointsLoyalty(int parentId, int points);

}
