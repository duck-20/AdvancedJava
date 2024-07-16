import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ChangePasswordProgram  extends JFrame {

    private JTextField usernameField;
    private JPasswordField newPasswordField;
    private JButton changePasswordButton;
    private JPanel mainPanel;

    public ChangePasswordProgram() {
        setTitle("Reset Password");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 30, 100, 25);
        mainPanel.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(150, 30, 200, 25);
        mainPanel.add(usernameField);

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setBounds(30, 70, 100, 25);
        mainPanel.add(newPasswordLabel);

        newPasswordField = new JPasswordField(20);
        newPasswordField.setBounds(150, 70, 200, 25);
        mainPanel.add(newPasswordField);

        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(100, 120, 200, 30);
        mainPanel.add(changePasswordButton);

        add(mainPanel);

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String newPassword = new String(newPasswordField.getPassword());

                String url = "jdbc:mysql://localhost:3306/userlogin?zeroDateTimeBehavior=convertToNull";
                String user = "root";
                String password = "";

                try {
                    Connection connection = DriverManager.getConnection(url, user, password);

                    String fetchQuery = "SELECT password FROM userlist WHERE username=?";
                    PreparedStatement fetchStmt = connection.prepareStatement(fetchQuery);
                    fetchStmt.setString(1, username);
                    ResultSet resultSet = fetchStmt.executeQuery();

                    if (resultSet.next()) {
                        String oldPassword = resultSet.getString("password");

                        String updateQuery = "UPDATE userlist SET password=? WHERE username=?";
                        PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                        updateStmt.setString(1, newPassword);
                        updateStmt.setString(2, username);
                        int rowsUpdated = updateStmt.executeUpdate();

                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "Password for user: " + username + " has been changed from \"" + oldPassword + "\" to \"" + newPassword + "\".");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update password. User not found.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "User not found.");
                    }

                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangePasswordProgram().setVisible(true);
            }
        });
    }
}
