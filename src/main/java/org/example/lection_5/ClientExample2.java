package org.example.lection_5;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample2 {
    public static void main(String[] args){
    try{
        InetAddress address = InetAddress.getLocalHost();
        Socket client = new Socket(address, 1300);

        System.out.println(client.getInetAddress());
        System.out.println(client.getLocalPort());

        InputStream inStream = client.getInputStream(); // поток ввода клиентского сокета
        OutputStream outStream = client.getOutputStream(); // поток вывода
        DataInputStream dataInputStream = new DataInputStream(inStream); // позволяет читать из потока любые
        // примитивные типы, массивы и строки (что гораздо удобнее, чем оперировать битами/ байтами
        PrintStream printStream = new PrintStream(outStream); // класс PrintStream добавляет функционал, позволяет
        // печать туда строки как будто мы вызываем обычный sout

        printStream.println("Привет!");// передача строки по сети сводится
        // к вызову метода println() с передачей обычной строки
        System.out.println(dataInputStream.readLine()); // используем возможности
        // dataInputStream, чтобы получить строку по сети и вывести её в консоль
        client.close(); // закрываем сокет, чтобы освободить ресурсы сервера
        //
    }
        catch (UnknownHostException e){
            throw  new RuntimeException(e);
    }
        catch (IOException e){
            throw new RuntimeException(e);
    }

}
}
