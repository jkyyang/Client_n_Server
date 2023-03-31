/*
 * @Author: jiaqiyang jkyyang@foxmail.com
 * @Date: 2023-03-29 00:01:09
 * @LastEditors: jiaqiyang jkyyang@foxmail.com
 * @LastEditTime: 2023-03-31 10:16:11
 * @FilePath: /Client_n_Server/ClientProject/src/main/Client.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

package src.main;


import src.dataStructure.*;
import src.staticInfo.SocketInfo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


// client worker
public class Worker {

    public void run() throws IOException {
        // Dispatch();
        Socket clientSocket = null;

        clientSocket = new Socket(SocketInfo.getHostName(), SocketInfo.getPortNumber());

        try {
            
            /**
             * 发送
             */            
            Message msgSend = new Message("hello");
            this.SendMsgHelper(clientSocket, msgSend);



            /**
             * 接受
             */ 
            Message rcvMsg = this.getMsgHelper(clientSocket);
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


    public void Dispatch() {
        System.out.println("hello, input 1 for sending message");

        Scanner stdINScanner = new Scanner(System.in);

        int command = stdINScanner.nextInt();

        switch (command) {
            case 1:
            System.out.println("hahaha");
        }
    }



    /**
     * @description: 
     * 从TCP缓冲区获得字节流，并转换为协议信息
     * @param {Socket} skt
     * @return {Message} message
     */    

    private Message getMsgHelper(Socket skt) throws IOException {

        Message message = new Message();

        try {
            // 使用字节流IO
            // obj that read from buffer and get msg from svt
            /*
             * InputStreamReader 字符流 
             * 处理 InputStream 
             */ 
            // BufferedReader 字符流 Reader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(skt.getInputStream())
            );

            message.setMsg("server answers: "+reader.readLine());

            // step 2: show msg from svr
            // System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // bad message will return false in message
        return message;
    }


    private boolean SendMsgHelper(Socket skt, Message msg) throws IOException {

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
