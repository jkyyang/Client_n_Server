package src.staticInfo;

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
