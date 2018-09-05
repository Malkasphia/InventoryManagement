/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.model;
import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mal
 */
public class Outsourced extends Part {
    SimpleStringProperty companyName;
   
   public Outsourced (SimpleIntegerProperty partID, SimpleStringProperty name, SimpleDoubleProperty price, SimpleIntegerProperty inStock, SimpleIntegerProperty min, SimpleIntegerProperty max, SimpleStringProperty companyName) {
    this.partID = partID;
    this.name = name;
    this.price = price;
    this.inStock = inStock;
    this.min = min;
    this.max = max;
    this.companyName = companyName;
    }
   
   public Outsourced () {}
   
   public void setCompanyName (String companyName){
    this.companyName = new SimpleStringProperty(companyName);    
    }
    
    public SimpleStringProperty getCompanyName (){
    return this.companyName;    
    }
}
