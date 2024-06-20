package guessing_words.server;

import guessing_words.client.GameClientHandler;
import guessing_words.controller.GameController;
import guessing_words.helpers.Pair;
import guessing_words.models.GamePlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    public static final int PORT = 1234;
    private final ServerSocket serverSocket;
    private final List<GamePlayer> gamePlayers = new ArrayList<>();

    public GameServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startServer() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter clientOutput = new PrintWriter(clientSocket.getOutputStream(), true);

                GamePlayer gamePlayer = new GamePlayer(clientSocket, clientInput, clientOutput);
                gamePlayers.add(gamePlayer);

                if (gamePlayers.size() >= 2) {
                    Pair players = Pair.of(gamePlayers.removeFirst(), gamePlayers.removeFirst());
                    new GameController(players).start();
                }

                GameClientHandler gameClientHandler = new GameClientHandler(gamePlayer);
                gameClientHandler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new GameServer().startServer();
    }
}
