package com.luxoft.echoserver.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Write your message: ");
            String message = reader.readLine();

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());

            InputStream inputStream = socket.getInputStream();

            byte[] buffer = new byte[100];
            int count = inputStream.read(buffer);

            System.out.println(new String(buffer, 0, count));

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
