/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.views;

import imp.main.model.Inhouse;
import imp.main.model.Inventory;
import imp.main.model.Part;
import imp.main.model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mal
 */
public class AddProductScreenController {

    /**
     * Initializes the controller class.
     */
    // Proxy Product Object for use in holding data for associated Parts to Product
    private static Product proxyProduct = new Product();
    //Buttons
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button addPartToProductButton;
    @FXML
    private Button deletePartAssociationButton;
    //Textfields
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField inv;
    @FXML
    private TextField price;
    @FXML
    private TextField max;
    @FXML
    private TextField min;
    //Parts Table FXML Variables
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TableColumn<Part, Number> partsIDColumn;
    @FXML
    private TableColumn<Part, String> partsNameColumn;
    @FXML
    private TableColumn<Part, Number> partsInventoryLevelColumn;
    @FXML
    private TableColumn<Part, Number> partsPriceCostColumn;
    //PartsinProduct Table FXML Variables
    @FXML
    private TableView<Part> partsinProductTable;
    @FXML
    private TableColumn<Part, Number> partsIDColumnAssociated;
    @FXML
    private TableColumn<Part, String> partsNameColumnAssociated;
    @FXML
    private TableColumn<Part, Number> partsInventoryLevelColumnAssociated;
    @FXML
    private TableColumn<Part, Number> partsPriceCostColumnAssociated;
    
     
    
    
    @FXML     
    public void cancelButtonToMainScreen() {
        
            
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel...");
        alert.setHeaderText("No Product Will Be Added...");
        alert.setContentText("Are you sure you want to exit?");        
        alert.showAndWait()
            
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> { try {
        proxyProduct = new Product();
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
    
    @FXML
    public void addPartToProduct (){
        proxyProduct.addAssociatedPart(partsTable.getSelectionModel().getSelectedItem());
    }
    
    
    
    public void saveNewProductButton () {
        boolean checkList = true;
  

         
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
         if (Double.parseDouble(price.getText()) < totalCostOfAllPartsInProduct()) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Price Error");
        alert.setHeaderText("Please Correct Price");
        alert.setContentText("Explanation- Price of Product is less than cost of its Parts");
        alert.showAndWait();
        checkList = false;    
             
         }
         if (proxyProduct.getAllParts().size() < 1) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Not Enough Parts");
        alert.setHeaderText("Please Add Parts To Product");
        alert.setContentText("Explanation- Products must have at least 1 part");
        alert.showAndWait();
        checkList = false;    
             
         }
         
         }
        

        
         if (checkList) {
    Inventory.addProduct( new Product 
        (textFieldIntParser(id), 
         textFieldSimpleStringParser(name), 
         textFieldDoubleParser(price), 
         textFieldIntParser(inv), 
         textFieldIntParser(min) , 
         textFieldIntParser(max),
         proxyProduct.getAllParts()));
         proxyProduct = new Product();
     cancelToMainScreen();
    }
    }
    
    public double totalCostOfAllPartsInProduct () {
        double totalProductCost = 0.00; 
    for (Part partSearchedFor : proxyProduct.getAllParts()) {
         
        totalProductCost = totalProductCost + partSearchedFor.getPrice().getValue();
        
            
    }
      return totalProductCost;
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
            
    public void deletePartAssociation () {
        proxyProduct.removeAssociatedPart(partsinProductTable.getSelectionModel().getSelectedItem());
    }
    
    public void deleteProductButton () {
        
    }
            
 @FXML
    public void initialize() {
        
        //Parts Table Initialize
        partsIDColumn.setCellValueFactory(cellData -> cellData.getValue().getPartID());
        partsNameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        partsInventoryLevelColumn.setCellValueFactory(cellData -> cellData.getValue().getInStock());
        partsPriceCostColumn.setCellValueFactory(cellData -> cellData.getValue().getPrice());
        
        //Get all parts table items
        partsTable.setItems(Inventory.getAllParts());
        
        //PartsinProduct Table Initialize
        partsIDColumnAssociated.setCellValueFactory(cellData -> cellData.getValue().getPartID());
        partsNameColumnAssociated.setCellValueFactory(cellData -> cellData.getValue().getName());
        partsInventoryLevelColumnAssociated.setCellValueFactory(cellData -> cellData.getValue().getInStock());
        partsPriceCostColumnAssociated.setCellValueFactory(cellData -> cellData.getValue().getPrice());
        
        //Get all Parts associated to Product
        partsinProductTable.setItems(proxyProduct.getAllParts());
          
    
}
    
}
