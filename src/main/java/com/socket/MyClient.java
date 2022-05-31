package com.socket;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9888);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.write("hello world");
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);
    }
}
