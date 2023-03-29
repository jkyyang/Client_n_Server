package src.test;

import src.main.Client;

import java.io.IOException;

public class ClientTest {
    public static void main(String[] args) throws IOException {

        Client myClient = new Client();

        try {
            myClient.run();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
