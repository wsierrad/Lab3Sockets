/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi_000
 */
public class Client extends Thread {
    private Socket cliente;
    private ClientVista vista;
    private InputStream flujoEntrada;
    private OutputStream flujoSalida ;
    private BufferedReader lectura;
    private PrintWriter escritura;

    public Client(ClientVista vista,String server,int port) {
        this.vista=vista;
        try {
            cliente = new Socket(server,port);
            //3.Abriendo flujos
            flujoEntrada = cliente.getInputStream();
            flujoSalida = cliente.getOutputStream();
            //4. Poniendo decoradores para leer informacion textual
            lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            escritura = new PrintWriter(flujoSalida,true);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try {
            if (cliente.isConnected()){
                message("Conectado a" + cliente.getLocalAddress() + " " + cliente.getPort());
                String msg;
                while(true){
                    if((msg = lectura.readLine()) != null){
                        message(msg);
                    }
                }
            }else message("Cliente no conectado.");
        } catch (IOException e) {System.out.println(e.getMessage());
        }
    }
    
    public void send(String msg) {
        escritura.println(msg);
    }
    
    private void message(String text){
        String pre = vista.getUsuarios().getText();
        vista.getUsuarios().setText(pre + "\n" + text);
    }
    
}
