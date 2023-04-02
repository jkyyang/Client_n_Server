/*
 * @Author: jiaqiyang jkyyang@foxmail.com
 * @Date: 2023-03-29 20:01:46
 * @LastEditors: jiaqiyang jkyyang@foxmail.com
 * @LastEditTime: 2023-04-02 01:08:25
 * @FilePath: /Client_n_Server/ClientProject/src/test/ClientServer.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package src.main.java.com.Server;

import java.io.IOException;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        
        Worker myClient = new Worker();

        myClient.LaunchPad();
        // myClient.run();

    }
}
