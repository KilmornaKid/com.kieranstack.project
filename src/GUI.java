//Kieran Stack          Date:26/11/2018
//GUI.java


//Necessary Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class GUI extends JFrame  {

    private JTextField jTextField;
    private JTextField jTextField2;
    private String AdminUN = "Kieran S";
    private String AdminPass = "12345";
    private Price adultPrice = new Price();
    private Price studentPrice = new Price();
    private Price childPrice = new Price();
    private static Seat newSeat = new Seat();
    private static ArrayList<Seat> arrayListOfSeats = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Movie> arrayListOfMovies = new ArrayList<>();
    private static List<JCheckBox> booked = new ArrayList<>();
    private static JCheckBox[] arrayOfChecks = new JCheckBox[180];


    public GUI() {
        super("Main Menu");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar newJMenu = new JMenuBar();
        JMenuItem menu2 = new JMenuItem("Register");
        JMenuItem menu3 = new JMenuItem("Admin");
        JMenuItem menu4 = new JMenuItem("Exit");



        //User Registration Functionality
        menu2.addActionListener((ActionEvent e)->
        {
            Customer newCustomer = new Customer();
            newCustomer.setName(JOptionPane.showInputDialog(null,"Please enter your full name:"));
            newCustomer.setPhone(JOptionPane.showInputDialog(null,"Please enter your phone number:"));
            newCustomer.setEmail(JOptionPane.showInputDialog(null,"Please enter your email:"));
            newCustomer.setUserName(JOptionPane.showInputDialog(null, "Please enter your username:"));
            newCustomer.setLoginPassword(JOptionPane.showInputDialog(null, "Please enter your password:"));
            JOptionPane.showMessageDialog(null, "\n" + newCustomer.toString());
            customers.add(newCustomer);
            /*JB added code to handle IOException possibility*/
            try {
                saveCustomers(customers);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Problem saving to file!");
            }
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

        //User Login Functionality
        menu3.addActionListener((ActionEvent e)->
        {
            Admin newAdmin;
            newAdmin = new Admin();
            newAdmin.setAdminName(JOptionPane.showInputDialog(null,"Please enter admin user name (Kieran S)"));
            newAdmin.setAdminPassword(JOptionPane.showInputDialog(null,"Please enter admin password (12345)"));

                if(newAdmin.getAdminName().equals(AdminUN) && newAdmin.getAdminPassword().equals(AdminPass)){
                    newJMenu.removeAll();
                    panel1.removeAll();
                    panel3.removeAll();
                    panel2.removeAll();
                    panel.removeAll();
                    GUI4();
                }else{
                    JOptionPane.showMessageDialog(null,"Sorry you do not have the correct details entered");
                }



        });


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

        Customer newCustomer = new Customer();
        try{
            openCustomers(customers);
        }catch (IOException  | ClassNotFoundException exs){
            JOptionPane.showMessageDialog(null, "Problem reading customers from file!");
        }
        customers.add(newCustomer);





        //Main Menu Calling GUI which drives the rest of the program
        GUI loginGUI = new GUI();
        loginGUI.setSize(400,800);
        //loginGUI.setResizable(false);
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);
        setChecks();



    }//end of main


    //Select Movie GUI
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
        String[] movies = {"Select ---Movie---","HALLOWEEN (2018)","THE GRINCH (2018)","BOHEMIAN RHAPSODY","FANTASTIC BEASTS: THE CRIMES OF GRINDELWALD"};
        JComboBox moviesList = new JComboBox(movies);
        newPanel3.add(moviesList);

        JPanel newPanel4 = new JPanel();
        add(newPanel4);
        String[] times = {"Select --Time--","12:00","18:00","21:00","22:00"};
        JComboBox showingTimes = new JComboBox(times);
        showingTimes.setSelectedIndex(0);
        newPanel4.add(showingTimes);




        JPanel newPanel5 = new JPanel();
        add(newPanel5);
        JButton newJButton = new JButton("Select Seat");
        newPanel5.add(newJButton);

        JPanel newPanel6 = new JPanel();
        add(newPanel6);
        JButton newJButton2 = new JButton("Booked Tickets");
        newPanel6.add(newJButton2);


        newJButton2.addActionListener((ActionEvent e)-> {
            JOptionPane.showMessageDialog(null,"You have booked " + (newSeat.getSeatNo()+1) + " tickets");
        });


        newJButton.addActionListener((ActionEvent e)->
        {
            newPanel1.removeAll();
            newPanel2.removeAll();
            newPanel3.removeAll();
            newPanel4.removeAll();
            newPanel5.removeAll();
            newPanel6.removeAll();
            GUI3();
        });
    }


    //Select Seat GUI
    public void GUI3(){



        JPanel newJPanel = new JPanel();
        add(newJPanel);
        JLabel headingLabel = new JLabel("<html><center><h1>S C R E E N | S C R E E N 1 | S C R E E N</h1></center></html>"); //https://docs.oracle.com/javase/tutorial/uiswing/components/html.html
        newJPanel.add(headingLabel);

        try{
            openSeats(arrayOfChecks);
        }catch (IOException | ClassNotFoundException exes){
            JOptionPane.showMessageDialog(null, "Problem reading from file!");
        }


        JPanel grid = new JPanel(new GridLayout(9,20));
        add(grid);
        for(int i = 0; i < 180; i++){
            int seatCounter = 0;
            grid.add(arrayOfChecks[i]);
            for(JCheckBox jc: arrayOfChecks){
                if(jc.isSelected()){
                    newSeat.setSeatNo(seatCounter);
                    newSeat.setSeatsAvailable(false);
                    arrayListOfSeats.add(newSeat);
                    seatCounter++;
                    jc.setEnabled(false);
                }
            }
        }


        JPanel newPanel2 = new JPanel();
        add(newPanel2);
        JButton newJButton = new JButton("Book Seat(s)");
        newPanel2.add(newJButton);



        newJButton.addActionListener((ActionEvent e)->
        {


            try {
                saveSeats(arrayOfChecks);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Problem saving to file!");
            }

            for(Seat s: arrayListOfSeats){
                if(!newSeat.isSeatsAvailable()){
                    adultPrice.setAdultPrice(8.00);
                    double bookingPrice;
                    bookingPrice = (newSeat.getSeatNo()+1)*adultPrice.getAdultPrice();
                    JOptionPane.showMessageDialog(null,"The amount due for your booked tickets is " + String.format("%.2f",bookingPrice) + " euro");
                    s.setSeatsAvailable(true);
                }

            }

            grid.removeAll();
            newJPanel.removeAll();
            newPanel2.removeAll();
            GUI2();


        });

        setTitle("Pick Seats");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,800);

    }


    //Admin GUI
    public void GUI4(){

        JPanel panel1 = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon(GUI.class.getResource("Images/admin4.jpg"))); //REFERENCE: https://stackoverflow.com/questions/13193960/swing-adding-a-image-into-gui  User: Branislav Lazic
        panel1.add(imageLabel);
        add(panel1);

        JPanel newPanel = new JPanel();
        add(newPanel);
        JButton newJButton = new JButton("Add Movies");
        newPanel.add(newJButton);

        JPanel newPanel2 = new JPanel();
        add(newPanel2);
        JButton newJButton1 = new JButton("Exit");
        newPanel2.add(newJButton1);

        newJButton1.addActionListener((ActionEvent e)-> {
            System.exit(0);
        });


        newJButton.addActionListener((ActionEvent e)->
        {
            newPanel.removeAll();
            panel1.removeAll();
            newPanel2.removeAll();
            GUI5();
        });







        setTitle("Admin Login");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(401,801);

    }

    //Admin Menu Continued...
    public void GUI5(){

        JPanel panel1 = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon(GUI.class.getResource("Images/admin2.png"))); //REFERENCE: https://stackoverflow.com/questions/13193960/swing-adding-a-image-into-gui  User: Branislav Lazic
        panel1.add(imageLabel);
        add(panel1);

        JPanel newPanel = new JPanel();
        add(newPanel);
        JButton newJButton = new JButton("Add Movie");
        newPanel.add(newJButton);

        newJButton.addActionListener((ActionEvent e)->
        {

            Movie newMovie = new Movie();
            newMovie.setName(JOptionPane.showInputDialog(null, "Please enter the name of the film"));
            newMovie.setDuration(Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the duration of the film (in minutes approx:)")));
            newMovie.setAgeRating(JOptionPane.showInputDialog(null,"Please enter the age rating of the film"));
            try{
                openMovies(arrayListOfMovies);
            }catch (IOException | ClassNotFoundException exs){
                JOptionPane.showMessageDialog(null,"Problem reading from file");
            }
            arrayListOfMovies.add(newMovie);
            try {
                saveMovies(arrayListOfMovies);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Problem saving to file!");
            }

            JOptionPane.showMessageDialog(null,arrayListOfMovies);



        });



        JPanel panel2 = new JPanel();
        add(panel2);
        JButton newJButton1 = new JButton("Add Screening Time");
        panel2.add(newJButton1);

        JPanel panel3 = new JPanel();
        add(panel3);
        JButton newJButton3 = new JButton("Exit");
        panel3.add(newJButton3);

        newJButton3.addActionListener((ActionEvent e)->
        {
            newPanel.removeAll();
            panel1.removeAll();
            panel2.removeAll();
            panel3.removeAll();//https://stackoverflow.com/questions/31998027/jbutton-doesnt-work-at-all-after-i-dispose-existing-frame-and-sets-the-new-fram  User: Hovercraft Full Of Eels
            GUI4();

        });


        setTitle("Admin Options");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,802);
    }

    //Persistence methods...

    public static void saveCustomers(ArrayList<Customer>customers)throws java.io.IOException{  //https://stackoverflow.com/questions/2305966/why-do-i-get-the-unhandled-exception-type-ioexception User: Marcin
        File newFile = new File("Customers.dat");
        FileOutputStream fos = new FileOutputStream(newFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(customers);
        oos.close();
    }


    public  static void openCustomers(ArrayList<Customer>customers1)throws java.io.IOException, ClassNotFoundException{ //throwing exception to where method is called deal with using try/catch

        File newFile = new File("Customers.dat");
        FileInputStream fis = new FileInputStream(newFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        customers = (ArrayList<Customer>) ois.readObject();
        ois.close();
    }

    public  static void saveMovies(ArrayList<Movie>arrayListOfMovies)throws java.io.IOException{
        File newFile = new File("Movies.dat");
        FileOutputStream fos = new FileOutputStream(newFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arrayListOfMovies);
        oos.close();
    }

    public static void openMovies(ArrayList<Movie>arrayListOfMovies1)throws java.io.IOException, ClassNotFoundException{
        File newFile = new File("Movies.dat");
        FileInputStream fis = new FileInputStream(newFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        arrayListOfMovies = (ArrayList<Movie>) ois.readObject();
        ois.close();
    }




    public static void saveSeats(JCheckBox[] arrayOfChecks)throws java.io.IOException{  //https://stackoverflow.com/questions/2305966/why-do-i-get-the-unhandled-exception-type-ioexception User: Marcin
        File newFile = new File("BookedSeats.dat");
        FileOutputStream fos = new FileOutputStream(newFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arrayOfChecks);
        oos.close();
    }

    public static void openSeats(JCheckBox[] arrayOfChecks1)throws java.io.IOException, ClassNotFoundException{
        File newFile = new File("BookedSeats.dat");
        FileInputStream fis = new FileInputStream(newFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        arrayOfChecks = (JCheckBox[])ois.readObject();
        ois.close();
    }



    public static void setChecks(){
        for (int i = 0; i<180; i++){
            arrayOfChecks[i] = new JCheckBox();


        }


    }

}




