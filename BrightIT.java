/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author Kolobe Selepe
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class BrightIT {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Product> productsInventory = new ArrayList<>();
    
    public static void main(String[] args) {
        String proceed;
        System.out.println("Bright Future technologies");
        System.out.println("Enter (1) to launch menu or any key to exit: ");
        proceed = input.nextLine();
        
        if(proceed.equals("1")){
            String choice;
            do{
                displayMenu();
                choice = input.nextLine();
                selectedChoice(choice);
            }while(!choice.equals("6"));
        }else{
            System.out.println("Thank you for using our app...");
        }
        
    }
    
    public static void displayMenu(){
        System.out.println("Main Menu");
        System.out.println("1. Capture Product");
        System.out.println("2. Search Product");
        System.out.println("3. Update product");
        System.out.println("4. Delete a Product");
        System.out.println("5. Print Report");
        System.out.println("6. Exit Application");
        System.out.print("Select an Option: ");
    }
    
    public static void selectedChoice(String choice){
        switch(choice){
            case "1":
                System.out.println("\n" + "Capture the product" + "\n");
                captureProduct();
                break;
            case "2":
                System.out.println("\n" + "Search the product" + "\n");
                searchProduct();
                break;    
            case "3":
                System.out.println("\n"+"Update the product" + "\n");
                updateProduct();
                break;    
            case "4":
                System.out.println("\n" + "Delete the product" + "\n");
                deleteProduct();
                break;
            case "5":
                System.out.println("\n"+"Products Report" + "\n");
                printReport();
                break;
            case "6":
                System.out.println("Exiting Application.....");
                break;
            default:
                System.out.println("Please make a valid selection, '" + choice +
                         "' is an invalid option!!");
        }
    }
    
    public static void captureProduct(){
        System.out.print("Enter the product code: ");
        String code = input.nextLine();
        
        System.out.println("Enter the product name: ");
        String name = input.nextLine();
        
        String category;
        do{
            System.out.println("\n" + "CATEGORY");
            System.out.println("1. Computer Desktop");
            System.out.println("2. Laptop");
            System.out.println("3. Tablet");
            System.out.println("4. Printer");
            System.out.println("5. Gaming Console");
            System.out.print("Select the product category: ");
            category = input.next();
            
            if(category.equals("1")){
                category = "Computer Desktop";
            }else if(category.equals("2")){
                category = "Laptop";
            }else if(category.equals("3")){
                category = "Tablet";
            }else if(category.equals("4")){
                category = "Printer";
            }else if(category.equals("5")){
                category = "Gaming Console";
            }else{
                System.out.println("Please select valid choice!!");
            }
            
        }while(!category.equals("Computer Desktop") && 
                !category.equals("Laptop") && 
                !category.equals("Tablet") && 
                !category.equals("Printer") && 
                !category.equals("Gaming Console"));
        
        input.nextLine();
        String warranty;
        do{
            System.out.println("\n" + "Indicate the product warranty.");
            System.out.println("Enter (1) for 6 months or any key for 2 years: ");
            warranty = input.nextLine();
            
            if(warranty.equals("1")){
                warranty = "6 months";
            }else{
                warranty = "2 years";
            }
        }while(!warranty.equals("6 months") && 
               !warranty.equals("2 years"));
        
        System.out.print("\n" + "Enter the price for " + name + ": ");
        double price = input.nextDouble();
        
        System.out.print("\n" + "Enter the stock level for " + name + ": ");
        int level = input.nextInt();
        
        input.nextLine();
        System.out.print("\n" + "Enter the supplier for " + name + ": ");
        String supplier = input.nextLine();
        
        Product product = new Product(code, name, category,
                                        warranty, price, level, supplier);
        
        productsInventory.add(product);
    }
    
    public static void searchProduct(){
        System.out.print("Please enter the product code to search: ");
        String code = input.nextLine();
        boolean found = false;
        for(Product p: productsInventory){
            if(code.equals(p.getCode())){
                found = true;
                System.out.println("PRODUCT CODE: " + p.getCode());
                System.out.println("PRODUCT NAME: " + p.getName());
                System.out.println("PRODUCT CATEGORY: " + p.getCategory());
                System.out.println("PRODUCT WARRANTY: " + p.getWarranty());
                System.out.println("PRODUCT PRICE: R " + p.getPrice());
                System.out.println("PRODUCT STOCK LEVEL: " + p.getQuantity());
                System.out.println("PRODUCT SUPPLIER: " + p.getSupplier());
            }
        }
        if(!found){
            System.out.println("\n" + "PRODUCT CODE: " + code + " is not found!!");
        }
    }
    
    public static void updateProduct(){
        System.out.print("Please enter the product code to update: ");
        String code = input.nextLine();
        boolean found = false;
        for(Product p: productsInventory){
            if(code.equals(p.getCode())){
                System.out.print("\n");
                System.out.println("PRODUCT CODE: " + p.getCode());
                System.out.println("PRODUCT NAME: " + p.getName());
                System.out.println("PRODUCT CATEGORY: " + p.getCategory());
                System.out.println("PRODUCT WARRANTY: " + p.getWarranty());
                System.out.println("PRODUCT PRICE: R " + p.getPrice());
                System.out.println("PRODUCT STOCK LEVEL: " + p.getQuantity());
                System.out.println("PRODUCT SUPPLIER: " + p.getSupplier());
                System.out.print("\n");
                
                String confirm;
                do{
                    System.out.println("Update the warranty? (y) yes, (n) no: ");
                    confirm = input.nextLine();
                    if(confirm.equals("y")){
                        if(p.getWarranty().equals("6 months")){
                            p.setWarranty("2 years");
                            System.out.print("Warranty is changed to: " + p.getWarranty());
                        }else{
                            p.setWarranty("6 months");
                            System.out.print("Warranty is changed to: " + p.getWarranty());
                        }    
                    }else if(confirm.equals("n")){
                        System.out.print("Warranty Still: " + p.getWarranty());
                    }else{
                        System.out.print("Please enter yes or no.");
                    }
                }while(!confirm.equals("y") && !confirm.equals("n"));
                
                do{
                    System.out.println("Update the product price? (y) yes, (n) no: ");
                    confirm = input.nextLine();
                    if(confirm.equals("y")){
                        System.out.print("Enter the new price for " + p.getName() + ": ");
                        double newPrice = input.nextDouble();
                        input.nextLine();
                        p.setPrice(newPrice);
                    }else if(confirm.equals("n")){
                        System.out.print("Product price still: " + p.getPrice());
                    }else{
                        System.out.print("Please enter yes or no.");
                    }
                }while(!confirm.equals("y") && !confirm.equals("n"));
                
                do{
                    System.out.println("Update the stock level? (y) yes, (n) no: ");
                    confirm = input.nextLine();
                    if(confirm.equals("y")){
                        System.out.print("Enter the new stock level for " + p.getName() + ": ");
                        int newLevel = input.nextInt();
                        input.nextLine();
                        p.setQuantity(newLevel);
                    }else if(confirm.equals("n")){
                        System.out.print("Product Stock Level still: " + p.getQuantity());
                    }else{
                        System.out.print("Please enter yes or no.");
                    }
                }while(!confirm.equals("y") && !confirm.equals("n"));
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("\n" + "PRODUCT CODE: " + code + " is not found!!");
        }
    }
    
    public static void deleteProduct(){
        System.out.print("Please enter the product code to delete: ");
        String code = input.nextLine();
        boolean found = false;
        Iterator<Product> iterator = productsInventory.iterator();
        while(iterator.hasNext()){
            Product p = iterator.next();
            if(code.equals(p.getCode())){
                found = true;
                System.out.println("PRODUCT CODE: " + p.getCode());
                System.out.println("PRODUCT NAME: " + p.getName());
                System.out.println("PRODUCT CATEGORY: " + p.getCategory());
                System.out.println("PRODUCT WARRANTY: " + p.getWarranty());
                System.out.println("PRODUCT PRICE: R " + p.getPrice());
                System.out.println("PRODUCT STOCK LEVEL: " + p.getQuantity());
                System.out.println("PRODUCT SUPPLIER: " + p.getSupplier());
                
                String confirm;
                do{
                    System.out.println("Are you sure you want to delete " + p.getName()+ "?" + "\n");
                    System.out.print("Enter (y) yes, or (n) no:");
                    confirm = input.nextLine();
                
                    if(confirm.equals("y")){
                        productsInventory.remove(p);
                        System.out.print("Product of code " + code + " is successfuly removed..");
                    }else if(confirm.equals("n")){
                        System.out.print("Product of code " + code + " is not deleted..");
                    }else{
                        System.out.print("Please enter yes or no.");
                    }
                }while(!confirm.equals("y") && !confirm.equals("n"));
               break; 
            }
        }
        if(!found){
            System.out.println("\n" + "PRODUCT CODE: " + code + " is not found!!");
        }
    }
    
    public static void printReport(){
        for(Product p: productsInventory){
            System.out.println("\n");
            System.out.println("PRODUCT CODE: " + p.getCode());
            System.out.println("PRODUCT NAME: " + p.getName());
            System.out.println("PRODUCT CATEGORY: " + p.getCategory());
            System.out.println("PRODUCT WARRANTY: " + p.getWarranty());
            System.out.println("PRODUCT PRICE: R " + p.getPrice());
            System.out.println("PRODUCT STOCK LEVEL: " + p.getQuantity());
            System.out.println("PRODUCT SUPPLIER: " + p.getSupplier());
            System.out.println("\n");
        }
    }
}
