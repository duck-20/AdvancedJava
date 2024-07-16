import javax.swing.*;
public class Main {
    public static void main(String[] args)
    {

        //Created a Frame
        JFrame f1= new JFrame("Demo");
        f1.setVisible(true);
        f1.setSize(500,500);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating Label
        JLabel l1=new JLabel("Hello World");
        l1.setBounds(200,200,50,25);

        //Adding JLabel in the frame
        f1.add(l1);


    }
}