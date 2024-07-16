import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args) {
        JFrame f1 = new JFrame("Simple Addition");
        f1.setSize(300, 250);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(null);
        f1.setVisible(true);
        JLabel labelnum1 = new JLabel("Value 1:");
        labelnum1.setBounds(30, 30, 80, 30);
        f1.add(labelnum1);
        JTextField num1 = new JTextField();
        num1.setBounds(110, 30, 100, 30);
        f1.add(num1);
        JLabel labelnum2 = new JLabel("Value 2:");
        labelnum2.setBounds(30, 70, 80, 30);
        f1.add(labelnum2);
        JTextField num2 = new JTextField();
        num2.setBounds(110, 70, 100, 30);
        f1.add(num2);
        JButton add = new JButton("Add");
        add.setBounds(110, 110, 100, 30);
        f1.add(add);
        JLabel result = new JLabel("Result:");
        result.setBounds(30, 150, 200, 30);
        f1.add(result);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int val1 = Integer.parseInt(num1.getText());
                    int val2 = Integer.parseInt(num1.getText());
                    int sum = val1 + val2;
                    result.setText("Result: " + sum);
                } catch (NumberFormatException ex) {
                    result.setText("Please enter valid integers.");
                }
            }
        });
    }
}
