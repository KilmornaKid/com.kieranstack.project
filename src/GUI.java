//GUI.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GUI extends JFrame  {

    public GUI() {
        super("Main Menu");
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        add(panel);

        setLayout(new FlowLayout());
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel jLabel = new JLabel();
        jLabel.setText("Registration No: ");
        jLabel.setVisible(true);
        panel.add(jLabel);

        JTextField jTextField = new JTextField(25);
        panel.add(jTextField);


        JLabel jLabel2 = new JLabel();
        jLabel2.setText("Password: ");
        jLabel2.setVisible(true);
        panel.add(jLabel2);

        JTextField jTextField2 = new JTextField(25);
        panel.add(jTextField2);


        JButtonSignUp();


        JButton jButton = new JButton();
        jButton.setText("Login");
        jButton.setBorderPainted(true);
        jButton.setBorderPainted(true);
        add(jButton);


        JButtonExit();


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
        loginGUI.setVisible(true);

    }//end of main

    public void GUI2(){
        setTitle("Menu2");
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
            System.exit(0);
        });
    }





}




