package Lib.Discount;
import Lib.CartItem;
/**
 * กลยุทธ์ส่วนลด Bogo (ซื้อ 1 แถม 1)
 */
public class BogoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(CartItem item) {
        int quantity = item.getquantity() ; //ค้นหาจำนวนสินค้า
        double price = item.getProduct().getPrice() ; // ค้นหาราคาสินค้า
        int quantityTopay = (quantity / 2) + (quantity % 2) ; //จน.สินค้าหาร 2  + มอดเอาเศษจากการหาร
        return price * quantityTopay ; // ราคาสินค้า * จน.สินค้าที่คำนวณได้
    }
   
    
}
