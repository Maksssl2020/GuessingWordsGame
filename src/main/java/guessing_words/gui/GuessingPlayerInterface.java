package guessing_words.gui;

import guessing_words.helpers.GameGuiStylingElements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuessingPlayerInterface extends GameInterface {
    private JLabel guessTheWordLabel, lookAtYourEnteredWordsHistoryLabel;
    private JTextField guessTheWordField;
    private JButton guessTheWordButton, lookAtYourEnteredWordsHistoryButton;

    public GuessingPlayerInterface() {
        initComponents();
    }

    private void initComponents() {
        guessTheWordLabel = new JLabel("Guess The Word");
        guessTheWordLabel.setBounds(80, 225, 100, 25);
        guessTheWordLabel.setForeground(Color.WHITE);

        lookAtYourEnteredWordsHistoryLabel = new JLabel("Look At Your Entered Words History");
        lookAtYourEnteredWordsHistoryLabel.setBounds(140, 345, 225, 25);
        lookAtYourEnteredWordsHistoryLabel.setForeground(Color.WHITE);

        guessTheWordField = new JTextField();
        guessTheWordField.setBounds(30, 260, 200, 50);
        guessTheWordField.setBackground(GameGuiStylingElements.DARK_RED_COLOR_200);
        guessTheWordField.setBorder(GameGuiStylingElements.ROUNDED_BORDER);
        guessTheWordField.setForeground(Color.WHITE);
        guessTheWordField.setHorizontalAlignment(JTextField.CENTER);

        guessTheWordButton = new JButton("GUESS");
        guessTheWordButton.setBounds(305, 260, 100, 50);
        guessTheWordButton.setEnabled(false);

        lookAtYourEnteredWordsHistoryButton = new JButton("LOOK");
        lookAtYourEnteredWordsHistoryButton.setBounds(140, 380, 200, 50);

        for (JButton button : new ArrayList<>(List.of(guessTheWordButton, lookAtYourEnteredWordsHistoryButton))) {
            button.setBackground(GameGuiStylingElements.DARK_RED_COLOR_100);
            button.setBorder(GameGuiStylingElements.ROUNDED_BORDER);
            button.setForeground(Color.WHITE);
            button.setFocusable(false);
            add(button);
        }

        add(guessTheWordLabel);
        add(guessTheWordField);
        add(lookAtYourEnteredWordsHistoryLabel);
    }

    public int showConfirmationMessage(String message) {
        return JOptionPane.showConfirmDialog(this, message, "Select An Option", JOptionPane.YES_NO_OPTION);
    }

    public void disableAllButtons() {
        guessTheWordButton.setEnabled(false);
        lookAtYourEnteredWordsHistoryButton.setEnabled(false);
    }

    public JButton getGuessTheWordButton() {
        return guessTheWordButton;
    }

    public void setGuessTheWordButton(JButton guessTheWordButton) {
        this.guessTheWordButton = guessTheWordButton;
    }

    public JTextField getGuessTheWordField() {
        return guessTheWordField;
    }

    public void setGuessTheWordField(JTextField guessTheWordField) {
        this.guessTheWordField = guessTheWordField;
    }

    public JLabel getGuessTheWordLabel() {
        return guessTheWordLabel;
    }

    public void setGuessTheWordLabel(JLabel guessTheWordLabel) {
        this.guessTheWordLabel = guessTheWordLabel;
    }

    public JButton getLookAtYourEnteredWordsHistoryButton() {
        return lookAtYourEnteredWordsHistoryButton;
    }

    public void setLookAtYourEnteredWordsHistoryButton(JButton lookAtYourEnteredWordsHistoryButton) {
        this.lookAtYourEnteredWordsHistoryButton = lookAtYourEnteredWordsHistoryButton;
    }

    public JLabel getLookAtYourEnteredWordsHistoryLabel() {
        return lookAtYourEnteredWordsHistoryLabel;
    }

    public void setLookAtYourEnteredWordsHistoryLabel(JLabel lookAtYourEnteredWordsHistoryLabel) {
        this.lookAtYourEnteredWordsHistoryLabel = lookAtYourEnteredWordsHistoryLabel;
    }

    public static void main(String[] args) {
        new GuessingPlayerInterface().showConfirmationMessage("TEST");
    }
}
