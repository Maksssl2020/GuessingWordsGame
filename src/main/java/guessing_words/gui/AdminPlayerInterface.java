package guessing_words.gui;

import guessing_words.helpers.GameGuiStylingElements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AdminPlayerInterface extends GameInterface {
    private JLabel setWordToGuessLabel, setWordToGuessCategoryLabel, startNewRoundLabel, lookAtPlayerEnteredWordsLabel;
    private JTextField setWordToGuessField, setWordToGuessCategoryField;
    private JButton setWordToGuessButton, startNewRoundButton, lookAtPlayerEnteredWordsButton;

    public AdminPlayerInterface() {
        initComponents();
    }

    private void initComponents() {
        setWordToGuessLabel = new JLabel("Set Word To Guess");
        setWordToGuessLabel.setBounds(50, 230, 120, 25);

        setWordToGuessCategoryLabel = new JLabel("Set Word Category");
        setWordToGuessCategoryLabel.setBounds(225, 230, 120, 25);

        startNewRoundLabel = new JLabel("Start New Round");
        startNewRoundLabel.setBounds(90, 340, 100, 25);

        lookAtPlayerEnteredWordsLabel = new JLabel("Look at Player's Entered Words");
        lookAtPlayerEnteredWordsLabel.setBounds(265, 340, 200, 25);

        setWordToGuessField = new JTextField();
        setWordToGuessField.setBounds(30, 265, 150, 50);

        setWordToGuessCategoryField = new JTextField();
        setWordToGuessCategoryField.setBounds(200, 265, 150, 50);

        setWordToGuessButton = new JButton("SET WORD");
        setWordToGuessButton.setBounds(370, 265, 90, 50);

        startNewRoundButton = new JButton("START");
        startNewRoundButton.setBounds(60, 375, 150, 50);
        startNewRoundButton.setEnabled(false);

        lookAtPlayerEnteredWordsButton = new JButton("LOOK");
        lookAtPlayerEnteredWordsButton.setBounds(280, 375, 150, 50);


        for (JLabel label : new ArrayList<>(List.of(setWordToGuessLabel, setWordToGuessCategoryLabel, startNewRoundLabel, lookAtPlayerEnteredWordsLabel))) {
            label.setForeground(Color.WHITE);
            add(label);
        }

        for (JTextField textField : new ArrayList<>(List.of(setWordToGuessField, setWordToGuessCategoryField))) {
            textField.setBackground(GameGuiStylingElements.DARK_RED_COLOR_200);
            textField.setBorder(GameGuiStylingElements.ROUNDED_BORDER);
            textField.setForeground(Color.WHITE);
            textField.setHorizontalAlignment(JTextField.CENTER);
            add(textField);
        }

        for (JButton button : new ArrayList<>(List.of(setWordToGuessButton, startNewRoundButton, lookAtPlayerEnteredWordsButton))) {
            button.setBackground(GameGuiStylingElements.DARK_RED_COLOR_100);
            button.setBorder(GameGuiStylingElements.ROUNDED_BORDER);
            button.setForeground(Color.WHITE);
            button.setFocusable(false);
            add(button);
        }

        add(setWordToGuessField);
    }

    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Waiting Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void disableAllButtons() {
        setWordToGuessButton.setEnabled(false);
        startNewRoundButton.setEnabled(false);
        lookAtPlayerEnteredWordsButton.setEnabled(false);
    }

    public JButton getLookAtPlayerEnteredWordsButton() {
        return lookAtPlayerEnteredWordsButton;
    }

    public void setLookAtPlayerEnteredWordsButton(JButton lookAtPlayerEnteredWordsButton) {
        this.lookAtPlayerEnteredWordsButton = lookAtPlayerEnteredWordsButton;
    }

    public JLabel getLookAtPlayerEnteredWordsLabel() {
        return lookAtPlayerEnteredWordsLabel;
    }

    public void setLookAtPlayerEnteredWordsLabel(JLabel lookAtPlayerEnteredWordsLabel) {
        this.lookAtPlayerEnteredWordsLabel = lookAtPlayerEnteredWordsLabel;
    }

    public JButton getSetWordToGuessButton() {
        return setWordToGuessButton;
    }

    public void setSetWordToGuessButton(JButton setWordToGuessButton) {
        this.setWordToGuessButton = setWordToGuessButton;
    }

    public JTextField getSetWordToGuessCategoryField() {
        return setWordToGuessCategoryField;
    }

    public void setSetWordToGuessCategoryField(JTextField setWordToGuessCategoryField) {
        this.setWordToGuessCategoryField = setWordToGuessCategoryField;
    }

    public JLabel getSetWordToGuessCategoryLabel() {
        return setWordToGuessCategoryLabel;
    }

    public void setSetWordToGuessCategoryLabel(JLabel setWordToGuessCategoryLabel) {
        this.setWordToGuessCategoryLabel = setWordToGuessCategoryLabel;
    }

    public JTextField getSetWordToGuessField() {
        return setWordToGuessField;
    }

    public void setSetWordToGuessField(JTextField setWordToGuessField) {
        this.setWordToGuessField = setWordToGuessField;
    }

    public JLabel getSetWordToGuessLabel() {
        return setWordToGuessLabel;
    }

    public void setSetWordToGuessLabel(JLabel setWordToGuessLabel) {
        this.setWordToGuessLabel = setWordToGuessLabel;
    }

    public JButton getStartNewRoundButton() {
        return startNewRoundButton;
    }

    public void setStartNewRoundButton(JButton startNewRoundButton) {
        this.startNewRoundButton = startNewRoundButton;
    }

    public JLabel getStartNewRoundLabel() {
        return startNewRoundLabel;
    }

    public void setStartNewRoundLabel(JLabel startNewRoundLabel) {
        this.startNewRoundLabel = startNewRoundLabel;
    }

    public static void main(String[] args) {
        new AdminPlayerInterface();
    }
}
