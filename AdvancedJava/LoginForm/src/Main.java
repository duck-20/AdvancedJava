import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame f1=new JFrame("Login");
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(600,400);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1=new JLabel("Login");
        l1.setBounds(250,25,100,75);

        JLabel userName=new JLabel("UserName");
        userName.setBounds(100,100,75,25);

        JTextField userField=new JTextField();
        userField.setBounds(175,100,200,25);

        JLabel passWord=new JLabel("Password");
        passWord.setBounds(100,150,75,25);

        JTextField pass=new JPasswordField();
        pass.setBounds(175,150,200,25);

        JButton login=new JButton("Login");
        login.setBounds(220,200,100,30);

        f1.add(l1);
        f1.add(userName);
        f1.add(userField);
        f1.add(passWord);
        f1.add(pass);
        f1.add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userData=userField.getText();
                String userPassword=String.valueOf(pass.getText());

                if(userData.equals("Duck") && userPassword.equals("123")){
                    JOptionPane.showMessageDialog(f1,"Login Successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(f1,"Invalid Credentials!");
                }
            }
        });
    }
}