/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mal
 */
public class Product {
    
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    SimpleIntegerProperty  productID;
    SimpleStringProperty  name;
    SimpleDoubleProperty  price;
    SimpleIntegerProperty  inStock;
    SimpleIntegerProperty  min;
    SimpleIntegerProperty  max;
    
    public Product (){};
    public Product(SimpleIntegerProperty productID, SimpleStringProperty name, SimpleDoubleProperty price, SimpleIntegerProperty inStock, SimpleIntegerProperty min, SimpleIntegerProperty max) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
        
}
        public Product (SimpleIntegerProperty productID, SimpleStringProperty name, SimpleDoubleProperty price, SimpleIntegerProperty inStock, SimpleIntegerProperty min, SimpleIntegerProperty max,ObservableList<Part> associatedParts ) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;
        
}
    
        public ObservableList<Part> getAllParts() {
        return this.associatedParts;
    }
    
    public void setName (String name){
    this.name = new SimpleStringProperty(name); 
}
    public SimpleStringProperty getName (){
    return this.name;
}
    
    public void setPrice (double price){
    this.price =  new SimpleDoubleProperty(price);   
    }
    
    public SimpleDoubleProperty getPrice () {
    return this.price;
    }
    
    public void setInStock (int numberinStock){
    this.inStock =  new SimpleIntegerProperty(numberinStock);    
    }
    
    public SimpleIntegerProperty getInStock () {
    return this.inStock;
    }
    
    public void setMin(int minimum){
    this.min = new SimpleIntegerProperty(minimum);     
    }
    public SimpleIntegerProperty getMin(){
    return this.min;
    }
    
    public void setMax(int maximum){
    this.max = new SimpleIntegerProperty(maximum);     
    }
    public SimpleIntegerProperty getMax(){
    return this.max;
    }
    
    public void addAssociatedPart(Part partAdded) {
        this.associatedParts.add(partAdded);  
    }
    
    public boolean removeAssociatedPart(Part partRemoved) {
    this.associatedParts.remove(partRemoved);
    return true;
    }
    
    public Part lookupAssociatedPart(int partID) {
    
    for (Part partSearchedFor : associatedParts) {
        if (partSearchedFor.getPartID().getValue() == partID ){
            return partSearchedFor;
            
    }
      
} 
    return null;   
}
    
    public void setProductID (int productIDnumber){
    this.productID =  new SimpleIntegerProperty(productIDnumber);     
    }
    
    public SimpleIntegerProperty getProductID (){
    return this.productID;  
    }
    
    
     
}
