import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class register extends JFrame {

     final private Font mainFont =new Font("segoe print", Font.BOLD,18);

        JTextField ltname ,ltphone, ltaddress ,ltemail,ltpassword;

        String password;
        String name;
        String address;
        String phone;
        String email;
       JLabel lbwelcome ,lbclick,lbLoginForm ;

         public void RegistrationForm(){

            lbLoginForm = new JLabel("Registration Form", SwingConstants.CENTER);
            lbLoginForm.setFont(mainFont);
    
            // Form panel in north
                         
            JLabel lbFullName = new JLabel("Full Name");
            lbFullName.setFont(mainFont);


            ltname = new JTextField();
            ltname.setFont(mainFont);


            JLabel lbEmail = new JLabel("Email");
            lbEmail.setFont(mainFont);

            ltemail = new JTextField();
            ltemail.setFont(mainFont);

            JLabel lbPhone = new JLabel("Phone");
            lbPhone.setFont(mainFont);

            ltphone = new JTextField();
            ltphone.setFont(mainFont);

            JLabel lbAddress = new JLabel("Address");
            lbAddress.setFont(mainFont);

            ltaddress = new JTextField();
            ltaddress.setFont(mainFont);

            JLabel lbPassword  = new JLabel("Password");
            lbPassword .setFont(mainFont);

            ltpassword  = new JPasswordField();
            ltpassword .setFont(mainFont);


            

           
            // Form Panel   

            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(4,2,5,5));
            formPanel.setOpaque(false);
            formPanel.add(lbFullName);
            formPanel.add(ltname);
            formPanel.add(lbEmail);
            formPanel.add(ltemail);
            formPanel.add(lbPhone);
            formPanel.add(ltphone);
            formPanel.add(lbAddress);
            formPanel.add(ltaddress);
            formPanel.add(lbPassword);
            formPanel.add(ltpassword);
                        

           // button 
              JButton Submit = new JButton("Submit");
              Submit.setFont(mainFont);

              Submit.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent arg0) {

                    final String DB_URL  = "jdbc:mysql://localhost:3306/Album";
                    final String USERNAME = "root";
                    final  String PASSWORD = "root";

                    try {
                        
                        Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

                        String sql = "INSERT INTO Watumiaji(name,email,phone,address,password) VALUES(?,?,?,?,?) WHERE email =? AND password=?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, email);
                        preparedStatement.setString(3, phone);
                        preparedStatement.setString(4, address);
                        preparedStatement.setString(5, password);

                       conn.close();

                       
                        


                    } catch (Exception e) {
                       

                        System.err.println("Got an exception!");
                       System.err.println(e.getMessage());
                    }
                    
                }

                
              });


              JPanel buttonPanel = new JPanel();
              buttonPanel.setLayout(new GridLayout(1,2,5,5));
              buttonPanel.setOpaque(false);
              buttonPanel.add(Submit);



                    // Main Panel
                    JPanel mainPanel = new JPanel();
                    mainPanel.setLayout(new BorderLayout());
                    mainPanel.setBackground(new Color(205,205,252));
                    mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                    mainPanel.add(formPanel,BorderLayout.NORTH);                  
                    mainPanel.add( buttonPanel,BorderLayout.SOUTH);


                    
                  
    
                    add(mainPanel);
    
    
    
                    

                    setTitle("Register Form");
                    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    setSize(350, 450);
                    setMinimumSize(new Dimension(350,450));
                    setLocationRelativeTo(null);
                    setVisible(true);
    
            



         }
}
