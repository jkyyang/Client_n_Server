package src.main.java.com.Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import src.main.java.com.dataStructure.*;
import src.main.java.com.staticInfo.SocketInfo;


// client worker
public class Worker {


    Socket clientSocket = null;
    Scanner stdINScanner = null;

    public void run() throws IOException {


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


    public void LaunchPad() throws IOException{

        stdINScanner = new Scanner(System.in);

        System.out.println("System");
        System.out.println("Log in: 1");
        System.out.println("Sign up: 2");
        System.out.println("exit: 3");

        boolean start = true;



        while (start) {

            // stdINScanner = new Scanner(System.in);

            int command = stdINScanner.nextInt();

            switch (command) {

                case 1:
                System.out.println("Log in");
                this.LogInHelper();
                break;

                case 2:
                System.out.println("Sign up");
                this.SignUpHelper();
                break;

                case 3:
                System.out.println("Exit");
                start = false;
                break;
            }
            
        }

        stdINScanner.close();
        
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

    /**
     * @description:
     * logIn
     * 
     * 
     * @return 
     */
    private boolean LogInHelper() {
    
        return false;
    }

    /**
     * @description:
     * SignIn
     * 
     * 
     * @return 
     */
    private boolean SignUpHelper() throws IOException{

        /**
         * 1 客户端连接服务器，并发送registration request msg进行注册，然后客户端等待注册结果。
         * 2 若注册请求通过，服务器在本地passwd文件中保存新用户的用户名和密码的hash值，并
         *   返回registration response msg，通知客户端注册成功。
         * 3 若注册请求未通过(用户重名)，并返回registration response msg，通知客户端注册失败。
         * 
         */

        System.out.print("> User Name: ");

        String username = stdINScanner.next();        
        // send rr msg
        clientSocket = new Socket(SocketInfo.getHostName(), SocketInfo.getPortNumber());

        try {            
            registrationRequestMsg registration_request_msg = new registrationRequestMsg(username);

            SendMsgHelper(clientSocket, registration_request_msg);

            Message rcvMessage = this.getMsgHelper(clientSocket);
            if (rcvMessage.getReliable()) {
                System.out.println("re: "+rcvMessage.getMsg());
            }

        } catch (Exception e) {
            e.getStackTrace();
        }



        return false;
    }


}
