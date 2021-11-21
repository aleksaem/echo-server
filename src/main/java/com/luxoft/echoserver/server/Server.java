package com.luxoft.echoserver.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);

            while(true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[100];
                int count = inputStream.read(buffer);
                String messageFromClient = new String(buffer, 0, count);
                String message = "Echo: " + messageFromClient;

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(message.getBytes());

                inputStream.close();
                outputStream.close();
            }

        } catch (IOException e) {
            System.err.println("Error");
            e.printStackTrace();
        }

    }
}
