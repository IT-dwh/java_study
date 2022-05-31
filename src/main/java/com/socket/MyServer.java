package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9888);
        Socket socket;

        while (true) {
            socket = serverSocket.accept();

            InputStream socketInputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(socketInputStream));
            String line = br.readLine();
            System.out.println(line);

            OutputStream socketOutputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socketOutputStream));
            pw.write("from server");
            pw.flush();
        }
    }
}
