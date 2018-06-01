package com.jcourse.Evdokimov.s5_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

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
        //System.out.println(Indexer.getHtmlFromPath("."));
        //}

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
            String charsetName= new String("UTF-8");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input,charsetName));
            BufferedOutputStream writer = new BufferedOutputStream(s.getOutputStream());
            String line = "";
            while ( true ) {
                line = reader.readLine();
                if ("".equals(line)) break;
                if(line.matches("GET"))
                {
                    String currentQ = line.split("\\s")[1];
                }else if(line.matches("GET")){
                    String currentQ = line.split("\\s")[1];
                }
                System.out.println(line);
            }
            String str = Indexer.getHtmlFromPath(".");
            //writer.write("404".getBytes());
            writer.write("HTTP/1.1 200 OK\r\n".getBytes());
            writer.write("Content-Type: text/html; charset=UTF-8\r\n".getBytes());
            writer.write(("Content-Length: "+str.getBytes().length+"\r\n").getBytes());
            writer.write("\r\n".getBytes());
            writer.write(str.getBytes());
            writer.flush();

            /*writer.write(String.format("HTTP/1.0 404 NotFound%nContent-Length: 44%n%n<html><head>dfsw</title><body></body></html>").getBytes());
            writer.flush();*/
            input.close();
            reader.close();;
            writer.close();
            s.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
