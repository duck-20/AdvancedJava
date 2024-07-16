import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener {
    public JFrame frame;
    public JLabel l1,l2,result;
    public JTextField val1,val2;
    public JButton add,sub,mul,div;


    public Calculator(){
        frame=new JFrame("Calculator");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        l1=new JLabel("Value 1:");
        l1.setBounds(100,100,75,25);

        val1=new JTextField();
        val1.setBounds(150,100,100,25);

        l2=new JLabel("Value 2:");
        l2.setBounds(100,150,75,25);

        val2=new JTextField();
        val2.setBounds(150,150,100,25);

        result=new JLabel("Result:");
        result.setBounds(100,180,100,25);

        add=new JButton("+");
        add.setBounds(100,200,50,25);

        sub=new JButton("-");
        sub.setBounds(150,200,50,25);

        mul=new JButton("*");
        mul.setBounds(200,200,50,25);

        div=new JButton("/");
        div.setBounds(250,200,50,25);

        frame.add(l1);
        frame.add(l2);
        frame.add(val1);
        frame.add(val2);
        frame.add(result);
        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    try {
        Double firstVal = Double.parseDouble(val1.getText());
        Double secondVal = Double.parseDouble(val2.getText());
        Double res=0.0;
        switch (e.getActionCommand()){
            case "+":
                res = firstVal + secondVal;
                break;
            case "-":
                res = firstVal - secondVal;
                break;
            case "*":
                res = firstVal * secondVal;
                break;
            case "/":
                if (secondVal != 0) {
                    res = firstVal / secondVal;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                    return;
                }
                break;
        }
        result.setText("Result: " + res);
    }
    catch (Exception ex){
        System.out.println("Enter Valid Number!");
    }
    }

}