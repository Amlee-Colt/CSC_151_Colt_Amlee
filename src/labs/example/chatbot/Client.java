/*
@author: Colt Amlee
@date: 20 April 2026
@purpose: Week 15 lab
*/


package labs.example.chatbot;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.75.2.53", 5000); //"10.75.2.53" is my IP. If I were able to find a willing participant for Part 2, I would replace this with their IP, and they would use that for their own client to connect to my server.
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true) {
                message = reader.readLine();
                if (message.equals("null")) {
                    socket.close();
                    break;
                }
                out.println(message);
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}