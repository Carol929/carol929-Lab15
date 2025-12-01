import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EnigmaFrame extends JFrame {

    private JComboBox<Integer> innerBox;
    private JComboBox<Integer> middleBox;
    private JComboBox<Integer> outerBox;
    private JTextField startField;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton encryptButton;
    private JButton decryptButton;

    public EnigmaFrame() {
        super("Enigma GUI");

        JLabel label = new JLabel("Enigma GUI");
        add(label, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

}
