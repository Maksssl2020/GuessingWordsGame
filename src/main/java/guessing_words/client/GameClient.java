package guessing_words.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient extends Thread {
    private final Integer SERVER_PORT = 1234;
    private final String SERVER_HOST = "localhost";
    private Socket clientSocket;
    private BufferedReader clientInput;
    private PrintWriter clientOutput;

    public GameClient() {
        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            clientOutput = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            String serverResponse;

            while (!clientSocket.isClosed()) {
                serverResponse = clientInput.readLine();
                if (serverResponse.contains("Game will ends for 0...")) {
                    clientSocket.close();
                    break;
                }
                clientOutput.println(serverResponse);
            }
        } catch (IOException e) {
            System.out.println("Closing client...");

            try {
                clientOutput.close();
                clientInput.close();
                clientSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
        new GameClient().start();
    }
}
