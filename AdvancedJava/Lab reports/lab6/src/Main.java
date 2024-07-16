import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame f1 = new JFrame("Thumbnails");
        f1.setLayout(null);
        f1.setSize(1000, 1000);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon img1 = new ImageIcon("C:\\Users\\pakhr\\Desktop\\6th sem\\AdvancedJava\\Lab reports\\lab6\\RubyImages\\img1.jpg");
        ImageIcon img2 = new ImageIcon("C:\\Users\\pakhr\\Desktop\\6th sem\\AdvancedJava\\Lab reports\\lab6\\RubyImages\\img2.jpg");
        ImageIcon img3 = new ImageIcon("C:\\Users\\pakhr\\Desktop\\6th sem\\AdvancedJava\\Lab reports\\lab6\\RubyImages\\img3.jpg");
        ImageIcon img4 = new ImageIcon("C:\\Users\\pakhr\\Desktop\\6th sem\\AdvancedJava\\Lab reports\\lab6\\RubyImages\\img4.jpg");
        JButton b1 = new JButton(img1);
        JButton b2 = new JButton(img2);
        JButton b3 = new JButton(img3);
        JButton b4 = new JButton(img4);


        b1.setBounds(0, 200, 400, 300);
        b2.setBounds(400, 200, 400, 300);
        b3.setBounds(0, 400, 400, 300);
        b4.setBounds(400, 400, 400, 300);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayZoomedImage(img1);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayZoomedImage(img2);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayZoomedImage(img3);
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayZoomedImage(img4);
            }
        });

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
    }
    public static void displayZoomedImage(ImageIcon icon) {
        JFrame f2 = new JFrame("Zoomed Image");
        f2.setSize(800, 800);
        JLabel l2 = new JLabel(icon);
        f2.add(l2);
        f2.setVisible(true);
    }
}
