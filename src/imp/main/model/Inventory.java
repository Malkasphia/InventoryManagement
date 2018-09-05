/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mal
 */
public class Inventory {
    private static ObservableList<Product> products = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    protected static Inhouse chosenInhouse;
    protected static Outsourced chosenOutsourced;
    protected static boolean isInhouse = false;
    
    //test constructor for static block below
    public Inventory() {
    products.add(new Product(new SimpleIntegerProperty(001),new SimpleStringProperty("TestProduct"), new SimpleDoubleProperty(5.00),new SimpleIntegerProperty(15),new SimpleIntegerProperty(1),new SimpleIntegerProperty(15)));
    allParts.add(new Inhouse(new SimpleIntegerProperty(0001),new SimpleStringProperty("TestinHousePart"), new SimpleDoubleProperty(5.00),new SimpleIntegerProperty(15),new SimpleIntegerProperty(1),new SimpleIntegerProperty(15),new SimpleIntegerProperty(0001)));
    allParts.add(new Inhouse(new SimpleIntegerProperty(0002),new SimpleStringProperty("Test2"), new SimpleDoubleProperty(5.00),new SimpleIntegerProperty(15),new SimpleIntegerProperty(1),new SimpleIntegerProperty(15),new SimpleIntegerProperty(0001)));   
    allParts.add(new Outsourced(new SimpleIntegerProperty(0002),new SimpleStringProperty("Outsourced Test"), new SimpleDoubleProperty(5.00),new SimpleIntegerProperty(15),new SimpleIntegerProperty(1),new SimpleIntegerProperty(15),new SimpleStringProperty("Mal Inc")));
    }
//test static block for filler data
static { Inventory inventory = new Inventory();
}
     
    
    public static void addProduct (Product product){
    Inventory.products.add(product);
    }
    
    public static boolean removeProduct (Product product) {
    for (Product element : products) {
        if (element.getProductID().getValue() == product.getProductID().get()){
            products.remove(element);
            return true;
        }
        
        

}
    return false;
}
    public static void setTrueIsInhouse () {
        Inventory.isInhouse = true;
    }
    
    public static void setFalseIsInhouse () {
        Inventory.isInhouse = false;
    }
    
    public static boolean getIsInhouse () {
        return Inventory.isInhouse ;
    }
    
    public static void setChosenInhouse (Inhouse newChosenPart) {
    Inventory.chosenInhouse = newChosenPart;    
    }
    
    public static Inhouse getChosenInhouse () {
        return Inventory.chosenInhouse;
    }
    
    public static void setChosenOutsourced (Outsourced newOutsourcedPart) {
    Inventory.chosenOutsourced = newOutsourcedPart;    
    }
    
    public static Outsourced getChosenOutsourced () {
     return Inventory.chosenOutsourced;    
    }
    
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    
    public static ObservableList<Product> getAllProducts() {
        return products;
    }
    
    
    public static Product lookupProduct (SimpleIntegerProperty productID) {
    for (Product productSearchedFor : products) {
        if (productSearchedFor.getProductID() == productID){
            return productSearchedFor;
            
    }
      
} 
    return null;   
}
    
    public void updateProduct (int productID){
    // to do    
   
    }
    
    public static void addPart (Part part){
    Inventory.allParts.add(part);   
   
    }
    
    public static boolean deletePart (Part part){
    for (Part partSearchedFor : allParts) {
        if (partSearchedFor.getPartID() == part.getPartID()){
            allParts.remove(partSearchedFor);
            return true;
        }
        
        

}
    return false;
}
     
    public static Part lookupPart (int partID) {
    for (Part partSearchedFor : allParts) {
        if (partSearchedFor.getPartID().getValue() == partID ){
            return partSearchedFor;
            
    }
      
} 
    return null;   
}

    public void updatePart (int partID){
    // to do    
   
    }
     
}
