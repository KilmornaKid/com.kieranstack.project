//GUI.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;


public class GUI extends JFrame  {

    private JTextField jTextField;
    private JTextField jTextField2;
    private Customer newCustomer = new Customer();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Customer> oldCustomers = new ArrayList<>();
    private static JCheckBox[] arrayOfChecks = new JCheckBox[180];
    private Seat newSeat = new Seat();
    private Movie newMovie = new Movie();


    public GUI() {
        super("Main Menu");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar newJMenu = new JMenuBar();
        JMenuItem menu2 = new JMenuItem("Register");
        JMenuItem menu3 = new JMenuItem("Admin");
        JMenuItem menu4 = new JMenuItem("Exit");



        menu2.addActionListener((ActionEvent e)->
        {
            //newCustomer.setName(JOptionPane.showInputDialog(null,"Please enter your full name:"));
            //newCustomer.setPhone(JOptionPane.showInputDialog(null,"Please enter your phone number:"));
            //newCustomer.setEmail(JOptionPane.showInputDialog(null,"Please enter your email:"));
            Customer newCustomer = new Customer();
            newCustomer.setUserName(JOptionPane.showInputDialog(null, "Please enter your username:"));
            newCustomer.setLoginPassword(JOptionPane.showInputDialog(null, "Please enter your password:"));
            JOptionPane.showMessageDialog(null, "\n" + newCustomer.toString());
            customers.add(newCustomer);
            try{
                openCustomers(customers);
            }catch (IOException  | ClassNotFoundException exs){
                JOptionPane.showMessageDialog(null, "Problem reading from file!");
            }
            /*JB added code to handle IOException possibility*/
            try {
                saveCustomers(customers);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Problem saving to file!");
            }

            JOptionPane.showMessageDialog(null, "\n" + customers);

        });




        menu4.addActionListener((ActionEvent e)->

        {
            System.exit(0);
        });


        newJMenu.add(menu2);
        newJMenu.add(menu3);
        newJMenu.add(menu4);
        add(newJMenu);


        JPanel panel1 = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon(GUI.class.getResource("Images/cinemaMain.png"))); //REFERENCE: https://stackoverflow.com/questions/13193960/swing-adding-a-image-into-gui  User: Branislav Lazic
        panel1.add(imageLabel);
        add(panel1);


        JPanel panel = new JPanel();
        add(panel);
        JLabel jLabel = new JLabel();
        jLabel.setText("Enter Username: ");
        jLabel.setVisible(true);
        panel.add(jLabel);

        jTextField = new JTextField(20);
        panel.add(jTextField);


        JPanel panel2 = new JPanel();
        add(panel2);

        JLabel jLabel2 = new JLabel();
        jLabel2.setText("Enter Password: ");
        jLabel2.setVisible(true);
        panel2.add(jLabel2);


        jTextField2 = new JTextField(20);
        panel2.add(jTextField2);

        JPanel panel3 = new JPanel();
        add(panel3);

        JButton jButton = new JButton();
        jButton.setText("Login");
        panel3.add(jButton);



