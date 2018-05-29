/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.server;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author willi_000
 */
public class ServerVista extends Application {
       
    private static final int puerto=2020;
    private TextArea textArea;
    
    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        VBox root = new VBox();
        root.getChildren().add(textArea);

        Scene scene = new Scene(root, 300, 250);

        Server server = new Server(puerto, this);
        server.start();    
        
        primaryStage.setTitle("Server chat");
        primaryStage.setScene(scene);
        primaryStage.show();               
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
