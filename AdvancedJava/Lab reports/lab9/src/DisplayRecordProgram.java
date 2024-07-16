import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayRecordProgram extends JFrame {

    public  JTable table;
    public DefaultTableModel tableModel;

    public DisplayRecordProgram() {
        setTitle("Display Records");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Username", "Password"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(scrollPane);

        add(mainPanel);

        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/userlogin?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM userlist";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String passwords = resultSet.getString("password");
                tableModel.addRow(new Object[]{username, passwords});
            }

            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisplayRecordProgram().setVisible(true);
            }
        });
    }
}
