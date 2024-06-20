package guessing_words.gui;

import guessing_words.helpers.GameGuiStylingElements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameInterface extends JFrame {
    private JLabel wordToGuessLabel, wordToGuessCategoryLabel, gameMessagesLabel;
    private JTextField wordToGuessField, wordToGuessCategoryField, gameMessagesField;

    public GameInterface() {
        super("Guessing Words Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(GameGuiStylingElements.DARK_RED_COLOR_300);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        wordToGuessLabel = new JLabel("Word To Guess");
        wordToGuessLabel.setBounds(90, 20, 100, 25);

        wordToGuessCategoryLabel = new JLabel("Word Category");
        wordToGuessCategoryLabel.setBounds(325, 20, 100, 25);

        gameMessagesLabel = new JLabel("Game Messages");
        gameMessagesLabel.setBounds(195, 125, 100, 25);

        for (JLabel label : new ArrayList<>(List.of(wordToGuessLabel, wordToGuessCategoryLabel, gameMessagesLabel))) {
            label.setForeground(Color.WHITE);
            add(label);
        }

        wordToGuessField = new JTextField();
        wordToGuessField.setBounds(30, 50, 200, 50);

        wordToGuessCategoryField = new JTextField();
        wordToGuessCategoryField.setBounds(260, 50, 200, 50);

        gameMessagesField = new JTextField();
        gameMessagesField.setBounds(30, 155, 430, 50);


        for (JTextField textField : new ArrayList<>(List.of(wordToGuessField, wordToGuessCategoryField, gameMessagesField))) {
            textField.setBackground(GameGuiStylingElements.DARK_RED_COLOR_200);
            textField.setBorder(GameGuiStylingElements.ROUNDED_BORDER);
            textField.setForeground(Color.WHITE);
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setEditable(false);
            textField.setFocusable(false);
            add(textField);
        }
    }

    public void sendMessageToPlayer(String message) {
        gameMessagesField.setText(message);
    }

    public void clearMessagesField() {
        gameMessagesField.setText("");
    }

    public JTextField getGameMessagesField() {
        return gameMessagesField;
    }

    public void setGameMessagesField(JTextField gameMessagesField) {
        this.gameMessagesField = gameMessagesField;
    }

    public JLabel getGameMessagesLabel() {
        return gameMessagesLabel;
    }

    public void setGameMessagesLabel(JLabel gameMessagesLabel) {
        this.gameMessagesLabel = gameMessagesLabel;
    }

    public JTextField getWordToGuessCategoryField() {
        return wordToGuessCategoryField;
    }

    public void setWordToGuessCategoryField(JTextField wordToGuessCategoryField) {
        this.wordToGuessCategoryField = wordToGuessCategoryField;
    }

    public JLabel getWordToGuessCategoryLabel() {
        return wordToGuessCategoryLabel;
    }

    public void setWordToGuessCategoryLabel(JLabel wordToGuessCategoryLabel) {
        this.wordToGuessCategoryLabel = wordToGuessCategoryLabel;
    }

    public JTextField getWordToGuessField() {
        return wordToGuessField;
    }

    public void setWordToGuessField(JTextField wordToGuessField) {
        this.wordToGuessField = wordToGuessField;
    }

    public JLabel getWordToGuessLabel() {
        return wordToGuessLabel;
    }

    public void setWordToGuessLabel(JLabel wordToGuessLabel) {
        this.wordToGuessLabel = wordToGuessLabel;
    }

    public static void main(String[] args) {
        new GameInterface();
    }
}
