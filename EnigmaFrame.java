import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JComboBox<Integer> inner;
    private JComboBox<Integer> mid;
    private JComboBox<Integer> out;
    private JTextField start;
    private JTextArea inText;
    private JTextArea outText;
    private JButton enc;
    private JButton dec;

    public EnigmaFrame() {
        super("Enigma GUI");

        Integer[] rotors = {1, 2, 3, 4, 5};
        inner = new JComboBox<>(rotors);
        mid   = new JComboBox<>(rotors);
        out   = new JComboBox<>(rotors);

        start = new JTextField(3);
        inText = new JTextArea(5, 40);
        inText.setLineWrap(true);
        inText.setWrapStyleWord(true);
        outText = new JTextArea(5, 40);
        outText.setLineWrap(true);
        outText.setWrapStyleWord(true);
        outText.setEditable(false);

        enc = new JButton("Encrypt");
        dec = new JButton("Decrypt");

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Inner"));
        top.add(inner);
        top.add(new JLabel("Middle"));
        top.add(mid);
        top.add(new JLabel("Out"));
        top.add(out);
        top.add(new JLabel("Initial Positions"));
        top.add(start);
        top.add(enc);
        top.add(dec);

        JPanel center = new JPanel(new GridLayout(2, 1));
        JPanel inPanel = new JPanel(new BorderLayout());
        inPanel.add(new JLabel("Input"), BorderLayout.WEST);
        inPanel.add(new JScrollPane(inText), BorderLayout.CENTER);

        JPanel outPanel = new JPanel(new BorderLayout());
        outPanel.add(new JLabel("Output"), BorderLayout.WEST);
        outPanel.add(new JScrollPane(outText), BorderLayout.CENTER);
        center.add(inPanel);
        center.add(outPanel);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        enc.addActionListener(new BtnListener(true));
        dec.addActionListener(new BtnListener(false));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private class BtnListener implements ActionListener {

        private boolean doEnc;

        public BtnListener(boolean doEnc) {
            this.doEnc = doEnc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String mode = doEnc ? "encrypt" : "decrypt";
            String s = start.getText().trim();
            String m = inText.getText().trim();

            outText.setText(
                "Mode: " + mode + "\n" +
                "Start: " + s + "\n" +
                "Message: " + m + "\n" +
                "(Real Enigma will be added later.)"
            );
        }
    }
}
