/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
public class Product {
    private String productCode;
    private String productName;
    private String productCategory;
    private String productWarranty;
    private double productPrice;
    private int productQuantity;
    private String productSupplier;
    
    public Product(String code, String name, String cat, 
            String warranty, double price, int quantity, String supplier){
        
        this.productCode = code;
        this.productName = name;
        this.productCategory = cat;
        this.productWarranty = warranty;
        this.productPrice = price;
        this.productQuantity = quantity;
        this.productSupplier = supplier;
    }
    
    public String getCode(){
        return productCode;
    }
    public String getName(){
        return productName;
    }
    public String getCategory(){
        return productCategory;
    }
    public String getWarranty(){
        return productWarranty;
    }
    public double getPrice(){
        return productPrice;
    }
    public int getQuantity(){
        return productQuantity;
    }
    public String getSupplier(){
        return productSupplier;
    }
    
    //For updatable attributes
    public void setWarranty(String warranty){
        productWarranty = warranty;
    }
    public void setPrice(double price){
        productPrice = price;
    }
    public void setQuantity(int quantity){
        productQuantity = quantity;
    }
}
