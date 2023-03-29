import helper.*;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class WebServer {
    public static void main(String[] args) throws IOException {

        WebServer webServer = new WebServer();
        webServer.launch();
    } 

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


