package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BackgroundImageJFrame extends JFrame {
    JButton b1;
    JLabel l1;

    public BackgroundImageJFrame() {
        setSize(400, 400);
        setVisible(true);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\AnubisZ13\\Desktop\\Informatik\\4stars.png")));
        setLayout(new FlowLayout());
        l1 = new JLabel("Here is a button");
        b1 = new JButton("I am a button");
        add(l1);
        add(b1);
        setSize(860,540);
        setSize(860,540);
    }

    public static void main(String args[]) {
        new BackgroundImageJFrame();
    }
}
