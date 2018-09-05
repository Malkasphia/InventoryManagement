/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import imp.main.views.*;
import imp.main.model.*;

/**
 *
 * @author Mal
 */
public class ImpMainClass extends Application {
    
    /**
 *
 * Load the Main Screen of the application
 */
    @Override
    public void start(Stage primaryStage) {
        // Test code to be removed
        
        
        
        
        try {
        Parent root = FXMLLoader.load(getClass().getResource("views/MainScreen.fxml"));
        Scene mainscreen = new Scene(root, 800, 600);
        primaryStage.setTitle("Menu Pricer");
        primaryStage.setScene(mainscreen);
        primaryStage.show();
        } catch (IOException e) {
            System.out.println("I/O Exception");
            e.printStackTrace();
            System.exit(0);
        }
}
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

