import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBLogin extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel mainPanel;

    public DBLogin() {
        setTitle("Login Form");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        mainPanel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(120, 30, 185, 25);
        mainPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(120, 70, 185, 25);
        mainPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(30, 110, 275, 30);
        mainPanel.add(loginButton);

        add(mainPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "");
                    String query = "SELECT * FROM userlist WHERE username=? AND password=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, usernameField.getText());
                    preparedStatement.setString(2, new String(passwordField.getPassword()));
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "Login successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password.");
                    }

                    connection.close();
                } catch (Exception ex) {
                    System.out.println("Error");;
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DBLogin().setVisible(true);
            }
        });
    }
}