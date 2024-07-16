import javax.swing.*;
public class Main {
    public static void main(String[] args) {
                JFrame frame = new JFrame("Welcome Message");
                frame.setSize(500,500);
                frame.setVisible(true);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(frame,"Welcome to Java World!");

    }
}