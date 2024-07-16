import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame f1=new JFrame("Area Of Circle");
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setSize(500,500);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel radius=new JLabel("Radius:");
        radius.setBounds(100,100,150,25);

        JLabel result=new JLabel();
        result.setBounds(100,200,150,25);

        JTextField value=new JTextField();
        value.setBounds(150,100,150,25);

        JButton calculate=new JButton("Calculate");
        calculate.setBounds(140,150,100,30);

        f1.add(radius);
        f1.add(value);
        f1.add(calculate);
        f1.add(result);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double data=Double.parseDouble(value.getText());
                Double calc=3.14*data*data;

                result.setText("Result: " + String.valueOf(calc));
            }
        });
    }
}