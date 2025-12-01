import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JComboBox<String> inner;
    private JComboBox<String> mid;
    private JComboBox<String> out;
    private JTextField start;
    private JTextArea inText;
    private JTextArea outText;
    private JButton enc;
    private JButton dec;

    public EnigmaFrame() {
        super();

        setTitle("Enigma GUI");

        String[] rotorNames = { "1", "2", "3", "4", "5" };
        inner = new JComboBox<String>(rotorNames);
        mid = new JComboBox<String>(rotorNames);
        out = new JComboBox<String>(rotorNames);

        start = new JTextField(3);
        inText = new JTextArea(5, 30);
        outText = new JTextArea(5, 30);
        outText.setEditable(false);

        enc = new JButton("Encrypt");
        dec = new JButton("Decrypt");

        JPanel top = new JPanel(new FlowLayout());

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

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel inPanel = new JPanel();
        inPanel.setLayout(new BorderLayout());
        inPanel.add(new JLabel("Input"), BorderLayout.NORTH);
        inPanel.add(inText, BorderLayout.CENTER);

        JPanel outPanel = new JPanel();
        outPanel.setLayout(new BorderLayout());
        outPanel.add(new JLabel("Output"), BorderLayout.NORTH);
        outPanel.add(outText, BorderLayout.CENTER);
        center.add(inPanel, BorderLayout.NORTH);
        center.add(outPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        enc.addActionListener(new BtnListener(true));
        dec.addActionListener(new BtnListener(false));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private class BtnListener implements ActionListener {

        private boolean doEnc;

        public BtnListener(boolean doEnc) {
            this.doEnc = doEnc;
        }

        public void actionPerformed(ActionEvent e) {
            String s = start.getText();

            if (s.length() != 3) {
                outText.setText("Error: Initial positions must be 3 characters, e.g. EST.");
                return;
            }

            int r1 = inner.getSelectedIndex() + 1; 
            int r2 = mid.getSelectedIndex() + 1;
            int r3 = out.getSelectedIndex() + 1;

            String msg = inText.getText();
            if (msg.length() == 0) {
                outText.setText("");
                return;
            }

            String[] args = new String[6];
            args[0] = Integer.toString(r1);   // inner rotor id
            args[1] = Integer.toString(r2);   // middle rotor id
            args[2] = Integer.toString(r3);   // outer rotor id
            args[3] = s;                      // starting positions
            args[4] = doEnc ? "encrypt" : "decrypt";
            args[5] = msg;                    // message

            String res = Comms.run(args);
            outText.setText(res);
        }
    }
}
