/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mal
 */
public class Inhouse extends Part {
    SimpleIntegerProperty machineID;
    
    public Inhouse (SimpleIntegerProperty partID, SimpleStringProperty name, SimpleDoubleProperty price, SimpleIntegerProperty inStock, SimpleIntegerProperty min, SimpleIntegerProperty max, SimpleIntegerProperty machineID) {
    this.partID = partID;
    this.name = name;
    this.price = price;
    this.inStock = inStock;
    this.min = min;
    this.max = max;
    this.machineID = machineID;
    }
    
    public void setMachineID (int machineIDnumber){
    this.machineID = new SimpleIntegerProperty(machineIDnumber);    
    }
    
    public SimpleIntegerProperty getMachineID (){
    return this.machineID;  
    }
}
