package Lib;
import java.util.ArrayList;
/**
 * ADT
 */   
public class ShoppingCart{
    private final PricingService pricingService ;
    private final ProductCatalog productCatalog ;
    private ArrayList<CartItem> items ; 
    // RI : ArrayList ภายในต้องไม่เป็น nall และห้ามมี Product ที่ซ้ำกันใน Carltem ที่แตกต่างกัน
    private void checkRep(){
        if(items == null){
            throw new RuntimeException("RI violated : item is null ") ;
        }
        // check for duplicate products
        for (int i = 0; i < items.size(); i++) {
            for (int j = i+1; j < items.size(); j++) {
                if(items.get(i).equals(items.get(j))){
                    throw new RuntimeException("RI violated : duplicate product ") ;
                }
            }
        }
    }
    public ShoppingCart(PricingService pricingService, ProductCatalog productCatalog){
        this.items = new ArrayList<>() ;
        this.pricingService = pricingService ;
        this.productCatalog = productCatalog ; 
        checkRep();
    }
    public void addItem(String productId, int quantity){
        Product product = productCatalog.findById(productId) ;
        if(product == null){
            return ;
        }
        for (CartItem Item : items) {
            if(Item.getProduct().equals(product)){
                Item.increasesQuantity(quantity);
                checkRep();
                return ;
            }
        }
        items.add(new CartItem(product, quantity)) ;
        checkRep();
    }   
     public void removeItem(String ProductId){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getProduct().getProductId().equals(ProductId)){
                items.remove(i);
                checkRep();
                break ;    
            }
        }
     }
     public double getTotalPrice(){
        double totol = 0 ;
        for (CartItem cartItem : items) {
            totol += pricingService.calculateItemPrice(cartItem) ;
        }
        return totol ;
     }

     public int  getItemCount(){
        return items.size() ;
     }

     public void clearCart(){
        items.clear();
        checkRep();
     }
}
