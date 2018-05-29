package socketsexample.server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willi_000
 */
import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by jim on 4/18/17.
 */
public class ServerWorker extends Thread {

    private final Socket clientSocket;
    private final Server server;
    private String login = null;
    private OutputStream outputStream;
    private final ServerVista vista;

    public ServerWorker(Server server, Socket clientSocket, ServerVista vista) {
        this.server = server;
        this.clientSocket = clientSocket;
        this.vista=vista;
    }

    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (IOException | InterruptedException e) {
        }
    }
    
    private void handleClientSocket() throws IOException, InterruptedException {
        InputStream inputStream = clientSocket.getInputStream();
        this.outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while (login==null && (line = reader.readLine()) != null) {
            String[] tokens = line.split(" ");
            if (tokens != null && tokens.length > 0) {
                String cmd = tokens[0];
                if ("login".equalsIgnoreCase(cmd)) {
                    handleLogin(outputStream, tokens);
                    break;
                } else {
                    String msg = "unknown " + cmd + "\n";
                    outputStream.write(msg.getBytes());
                }
            }
        }
        while(login!=null &&(line = reader.readLine()) != null){
            if (line.equalsIgnoreCase("logoff")){
                handleLogoff();
                break;
            }else {
                send(line);
            }
        }

        clientSocket.close();
    }

    private void handleLogoff() throws IOException {
        List<ServerWorker> workerList = server.getWorkerList();
        
        // send other online users current user's status
        String onlineMsg = "offline " + login + "\n";
        for(ServerWorker worker : workerList) {
            if (!login.equals(worker.getLogin())) {
                worker.send(onlineMsg);
            }
        }
        clientSocket.close();
    }

    public String getLogin() {
        return login;
    }

    private void handleLogin(OutputStream outputStream, String[] tokens) throws IOException {
        if (tokens.length == 3) {
            String _login = tokens[1];
            String password = tokens[2];

            if ((_login.equals("guest") && password.equals("guest")) || (_login.equals("jim") && password.equals("jim")) ) {
                String msg = "ok login\n";
                outputStream.write(msg.getBytes());
                this.login = _login;
                message("User logged in succesfully: " + _login);

                List<ServerWorker> workerList = server.getWorkerList();

                // send current user all other online logins
                for(ServerWorker worker : workerList) {
                    if (worker.getLogin() != null) {
                        if (!_login.equals(worker.getLogin())) {
                            String msg2 = "online " + worker.getLogin() + "\n";
                            send(msg2);
                        }
                    }
                }

                // send other online users current user's status
                String onlineMsg = "online " + _login + "\n";
                for(ServerWorker worker : workerList) {
                    if (!_login.equals(worker.getLogin())) {
                        worker.send(onlineMsg);
                    }
                }
            } else {
                String msg = "error login\n";
                outputStream.write(msg.getBytes());
            }
        }
    }
    
    private void message(String text){
        String pre = vista.getTextArea().getText();
        vista.getTextArea().setText(pre + "\n" + text);
    }

    private void send(String msg) throws IOException {
        if (login != null) {
            outputStream.write(msg.getBytes());
            message(msg);
        }
    }   
    
}