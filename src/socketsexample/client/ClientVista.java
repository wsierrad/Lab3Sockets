/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author willi_000
 */
public class ClientVista extends Application {
    private Client client;
    private TextArea mensajes;
    private TextArea usuarios;
    private TextArea msg;
    
    @Override
    public void start(Stage primaryStage) {
        mensajes = new TextArea();
        usuarios = new TextArea();
        msg = new TextArea();
        msg.setPrefRowCount(1);

        Button btn = new Button();
        btn.setText("Enviar");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String ms = msg.getText();
                client.send(ms);                
            }
        });
        
        VBox root = new VBox();
        root.getChildren().add(mensajes);
        root.getChildren().add(msg);
        root.getChildren().add(btn);
        
        HBox prin = new HBox();
        prin.getChildren().add(usuarios);
        prin.getChildren().add(root);
        
        Scene scene = new Scene(prin, 600, 600);
        
        primaryStage.setTitle("Server chat");
        primaryStage.setScene(scene);
        client= new Client(this, "localhost", 2020);
        client.start();
        primaryStage.show();
    }

    public Client getClient() {
        return client;
    }

    public TextArea getMensajes() {
        return mensajes;
    }

    public TextArea getUsuarios() {
        return usuarios;
    }

    public TextArea getMsg() {
        return msg;
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
