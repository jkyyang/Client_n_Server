/*
 * @Author: jiaqiyang jkyyang@foxmail.com
 * @Date: 2023-03-29 19:27:08
 * @LastEditors: jiaqiyang jkyyang@foxmail.com
 * @LastEditTime: 2023-03-31 10:54:41
 * @FilePath: /Client_n_Server/ClientProject/src/staticInfo/SocketInfo.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package src.main.java.com.staticInfo;

public class SocketInfo {
    static String hostName = "127.0.0.1";
    static int portNumber = 12223;

    public static String getHostName() {
        return hostName;
    }

    public static int getPortNumber() {
        return portNumber;
    }
}
