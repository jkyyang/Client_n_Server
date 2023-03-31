/*
 * @Author: jiaqiyang jkyyang@foxmail.com
 * @Date: 2023-03-29 18:44:34
 * @LastEditors: jiaqiyang jkyyang@foxmail.com
 * @LastEditTime: 2023-03-31 00:07:43
 * @FilePath: /Client_n_Server/ServerProject/src/helper/Worker.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Worker implements Runnable {
    // open socket for client on svr

    // java: default access for only the same pkt

    Socket socket;

    // constructor method
    public Worker(Socket skt) {

        this.socket = skt;
    }


    @Override
    public void run() {
        try {

            // 1: open socket stream

            /*
             * socket.getOutputStream():
             *      获取Socket的输出流
             *      并使用PrintWriter进行封装
             *      以便可以方便地向网络中发送数据
             * true参数
             *      表示在向输出流写入数据时自动刷新缓冲区
             *      这样可以避免数据积累过多而导致发送不及时
             *
             */
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            /*
             * socket.getInputStream():
             *      获取Socket的输入流，
             *      使用InputStreamReader和BufferedReader进行封装
             *      以便可以方便地从网络中读取数据。
             * InputStreamReader()
             *      将字节流转换为字符流，
             *      而BufferedReader提供了缓冲功能，
             *      可以一次读取一定量的数据，提高读取效率。
             */
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // 2 implement msg for next step
            String msg = "Sign in - " + reader.readLine() + " at " + (new Date());

            System.out.println(msg);

            Thread.sleep(2000);

            // 3 return msg to client

            writer.println(msg);

            // 4 close this socket

            socket.close();


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {

                socket.close();

            } catch (Exception e) {

                e.printStackTrace();

            }
        }
    }

}
