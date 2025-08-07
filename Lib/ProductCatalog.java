package Lib;
/**
 * คลาสทำหน้าที่เป็นแคตตาล็อคสินค้า (Repository)
 */

import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();

    // RI product list is not null contains on null elements, and no duplicate products.
    // AF : AF(products) = A catalog of null availble products.

    private void checkRep(){
        if(products == null){
            throw new RuntimeException("RI violated : produst is null") ;
        }
        // check for duplicate products
        for (int i = 0; i < products.size(); i++) {
            for (int j = i+1; j < products.size(); j++) {
                if(products.get(i).equals(products.get(j))){
                    throw new RuntimeException("RI violated : duplicate product") ;
                }
            }
        }
    }

    public ProductCatalog(){
        checkRep();
    }

    /**
     * เพิ่มสินค้าใหม่เข้าสู่แคตตาล็อก
     * @param product สินค้าที่ต้องการเพิ่ม
     */
    public void addProduct(Product product){
        if(product != null && !products.contains(product)){
            products.add(product) ;
        }
        checkRep();
    }

    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param productId รหัสสินค้าที่ต้องการค้นหา
     * @return อ๊อบเจกต์ Product หากพบ, หรือ null หากไม่พบ
     */

     public Product findById(String productId){
        for(Product p : products){
            if(p.getProductId().equals(productId)){
                return p ;
            }
        }
        return null ;
     }
}
