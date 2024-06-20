package guessing_words.models;

import guessing_words.gui.GameInterface;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GamePlayer {
    private Socket playerSocket;
    private BufferedReader playerInput;
    private PrintWriter playerOutput;
    private GameInterface playerInterface;

    public GamePlayer(Socket playerSocket, BufferedReader playerInput, PrintWriter playerOutput) {
        this.playerSocket = playerSocket;
        this.playerInput = playerInput;
        this.playerOutput = playerOutput;
    }

    public BufferedReader getPlayerInput() {
        return playerInput;
    }

    public void setPlayerInput(BufferedReader playerInput) {
        this.playerInput = playerInput;
    }

    public PrintWriter getPlayerOutput() {
        return playerOutput;
    }

    public void setPlayerOutput(PrintWriter playerOutput) {
        this.playerOutput = playerOutput;
    }

    public Socket getPlayerSocket() {
        return playerSocket;
    }

    public void setPlayerSocket(Socket playerSocket) {
        this.playerSocket = playerSocket;
    }

    public GameInterface getPlayerInterface() {
        return playerInterface;
    }

    public void setPlayerInterface(GameInterface playerInterface) {
        this.playerInterface = playerInterface;
    }
}
