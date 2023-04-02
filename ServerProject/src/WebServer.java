/*
 * @Author: jiaqiyang jkyyang@foxmail.com
 * @Date: 2023-03-28 16:04:14
 * @LastEditors: jiaqiyang jkyyang@foxmail.com
 * @LastEditTime: 2023-04-02 00:50:05
 * @FilePath: /Client_n_Server/ServerProject/src/WebServer.java
 */
import helper.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: WebServer类
 * @author: jiaqiyang jkyyang@foxmail.com
 */

public class WebServer {

    public static void main(String[] args) throws IOException {

        WebServer webServer = new WebServer();
        webServer.launch();
    } 

    /**
     * @description: launch method
     * @return {*}
     */
    void launch() throws IOException {

        // svr portNumber
        int portNumber = 12223;

        /*
         * 可以通过将变量声明在 try 块之外来解决这个问题。
         * 这样就可以将变量的作用域扩大到 try 块之外的代码中，
         * 使得 finally 块能够访问该变量。
         */
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);

            // main loop
            for(;;) {

                Socket clientSocket = serverSocket.accept();
                
                (new Thread(new Worker(clientSocket))).start();

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(serverSocket != null) {
                try {
                    serverSocket.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


