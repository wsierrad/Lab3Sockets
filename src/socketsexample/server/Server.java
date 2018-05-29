/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.server;

/**
 *
 * @author willi_000
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 4/19/17.
 */
public class Server extends Thread {
    private final int serverPort;
    private final ServerVista vista;

    private final ArrayList<ServerWorker> workerList;

    public Server(int serverPort, ServerVista vista) {
        workerList = new ArrayList<>();
        this.serverPort = serverPort;
        this.vista= vista; 
    }

    public List<ServerWorker> getWorkerList() {
        return workerList;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while(true) {
                message("About to accept client connection...");
                Socket clientSocket = serverSocket.accept();
                message("Accepted connection from " + clientSocket);
                ServerWorker worker = new ServerWorker(this, clientSocket,vista);
                workerList.add(worker);
                worker.start();
            }
        } catch (IOException e) {System.out.println(e.getMessage());
        }
    }
    
    private void message(String text){
        String pre = vista.getTextArea().getText();
        vista.getTextArea().setText(pre + "\n" + text);
    }
}

