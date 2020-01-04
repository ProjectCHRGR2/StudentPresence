package com.example.studentpresence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage extends Thread{
    private String message;
    SendMessage(String message){
        this.message = message;
    }

    public void run() {
        Socket socket;
        try {
            socket = new Socket("92.110.49.226", 11111); // Add IP and PORT CHANGED FOR TESTING
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output.write(message);
            output.flush();
            System.out.println(message);
            System.out.println(output);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
