package com.jcourse.Evdokimov.s5_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(8080);
        while (true)
        {
            Socket clientSocket = s.accept(); //принимаем соединение
            //Создаем и запускаем поток для обработки запроса
            Thread t = new Thread(new RequestProcessor(clientSocket));
            t.start();
        }
    }
}

class RequestProcessor implements Runnable
{
    Socket s;
    RequestProcessor(Socket s)  {
        this.s = s;
    }
    public void run()  {
        try  {
            InputStream input = s.getInputStream();
            String charsetName= new String("CP1251");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input,charsetName));
            OutputStream output = s.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(output);
            String line = "";
            while ( true ) {
                line = reader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
            writer.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
