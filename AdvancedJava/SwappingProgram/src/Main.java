//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.event.*;
public class Main {
    public static void main(String[] args) {
        JFrame f1=new JFrame("Swap");
        f1.setLayout(null);
        f1.setSize(500,500);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1=new JLabel("Value 1:");
        l1.setBounds(100,150,75,25);

        JLabel l2=new JLabel("Value 2:");
        l2.setBounds(100,200,75,25);

        JTextField t1=new JTextField();
        t1.setBounds(150,150,100,25);

        JTextField t2=new JTextField();
        t2.setBounds(150,200,100,25);

        JButton swap=new JButton("Swap");
        swap.setBounds(125,250,100,25);

        f1.add(l1);
        f1.add(l2);
        f1.add(t1);
        f1.add(t2);
        f1.add(swap);

        swap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data1= t1.getText();
                String data2= t2.getText();
                String temp="";

                temp=data1;
                data1=data2;
                data2=temp;

                t1.setText(data1);
                t2.setText(data2);

            }
        });
    }
}