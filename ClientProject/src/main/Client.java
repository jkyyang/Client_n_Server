package src.main;


import src.dataStructure.*;
import src.staticInfo.SocketInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Client {

    public void run() throws IOException {

        Socket clientSocket = null;

        clientSocket = new Socket(SocketInfo.getHostName(), SocketInfo.getPortNumber());

        try {
            

            Message sendMsg = new Message("hello");
            assert  (setMsg(clientSocket, sendMsg));



            Message rcvMsg = getMsg(clientSocket);
            if (rcvMsg.getReliable()) {
                System.out.println("收到消息："+rcvMsg.getMsg());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close this socket
            clientSocket.close();
        }

    }


    private Message getMsg(Socket skt) throws IOException {

        Message message = new Message();

        try {

            // obj that read from buffer and get msg from svt
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(skt.getInputStream())
            );

            message.setMsg("server answers: "+reader.readLine());

            // step 2: show msg from svr
//            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // bad message will return false in message
        return message;
    }


    private boolean setMsg(Socket skt, Message msg) throws IOException {

        try {

            // obj that write msg into buffer for svr
            PrintWriter writer = new PrintWriter(skt.getOutputStream(), true);


            // obj that read standard io stream
            // BufferedReader stdIn = new BufferedReader(
            //     new InputStreamReader()
            // );


            // step 1: sign in to svr
            // writer.println(stdIn.readLine());
            writer.println(msg.getMsg());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
