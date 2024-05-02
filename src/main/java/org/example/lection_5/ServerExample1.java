package org.example.lection_5;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerExample1 {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(1300); // серверный socket
            // самый частоиспользуемый конструктор у серверного сокета, который
            // принимает порт, по которому будет слушать подключение

            Socket socket = serverSocket.accept(); // методом .accept() начинаем слушать порт
            // работа программы будет приостановлена, пока не произойдёт подключения

            OutputStream outStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outStream);
            printStream.println("Hello");

            socket.close();
            serverSocket.close();
        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
