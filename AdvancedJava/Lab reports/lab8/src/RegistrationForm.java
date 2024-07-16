import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm  extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JCheckBox agreeCheckBox;
    private JButton registerButton;
    private JPanel mainPanel;

    public RegistrationForm() {
        setTitle("RegistrationForm");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        mainPanel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(150, 30, 200, 25);
        mainPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 70, 200, 25);
        mainPanel.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(30, 110, 120, 25);
        mainPanel.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setBounds(150, 110, 200, 25);
        mainPanel.add(confirmPasswordField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 150, 80, 25);
        mainPanel.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(150, 150, 80, 25);
        mainPanel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(230, 150, 80, 25);
        mainPanel.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        agreeCheckBox = new JCheckBox("I agree to the terms and conditions.");
        agreeCheckBox.setBounds(30, 190, 320, 25);
        mainPanel.add(agreeCheckBox);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 230, 100, 30);
        mainPanel.add(registerButton);

        add(mainPanel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                } else if (!agreeCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You must agree to the terms and conditions.");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }
}
