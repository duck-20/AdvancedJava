import javax.swing.*;
public class Main {
    public static void main(String[] args)
    {
        JFrame f1=new JFrame("Simple Calculator");
        f1.setVisible(true);
        f1.setSize(500,500);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel value1=new JLabel("First Value:");
        value1.setBounds(100,50,100,25);

        JLabel value2=new JLabel("Second Value:");
        value2.setBounds(100,100,100,25);

        JLabel result=new JLabel("Result:");
        result.setBounds(100,150,100,25);

        JButton calc=new JButton("Calculate");
        calc.setBounds(150,200,100,25);

        JTextField data1=new JTextField();
        data1.setBounds(200,50,100,25);

        JTextField data2=new JTextField();
        data2.setBounds(200,100,100,25);

        JTextField resultData=new JTextField();
        resultData.setBounds(200,150,100,25);

        f1.add(value1);
        f1.add(data1);
        f1.add(value2);
        f1.add(data2);
        f1.add(result);
        f1.add(resultData);
        f1.add(calc);

    }
}