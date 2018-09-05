/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.views;

import imp.main.model.Inhouse;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import imp.main.model.Inventory;
import imp.main.model.Outsourced;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Mal
 */
public class ModifyPartsScreenController {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private  Button cancelButton;
    @FXML
    private  RadioButton inHouseRadioButton;
    @FXML
    private  RadioButton outsourcedRadioButton;
    @FXML
    private Button saveButton;
    @FXML
    private  TextField id;
    @FXML
    private  TextField name;
    @FXML
    private  TextField inv;
    @FXML
    private  TextField price;
    @FXML
    private  TextField max;
    @FXML
    private  TextField min;
    @FXML
    private  TextField companyName;
    @FXML
    private  TextField machineID;
    
    @FXML     
    public void cancelButtonToMainScreen() {
        
            
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel...");
        alert.setHeaderText("No Part Will Be Modified...");
        alert.setContentText("Are you sure you want to exit?");        
        alert.showAndWait()
            
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> { try {

        Stage stage; 
        Parent root;       
        stage=(Stage) cancelButton.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
                    } catch (IOException e) {
            e.printStackTrace();
            
        }});
        
}
    
            public void cancelToMainScreen() {
        try {
        Stage stage; 
        Parent root;       
        stage=(Stage) cancelButton.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
}
    public void setTextFieldsInhouse (String id, String name, String inv, String price, String max, String min, String machineID ) {
    this.id.setText(id);
    this.name.setText(name);
    this.inv.setText(inv);
    this.price.setText(price);
    this.max.setText(max);
    this.min.setText(min);
    this.machineID.setText(machineID);
    }
    
    public void setTextFieldsOutsourced (String id, String name, String inv, String price, String max, String min, String companyName ) {
    this.id.setText(id);
    this.name.setText(name);
    this.inv.setText(inv);
    this.price.setText(price);
    this.max.setText(max);
    this.min.setText(min);
    this.companyName.setText(companyName);
    }
    
    
    
    
    @FXML     
     public void inHousePartsOnly (){
     setInhousePartsOnly();
     companyName.setEditable(false);
     companyName.setPromptText("N/A to InHouse");
     machineID.setPromptText("");
     machineID.setEditable(true);
     }
      
     
     
    @FXML     
    public void outsourcedPartsOnly (){
    setOutsourcedPartsOnly();
    machineID.setEditable(false);
    machineID.setPromptText("N/A to Outsourced");
    companyName.setPromptText("");
    companyName.setEditable(true);
    }
    
    public void setInhousePartsOnly () {
        this.inHouseRadioButton.setSelected(true);
    }
    
    public void setOutsourcedPartsOnly () {
        this.outsourcedRadioButton.setSelected(true);
    }
    
    public void savePartModifications () {
        boolean checkList = true;
     if (inHouseRadioButton.isSelected()== false & outsourcedRadioButton.isSelected()== false) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Part Type Selected");
        alert.setHeaderText("Please Select Part Type - Inhouse or Outsourced");
        alert.setContentText("Explanation- All Parts must have a type");
        alert.showAndWait();
        checkList = false;
     }   
     if (inHouseRadioButton.isSelected()) 
     {
         
         if (name.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Name For Part");
        alert.setHeaderText("Please Enter a Name for Part");
        alert.setContentText("Explanation- All Parts must have a name");
        alert.showAndWait();
        checkList = false;
          }
        if (min.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Minimum inventory For Part");
        alert.setHeaderText("Please Enter Minimum inventory for Part");
        alert.setContentText("Explanation- All Parts must have Minimum inventory");
        alert.showAndWait();
        checkList = false;
          }
        if (max.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Maximum inventory For Part");
        alert.setHeaderText("Please Enter a Maximum inventory for Part");
        alert.setContentText("Explanation- All Parts must have a Maximum inventory");
        alert.showAndWait();
        checkList = false;
          }
        if (id.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No ID For Part");
        alert.setHeaderText("Please Enter an ID for Part");
        alert.setContentText("Explanation- All Parts must have an ID");
        alert.showAndWait();
        checkList = false;
          }
          if (price.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Name For Part");
        alert.setHeaderText("Please Enter a Price for Part");
        alert.setContentText("Explanation- All Parts must have a price");
        alert.showAndWait();
        checkList = false;
          }
          if (inv.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Inventory For Part");
        alert.setHeaderText("Please Enter an Inventory Level for a Part");
        alert.setContentText("Explanation- All Parts must have an Inventory Level ");
        alert.showAndWait();
        checkList = false;
          }
        if (machineID.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Machine ID For Inhouse Part");
        alert.setHeaderText("Please Enter a Machine ID For Inhouse Part");
        alert.setContentText("Explanation- All Inhouse Parts must have a Machine ID ");
        alert.showAndWait();
        checkList = false;
          }
        //If textfields are all populated, second check for Inv, Max, and Min rules
        if (checkList) {
             if (Integer.parseInt(inv.getText()) > Integer.parseInt(max.getText())) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Inventory Error");
        alert.setHeaderText("Please Correct Inventory Amount");
        alert.setContentText("Explanation- Inventory Can't Be More Than Maximum Inventory Level");
        alert.showAndWait();
        checkList = false;
         }
         if  (Integer.parseInt(max.getText()) < Integer.parseInt(min.getText())) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Maximum Error");
        alert.setHeaderText("Please Correct Maximum Number");
        alert.setContentText("Explanation- Maximum can't be less than Minimum inventory levels");
        alert.showAndWait();
        checkList = false;
         }
          if  (Integer.parseInt(min.getText()) >= Integer.parseInt(max.getText())) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Minimum Error");
        alert.setHeaderText("Please Correct Minimum Number");
        alert.setContentText("Explanation- Minimum must be less than Maximum inventory levels");
        alert.showAndWait();
        checkList = false;
         }
        }
        // IF checkList is still true, construct Inhouse part
        if ( Inventory.getIsInhouse() & checkList){
            inHousePartsOnly();
            Inventory.getChosenInhouse().setPartID(textFieldIntParser(id).getValue());
            Inventory.getChosenInhouse().setName(textFieldSimpleStringParser(name).get());
            Inventory.getChosenInhouse().setInStock(textFieldIntParser(inv).getValue());
            Inventory.getChosenInhouse().setPrice(textFieldDoubleParser(price).get());
            Inventory.getChosenInhouse().setMax(textFieldIntParser(max).getValue());
            Inventory.getChosenInhouse().setMin(textFieldIntParser(min).getValue());
            Inventory.getChosenInhouse().setMachineID(textFieldIntParser(machineID).getValue());
           
            cancelToMainScreen();
            
        
    } } else {
                      
        
          if (name.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Name For Part");
        alert.setHeaderText("Please Enter a Name for Part");
        alert.setContentText("Explanation- All Parts must have a name");
        alert.showAndWait();
        checkList = false;
          }
        if (min.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Minimum inventory For Part");
        alert.setHeaderText("Please Enter Minimum inventory for Part");
        alert.setContentText("Explanation- All Parts must have Minimum inventory");
        alert.showAndWait();
        checkList = false;
          }
        if (max.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Maximum inventory For Part");
        alert.setHeaderText("Please Enter a Maximum inventory for Part");
        alert.setContentText("Explanation- All Parts must have a Maximum inventory");
        alert.showAndWait();
        checkList = false;
          }
        if (id.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No ID For Part");
        alert.setHeaderText("Please Enter an ID for Part");
        alert.setContentText("Explanation- All Parts must have an ID");
        alert.showAndWait();
        checkList = false;
          }
          if (price.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Name For Part");
        alert.setHeaderText("Please Enter a Price for Part");
        alert.setContentText("Explanation- All Parts must have a price");
        alert.showAndWait();
        checkList = false;
          }
          if (inv.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Inventory For Part");
        alert.setHeaderText("Please Enter an Inventory Level for a Part");
        alert.setContentText("Explanation- All Parts must have an Inventory Level ");
        alert.showAndWait();
        checkList = false;
          }
        if (companyName.getText().equals("")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Company Name For Outsourced Part");
        alert.setHeaderText("Please Enter a Company Name For Outsourced Part");
        alert.setContentText("Explanation- All Outsourced Parts must have a Company Name ");
        alert.showAndWait();
        checkList = false;
          }
        //If textfields are all populated, second check for Inv, Max, and Min rules
        if (checkList) {
             if (Integer.parseInt(inv.getText()) > Integer.parseInt(max.getText())) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Inventory Error");
        alert.setHeaderText("Please Correct Inventory Amount");
        alert.setContentText("Explanation- Inventory Can't Be More Than Maximum Inventory Level");
        alert.showAndWait();
        checkList = false;
         }
         if  (Integer.parseInt(max.getText()) < Integer.parseInt(min.getText())) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Maximum Error");
        alert.setHeaderText("Please Correct Maximum Number");
        alert.setContentText("Explanation- Maximum can't be less than Minimum inventory levels");
        alert.showAndWait();
        checkList = false;
         }
          if  (Integer.parseInt(min.getText()) >= Integer.parseInt(max.getText())) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Minimum Error");
        alert.setHeaderText("Please Correct Minimum Number");
        alert.setContentText("Explanation- Minimum must be less than Maximum inventory levels");
        alert.showAndWait();
        checkList = false;
         }
        }
        // If checkList is still true, then construct Outsourced Part
         if (checkList) {
           outsourcedPartsOnly();
           Inventory.getChosenOutsourced().setPartID(textFieldIntParser(id).getValue());
           Inventory.getChosenOutsourced().setName(textFieldSimpleStringParser(name).get());
           Inventory.getChosenOutsourced().setInStock(textFieldIntParser(inv).getValue());
           Inventory.getChosenOutsourced().setPrice(textFieldDoubleParser(price).get());
           Inventory.getChosenOutsourced().setMax(textFieldIntParser(max).getValue());
           Inventory.getChosenOutsourced().setMin(textFieldIntParser(min).getValue());
           cancelToMainScreen();
        }
    }
    
    }
    
        public SimpleStringProperty textFieldSimpleStringParser (TextField TextField) {
        SimpleStringProperty Stringy =  new SimpleStringProperty (TextField.getText());
        return Stringy;
    }
    
    public SimpleIntegerProperty textFieldIntParser (TextField TextField) {
        String text = TextField.getText();
        SimpleIntegerProperty idValue = new SimpleIntegerProperty(Integer.parseInt(text));
        return idValue;
    }
    
    public SimpleDoubleProperty textFieldDoubleParser (TextField TextField) {
        String text = TextField.getText();
        SimpleDoubleProperty idValue = new SimpleDoubleProperty(Double.valueOf(text));
        return idValue;
    }
    
    @FXML
    public void initialize() {
        // Setting Togglegroup for Radio Buttons so only one can be selected
        ToggleGroup group = new ToggleGroup();
        inHouseRadioButton.setToggleGroup(group);
        outsourcedRadioButton.setToggleGroup(group);
        // Initialize data from Inventory's static Inhouse or Outsourced Part
        if ( Inventory.getIsInhouse()){
           inHousePartsOnly(); 
           setTextFieldsInhouse(Inventory.getChosenInhouse().getPartID().getValue().toString(), 
                    Inventory.getChosenInhouse().getName().get(), 
                    Inventory.getChosenInhouse().getInStock().getValue().toString(), 
                    Inventory.getChosenInhouse().getPrice().getValue().toString(), 
                    Inventory.getChosenInhouse().getMax().getValue().toString(), 
                    Inventory.getChosenInhouse().getMin().getValue().toString(), 
                    Inventory.getChosenInhouse().getMachineID().getValue().toString());
        
        } else {
           outsourcedPartsOnly(); 
           setTextFieldsOutsourced(Inventory.getChosenOutsourced().getPartID().getValue().toString(), 
                    Inventory.getChosenOutsourced().getName().get(), 
                    Inventory.getChosenOutsourced().getInStock().getValue().toString(), 
                    Inventory.getChosenOutsourced().getPrice().getValue().toString(), 
                    Inventory.getChosenOutsourced().getMax().getValue().toString(), 
                    Inventory.getChosenOutsourced().getMin().getValue().toString(), 
                    Inventory.getChosenOutsourced().getCompanyName().get());
        
        }
        
        //test setTextFieldsInhouse method
        /*setTextFieldsInhouse(Inventory.getChosenInhouse().getPartID().getValue().toString(), 
                    Inventory.getChosenInhouse().getName().toString(), 
                    Inventory.getChosenInhouse().getInStock().getValue().toString(), 
                    Inventory.getChosenInhouse().getPrice().getValue().toString(), 
                    Inventory.getChosenInhouse().getMax().getValue().toString(), 
                    Inventory.getChosenInhouse().getMin().getValue().toString(), 
                    Inventory.getChosenInhouse().getMachineID().getValue().toString());
        */
        
        
    }
    
    
}
