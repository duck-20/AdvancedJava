import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements ActionListener {
    JFrame f1;
    JTextField display;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,minus,mul,div,zero,clear,res;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public CalculatorGUI(){
        f1=new JFrame("Calculator");
        f1.setVisible(true);
        f1.setSize(600,800);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display=new JTextField();
        display.setBounds(50,20,250,50);

        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        plus=new JButton("+");
        minus=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        clear=new JButton("C");
        zero=new JButton("0");
        res=new JButton("=");

        b1.setBounds(180,175,50,40);
        b2.setBounds(115,175,50,40);
        b3.setBounds(50,175,50,40);
        b4.setBounds(180,130,50,40);
        b5.setBounds(115,130,50,40);
        b6.setBounds(50,130,50,40);
        b7.setBounds(180,85,50,40);
        b8.setBounds(115,85,50,40);
        b9.setBounds(50,85,50,40);
        plus.setBounds(245,85,50,40);
        minus.setBounds(245,130,50,40);
        mul.setBounds(245,175,50,40);
        div.setBounds(245,225,50,40);
        res.setBounds(180,225,50,40);
        zero.setBounds(115,225,50,40);
        clear.setBounds(50,225,50,40);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clear.addActionListener(this);
        res.addActionListener(this);
        zero.addActionListener(this);

        f1.add(b1);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b5);
        f1.add(b6);
        f1.add(b7);
        f1.add(b8);
        f1.add(b9);
        f1.add(plus);
        f1.add(minus);
        f1.add(mul);
        f1.add(div);
        f1.add(clear);
        f1.add(res);
        f1.add(zero);

        f1.add(display);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            display.setText(display.getText() + command);
        } else if (command.charAt(0) == 'C') {
            display.setText("");
            num1 = num2 = result = 0;
            operator = '\0';
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));

        } else {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        }

    }
}