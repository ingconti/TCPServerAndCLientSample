package com.ingconti;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{
    static int portNumber = 1234;

    static Boolean readLoop(BufferedReader in ){

        // waits for data and reads it in until connection dies
        // readLine() blocks until the server receives a new line from client
        String s = "";
        try {
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static void main( String[] args )
    {
        System.out.println("Server started!");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            readLoop(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server done!");

        }
}
