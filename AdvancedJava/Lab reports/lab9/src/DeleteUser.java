import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DeleteUser extends JFrame {
    private JTextField usernameField;
    private JButton deleteButton;
    private JPanel mainPanel;
    public DeleteUser() {
        setTitle("Delete a user");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        JLabel usernameLabel = new JLabel("username:");
        usernameLabel.setBounds(30, 30, 100, 25);
        mainPanel.add(usernameLabel);
        usernameField = new JTextField(20);
        usernameField.setBounds(150, 30, 200, 25);
        mainPanel.add(usernameField);

        deleteButton = new JButton("Delete User");
        deleteButton.setBounds(100, 70, 200, 30);
        mainPanel.add(deleteButton);
        add(mainPanel);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();

                String url = "jdbc:mysql://localhost:3306/userlogin?zeroDateTimeBehavior=convertToNull";
                String user = "root";
                String password = "";

                try {
                    Connection connection = DriverManager.getConnection(url, user, password);
                    String deleteQuery = "DELETE FROM userlist WHERE username=?";
                    PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
                    deleteStmt.setString(1, username);
                    int rowsDeleted = deleteStmt.executeUpdate();

                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "User " + username + " has been deleted.");
                    } else {
                        JOptionPane.showMessageDialog(null, "User not found.");
                    }

                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error occurred while deleting user.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DeleteUser().setVisible(true);
            }
        });
    }
}
