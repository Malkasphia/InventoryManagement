/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.model;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;


/**
 *
 * @author Mal
 */
public abstract class Part {
     SimpleIntegerProperty partID;
     StringProperty name;
     SimpleDoubleProperty price;
     SimpleIntegerProperty inStock;
     SimpleIntegerProperty min;
     SimpleIntegerProperty max;
     
    
    
    public void setName (String name){
    this.name =  new SimpleStringProperty(name);
}
    public StringProperty getName (){
    return this.name;
}
        
    public void setPrice (double price){
    this.price =  new SimpleDoubleProperty(price);   
    }
    
    public SimpleDoubleProperty getPrice () {
    return this.price;
    }
    
    public void setInStock (int numberInStock){
    this.inStock = new SimpleIntegerProperty(numberInStock);    
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
    
    public void setPartID (int partIDnumber){
    this.partID = new SimpleIntegerProperty(partIDnumber);    
    }
    
    public SimpleIntegerProperty getPartID (){
    return this.partID;  
    }

}