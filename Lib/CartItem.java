package Lib;
/**
 *  ADT ที่เปลี่ยนแปลงได้ (Mutable) สำหรับเก็บข้อมูลสินค้า 1 รายการในตระกร้า
 */
public class CartItem {
    private final Product product ;
    private int quantity ;

    // Rep
    // - product is not null.
    // - quantity > 0.
    //
    // Adstraction Function (AF) :
    // - AF(product, quantity) = An item in a shopping cart for the given 'product' with the specified 'quantity'

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */

     private void checkRep(){
        if(product == null){
            throw new RuntimeException("RI violated : product is null") ;
        }
        if(quantity <= 0){
            throw new RuntimeException("RI violated : quantity is less than 1") ;
        }
     }

     /**
      * สร้างรายการสินค้าในตระกร้า
      *@param product อ๊อบเจกต์สินค้า
      *@param quantity จำนวนสินค้า ต้องมากกว่า 0
      */

      public CartItem(Product product, int quantity){
        this.product = product ;
        this.quantity = quantity ;
        checkRep();
      }

      /**
       * @return อ๊อบเจต์ Product
       */

       public Product getProduct(){
        return product ;
       }
       public int getquantity(){
        return quantity ;
       }

       /**
        * เพิ่มจำนวนสินค้าในรายการนี้
        *@param amount จำนวนที่ต้องการเพิ่ม (ต้องการเป็นค่าบวก)
        */

        public void increasesQuantity(int amount){
            if(amount > 0) {
                this.quantity += amount ;
            }
            checkRep();// ตรวจสอบหลังการเปลี่ยนแปลงสถานะ
        }
}
