import javax.swing.*;
import java.awt.event.*;
public class Main {
    public static void main(String[] args) {
        JFrame f1=new JFrame("Swap");
        f1.setLayout(null);
        f1.setSize(500,500);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b1=new JButton("Robina");
        b1.setBounds(100,150,100,25);

        JButton b2=new JButton("Shahi");
        b2.setBounds(250,150,100,25);

        JButton swap=new JButton("Swap");
        swap.setBounds(175,200,100,25);

        f1.add(b1);
        f1.add(b2);
        f1.add(swap);

        swap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data1= b1.getText();
                String data2= b2.getText();
                String temp="";

                temp=data1;
                data1=data2;
                data2=temp;

                b1.setText(data1);
                b2.setText(data2);

            }
        });
    }
}