//GUI.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GUI extends JFrame  {

    public GUI() {
        super("Main Menu");
        setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel imageLabel = new JLabel(new ImageIcon(GUI.class.getResource("Images/cinemaMain.png"))); //REFERENCE: https://stackoverflow.com/questions/13193960/swing-adding-a-image-into-gui  User: Branislav Lazic
        add(imageLabel);

        add(panel);

        JLabel jLabel = new JLabel();
        jLabel.setText("Registration No: ");
        jLabel.setVisible(true);
        panel.add(jLabel);

        JTextField jTextField = new JTextField(20);
        panel.add(jTextField);

        JPanel panel2 = new JPanel();
        add(panel2);

        JLabel jLabel2 = new JLabel();
        jLabel2.setText("Enter Password:");
        jLabel2.setVisible(true);
        panel2.add(jLabel2);

        JTextField jTextField2 = new JTextField(20);
        panel2.add(jTextField2);

        JPanel panel3 = new JPanel();
        add(panel3);

        JButton jButton = new JButton();
        jButton.setText("Login");
        panel3.add(jButton);

        JButtonSignUp();

        jButton.addActionListener((ActionEvent e)->
        {
            jButton.removeAll(); //https://stackoverflow.com/questions/31998027/jbutton-doesnt-work-at-all-after-i-dispose-existing-frame-and-sets-the-new-fram  User: Hovercraft Full Of Eels
            GUI2();
        });




    }

    //Main
    public static void main(String[] args) {

        Customer newCustomer = new Customer();
        newCustomer.setRegistrationNumber("12345678");
        newCustomer.setLoginPassword("ebf3265");

        //Main Menu Calling loginGUI which drives the rest of the program
        GUI loginGUI = new GUI();
        loginGUI.setSize(400,760);
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);

    }//end of main

    public void GUI2(){
        setTitle("Menu2");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
    }

    public void GUI3(){
        setTitle("Menu3");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
    }


    //JButtons for Program

    public void JButtonExit(){

        setSize(400, 500);
        JButton jButton = new JButton();
        jButton.setText("Exit");
        add(jButton);
        jButton.addActionListener((ActionEvent e)->
        {
            System.exit(0);
        });
    }


    public void JButtonSignUp(){
        setSize(400, 500);
        JButton jButton = new JButton();
        jButton.setText("Sign Up");
        add(jButton);
        jButton.addActionListener((ActionEvent e)->
        {
            GUI3();
        });
    }





}




