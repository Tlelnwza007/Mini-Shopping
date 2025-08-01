package Lib;
    /*
     * ADT ที่ไม่เปลี่ยนรูป (Immutable) สำหรับเก็บข้อมูลสินค้า
     * คลาสนี้เป็น final เพื่อป้องกันการสืบทอดและรับประกัน Immutabillty
     */
public final class Product {
    private final String productId ;
    private final String productName ;
    private final double price ;
    
    //Rep Invariant (RI) :
    // - productId and productName are Not null or blank.
    // - price >= 0.
    //
    // Abstraction function (AF) :
    // - AF(productId, productName, price) = A product with the given ID, Name, and price.

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    
     private void checkRep(){
        if (productId == null || productName.isBlank()) {
            throw new RuntimeException("RI violated: pass") ;
        }
        if (productName == null || productName.isBlank()){
            throw new RuntimeException("RI violated :") ;
        }
        if(price < 0){
            throw new RuntimeException("RI violated :") ;
        }
     }
    /**
     * สร้างอ๊อบเจกต์ product
     *@param productId  รหัสสินค้า ห้ามเป็นค่าว่าง
     *@param productName ชื่อสินค้า ห้ามเป็นค่าว่าง
     *@param price ราคา ต้องไม่ติดลบ
     */
    
     public Product(String productId, String productName, double price){
        this.productId = productId ;
        this.productName = productName ;
        this.price = price ;
        checkRep(); // ตรวจสอบความถูกตต้องทุกครั้งที่สร้าง
     }

     public String getProductId(){
        return productId ;
     }
     public String getProductName(){
        return productName ;
     }
     public double getPrice(){
        return price ;
     }

     /**
      * เปรียบเทียบ Product สองชิ้นโดยใช้ ProductId
      * @param obj อ๊อบเจกต์ที่ต้องการเปรียบเทียบ
      *@return true หาก productId เหมือนกัน
      */

    public boolean equals(Object obj){
        if(this == obj)
            return true ;
        if(obj == null || getClass() != obj.getClass())
            return false ;
        Product product = (Product) obj ;
        return productId.equals(product.productId) ;
    }
}
