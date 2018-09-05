/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main.views;

import imp.main.ImpMainClass;
import imp.main.model.*;
import imp.main.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.lang.Integer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;



/**
 * MainScreen FXML Controller class
 *
 * @author Mal
 */
public class MainScreenController {
    // Parts Table FXML Variables
    @FXML
    private Button partsTableSearchButton;
    @FXML
    private Button productsTableSearchButton;
    @FXML
    private TextField searchPartsField;
    @FXML
    private Button partsAddButton;
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
    //Products Table FXML Variables
    @FXML
    private TextField searchProductsField;
    @FXML
    private Button productsAddButton;
    @FXML
    private Button partsDeleteButton;
    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, Number> productsIDColumn;
    @FXML
    private TableColumn<Product, String> productsNameColumn;
    @FXML
    private TableColumn<Product, Number> productsInventoryLevelColumn;
    @FXML
    private TableColumn<Product, Number> productsPricePerUnitColumn;
    
    @FXML
    private void initialize (){
        //Parts Table Initialize
        partsIDColumn.setCellValueFactory(cellData -> cellData.getValue().getPartID());
        partsNameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        partsInventoryLevelColumn.setCellValueFactory(cellData -> cellData.getValue().getInStock());
        partsPriceCostColumn.setCellValueFactory(cellData -> cellData.getValue().getPrice());
        
        //Products Table Initialize
        productsIDColumn.setCellValueFactory(cellData -> cellData.getValue().getProductID());
        productsNameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        productsInventoryLevelColumn.setCellValueFactory(cellData -> cellData.getValue().getInStock());
        productsPricePerUnitColumn.setCellValueFactory(cellData -> cellData.getValue().getPrice());
        
        //Testing Inventory Code
        
        
        //Get all parts table items
        partsTable.setItems(Inventory.getAllParts());
        
        //Get all products table items
        productsTable.setItems(Inventory.getAllProducts());
    }
    
    
   @FXML
        private void exitApplication (){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit...");
        alert.setHeaderText("Exiting Inventory Management Program...");
        alert.setContentText("Are you sure you want to exit?");        
        alert.showAndWait()
            
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> System.exit(0));
        }
        
   @FXML     
       public void showAddPartsScreenDialog() {
        try {
        Stage stage; 
        Parent root;       
        stage=(Stage) searchPartsField.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("AddPartsScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
}
       
       @FXML     
       public void showAddProductScreenDialog() {
        try {
        Stage stage; 
        Parent root;       
        stage=(Stage) searchPartsField.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("AddProductScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
}
       
       @FXML     
       public void showModifyProductScreenDialog() {
        Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Product Selected");
        alert.setContentText("Please select a Product from the table.");

        alert.showAndWait();   
        }
        try {
        ModifyProductsScreenController.setProxyProduct(productsTable.getSelectionModel().getSelectedItem());   
        Stage stage; 
        Parent root;       
        stage=(Stage) productsAddButton.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("ModifyProductsScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
}
       
              @FXML     
       public void showModifyPartsScreenDialog() {
         // Nothing selected.
        Part selectedPart = partsTable.getSelectionModel().getSelectedItem();
        if (selectedPart == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Part Selected");
        alert.setContentText("Please select an Part from the table.");

        alert.showAndWait();   
        }
        try {
        if (partsTable.getSelectionModel().getSelectedItem() instanceof Outsourced){
                Inventory.setChosenOutsourced ((Outsourced)partsTable.getSelectionModel().getSelectedItem());
                Inventory.setFalseIsInhouse();
        }     
        else {   
        Inventory.setChosenInhouse ( (Inhouse)partsTable.getSelectionModel().getSelectedItem());
        Inventory.setTrueIsInhouse();
        } 
         
        if (Inventory.getChosenOutsourced() != null ) {
        Stage stage; 
        Parent root;       
        stage=(Stage) productsAddButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ModifyPartsScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
        }
        if (Inventory.getChosenInhouse() != null ) {
        Stage stage; 
        Parent root;       
        stage=(Stage) productsAddButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ModifyPartsScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        // prep part object selected for insertion into text fields in Modify Parts
        

                
              //assign part to static part in inventory class
              //Logic to decide to load an inHouse or outsourced part
              //insert part object into text fields to be edited
              //create modifypartscreencontroller object for textfields to be manipulated
              //ModifyPartsScreenController textFieldObject = new ModifyPartsScreenController();
              //
              
            

                
        
        
        }
        catch (IOException e) {
            e.printStackTrace();
            
        }
}
        
       
       public void deleteSelectedPart () {
        Part selectedPart = partsTable.getSelectionModel().getSelectedItem();
        if (selectedPart != null) {
             
            
            
            //Confirm Delete
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete...");
        alert.setHeaderText("Deleting...");
        alert.setContentText("Would you like to  delete part " + selectedPart.getName().get()+" now ?");        
        alert.showAndWait()
            
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> Inventory.deletePart(selectedPart));

           

        } else {
        // Nothing selected.
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Part Selected");
        alert.setContentText("Please select an Part from the table.");

        alert.showAndWait();
        }
        }
       
       
       public void deleteProductFromTable () {
           {
           Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            
            //Confirm Delete
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete...");
        alert.setHeaderText("Deleting...");
        alert.setContentText("Would you like to  delete product " + selectedProduct.getName().get()+" now ?");        
        alert.showAndWait()
            
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> { 
                                     if (selectedProduct.getAllParts().size() >= 1) {
                                    Alert alert2 = new Alert(Alert.AlertType.WARNING);
                                   alert.setTitle("Product Has Associated Parts");
                                   alert.setHeaderText("Please Remove Parts From Product");
                                   alert.setContentText("Explanation- Products with Parts Cannot Be Deleted");
                                   alert.showAndWait();
                                       
             
         } else { Inventory.removeProduct(selectedProduct);}}  );

           

        } else {
        // Nothing selected.
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Product Selected");
        alert.setContentText("Please select an Product from the table.");

        alert.showAndWait();
        }
                        
        }
       }
       
       

       
       @FXML 
    private void partsTableSearchButton(){
        String searchText = searchPartsField.getText();
        FilteredList<Part> searchPartResults = searchParts(searchText);
        SortedList<Part> sortedData = new SortedList<>(searchPartResults);
        sortedData.comparatorProperty().bind(partsTable.comparatorProperty());
        partsTable.setItems(sortedData);
    }    
    
    @FXML 
    private void productsTableSearchButton(){
        String searchText = searchProductsField.getText();
        FilteredList<Product> searchProductsResults = searchProducts(searchText);
        SortedList<Product> sortedData = new SortedList<>(searchProductsResults);
        sortedData.comparatorProperty().bind(productsTable.comparatorProperty());
        productsTable.setItems(sortedData);
    }  
    public FilteredList<Part> searchParts(String s){
        return Inventory.getAllParts().filtered(p -> p.getName().get().toLowerCase().contains(s.toLowerCase()));
    }
    
    public FilteredList<Product> searchProducts(String s){
        return Inventory.getAllProducts().filtered(p -> p.getName().get().toLowerCase().contains(s.toLowerCase()));
    }
}

       
     
        
        
    

    /* FXML ID Initialize */
     

