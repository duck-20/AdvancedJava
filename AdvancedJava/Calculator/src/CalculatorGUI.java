import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements ActionListener {
    JFrame f1;
    JLabel l1,l2,result;
    JTextField t1,t2;
    JButton b1,b2,b3,b4;

    public CalculatorGUI(){
        f1=new JFrame("Calculator");
        f1.setSize(500,500);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1=new JLabel("Value a: ");
        l1.setBounds(100,100,50,25);

        l2=new JLabel("Value b: ");
        l2.setBounds(100,150,50,25);

        t1=new JTextField();
        t1.setBounds(150,100,100,25);

        t2=new JTextField();
        t2.setBounds(150,150,100,25);

        b1=new JButton("+");
        b1.setBounds(100,200,45,25);

        b2=new JButton("-");
        b2.setBounds(150,200,45,25);

        b3=new JButton("*");
        b3.setBounds(200,200,45,25);

        b4=new JButton("/");
        b4.setBounds(250,200,45,25);

        result=new JLabel();
        result.setBounds(150,250,200,25);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        f1.add(l1);
        f1.add(l2);
        f1.add(t1);
        f1.add(t2);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(result);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            Double data1=Double.parseDouble(t1.getText());
            Double data2=Double.parseDouble(t2.getText());
            Double res=data1+ data2;
            result.setText("Result: "+ String.valueOf(res));
        }
        else if(e.getSource()==b2){
            Double data1=Double.parseDouble(t1.getText());
            Double data2=Double.parseDouble(t2.getText());
            Double res=data1- data2;
            result.setText("Result: "+ String.valueOf(res));
        }
        else if(e.getSource()==b3){
            Double data1=Double.parseDouble(t1.getText());
            Double data2=Double.parseDouble(t2.getText());
            Double res=data1*data2;
            result.setText("Result: "+ String.valueOf(res));
        }
        else if(e.getSource()==b4){
            Double data1=Double.parseDouble(t1.getText());
            Double data2=Double.parseDouble(t2.getText());
            Double res=data1/ data2;
            result.setText("Result: "+ String.valueOf(res));
        }
        else{
            result.setText("Enter Valid Number!");
        }
    }
}