            jButton.addActionListener((ActionEvent e)->
            {
                boolean found = false;
            for(Customer c : customers) {
                if (jTextField.getText().equals(c.getUserName()) && jTextField2.getText().equals(c.getLoginPassword())) {
                 found = true;
                 break;
                }

                }
                if(found == true) {
                    newJMenu.removeAll();
                    panel1.removeAll();
                    panel3.removeAll();
                    panel2.removeAll();
                    panel.removeAll();//https://stackoverflow.com/questions/31998027/jbutton-doesnt-work-at-all-after-i-dispose-existing-frame-and-sets-the-new-fram  User: Hovercraft Full Of Eels
                    GUI2();
                }else{
                    JOptionPane.showMessageDialog(null, "Please register as a user on the system");
                }
             });

    }

    //Main
    public static void main(String[] args) {

        //Main Menu Calling loginGUI which drives the rest of the program
        GUI loginGUI = new GUI();
        loginGUI.setSize(400,800);
        //loginGUI.setResizable(false);
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);
        setChecks();






    }//end of main

    public void GUI2(){
        setTitle("Select Movie");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,799);

        JPanel newPanel1 = new JPanel();
        add(newPanel1);
        JLabel headingLabel = new JLabel("<html><center><h1>Book Your Tickets Now!</h1></center></html>");
        headingLabel.setAlignmentX(CENTER_ALIGNMENT);
        newPanel1.add(headingLabel);

        JPanel newPanel2 = new JPanel();
        add(newPanel2);
        JLabel imageLabel = new JLabel(new ImageIcon(GUI.class.getResource("Images/bookTickets2.jpg"))); //REFERENCE: https://stackoverflow.com/questions/13193960/swing-adding-a-image-into-gui  User: Branislav Lazic
        newPanel2.add(imageLabel);

        JPanel newPanel3 = new JPanel();
        add(newPanel3);
        String[] movies = {"Select --Movie--","Halloween","Bohemian Rhapsody","Fantastic Beasts: The Crimes of Grindelwald","Overlord","Venom"};
        JComboBox moviesList = new JComboBox(movies);
        moviesList.setSelectedIndex(0);
        newPanel3.add(moviesList);

        JPanel newPanel4 = new JPanel();
        add(newPanel4);
        String[] times = {"Select --Time--","12:00","18:00","21:00"};
        JComboBox showingTimes = new JComboBox(times);
        showingTimes.setSelectedIndex(0);
        newPanel4.add(showingTimes);

        JPanel newPanel5 = new JPanel();
        add(newPanel5);
        JButton newJButton = new JButton("Select Seat");
        newPanel5.add(newJButton);

        newJButton.addActionListener((ActionEvent e)->
        {

            newPanel1.removeAll();
            newPanel2.removeAll();
            newPanel3.removeAll();
            newPanel4.removeAll();
            newPanel5.removeAll();
            GUI3();
        });



    }

    public void GUI3(){

        JPanel newJPanel = new JPanel();
        add(newJPanel);
        JLabel headingLabel = new JLabel("<html><center><h1>S C R E E N | S C R E E N | S C R E E N</h1></center></html>"); //https://docs.oracle.com/javase/tutorial/uiswing/components/html.html
        newJPanel.add(headingLabel);


        JPanel grid = new JPanel(new GridLayout(9,20));
        add(grid);

        for(int i = 0; i < 180; i++){
            grid.add(arrayOfChecks[i]);
        }




        JPanel newPanel2 = new JPanel();
        add(newPanel2);
        JButton newJButton = new JButton("Book Seat(s)");
        newPanel2.add(newJButton);

        newJButton.addActionListener((ActionEvent e)->
        {
            newJPanel.removeAll();
            newPanel2.removeAll();
            newJButton.removeAll();
            grid.removeAll();
            GUI2();
        });

        setTitle("Pick Seats");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,800);

    }

    public static void saveCustomers(ArrayList<Customer>customers)throws java.io.IOException{  //https://stackoverflow.com/questions/2305966/why-do-i-get-the-unhandled-exception-type-ioexception User: Marcin
        File newFile = new File("Customers.dat");
        FileOutputStream fos = new FileOutputStream(newFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(customers);
        oos.close();
    }

    public static void saveSeats(ArrayList<Customer>customers)throws java.io.IOException{  //https://stackoverflow.com/questions/2305966/why-do-i-get-the-unhandled-exception-type-ioexception User: Marcin
        File newFile = new File("Seats.dat");
        FileOutputStream fos = new FileOutputStream(newFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arrayOfChecks);
        oos.close();
    }

    public  static void openCustomers(ArrayList<Customer>customers)throws java.io.IOException, ClassNotFoundException{ //throwing exception to where method is called deal with using try/catch

        File newFile = new File("Customers.dat");
        FileInputStream fis = new FileInputStream(newFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ois.close();


    }



    public static void setChecks(){
        for (int i = 0; i<180; i++){
            arrayOfChecks[i] = new JCheckBox();
        }
    }

}




