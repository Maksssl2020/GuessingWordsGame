package guessing_words.gui;

import guessing_words.helpers.GameGuiStylingElements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EnteredWordsByPlayerWindow extends JDialog {
    private JTextArea enteredWordsTextArea;
    private JScrollPane enteredWordsScrollPane;

    public EnteredWordsByPlayerWindow(JFrame parent) {
        super(parent, "Entered Words", false);
        setSize(300, 400);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(GameGuiStylingElements.DARK_RED_COLOR_300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        enteredWordsTextArea = new JTextArea();
        enteredWordsTextArea.setEditable(false);
        enteredWordsTextArea.setBackground(GameGuiStylingElements.DARK_RED_COLOR_300);
        enteredWordsTextArea.setForeground(Color.WHITE);

        enteredWordsScrollPane = new JScrollPane(enteredWordsTextArea);
        enteredWordsScrollPane.setBounds(20, 20, 280, 360);
        enteredWordsScrollPane.setBorder(null);
        enteredWordsScrollPane.setForeground(Color.WHITE);

        add(enteredWordsScrollPane);
    }

    public void showEnteredWords(ArrayList<String> enteredWords) {
        enteredWordsTextArea.setText("");
        AtomicInteger lineCounter = new AtomicInteger();
        enteredWords.forEach(word -> {
            int wordNumber = lineCounter.incrementAndGet();
            enteredWordsTextArea.append(String.format("%d.   %s\n", wordNumber, word));
        });
    }
}
