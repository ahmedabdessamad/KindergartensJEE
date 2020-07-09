package tn.cloudnerds.services;

import java.util.List;

import javax.ejb.Local;

import tn.cloudnerds.entities.*;


@Local
public interface IProductServiceLocal {
	
	List<Product> GetAllProduct();
	List<Cart> GetAllCartByParentId(int parentId) ;
    void AddProductToCart(int productId , int quantityChoosed);
    List<Product> GetProductByCartLinesIds(int parentId) ;
    void ConfirmPurchase(int parentId);
    PointsLoyalty GetPointsLoyalty(int parentIdWs);
    void ConfirmPurchaseUsingLoyaltyPoints(int parentId);
    void UpdatePointsLoyalty(int parentId, int points);
}
