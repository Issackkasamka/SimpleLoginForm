import javax.swing.*;
import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        //import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.sql.*;
        
        

public class Register extends JFrame{

      final private Font mainFont = new Font ("segoe print",Font.BOLD,18);
      JTextField tfFirstName ,tfEmail, tfPhone,tfAddress,tfPassword;
      JLabel lbwelcome ,lbclick;

        String password;
        String name;
        String address;
        String phone;
        String email;

         // method
          public void comp(){
                         
        
                        // Form panel in north
                         
                        JLabel lbFirstName = new JLabel("Full Name");
                        lbFirstName.setFont(mainFont);
        
        
                        tfFirstName = new JTextField();
                        tfFirstName.setFont(mainFont);
        
                        JLabel lbEmail = new JLabel("Email ");
                        lbEmail.setFont(mainFont);
        
                        tfEmail = new JTextField();
                        tfEmail.setFont(mainFont);

                        JLabel lbPhone = new JLabel("Phone");
                        lbPhone.setFont(mainFont);
        
                        tfPhone = new JTextField();
                        tfPhone.setFont(mainFont);

                        JLabel lbAddress = new JLabel("Address");
                        lbAddress.setFont(mainFont);
        
                        tfAddress = new JTextField();
                        tfAddress.setFont(mainFont);
        
                        JLabel lbpassword = new JLabel("Password");
                        lbpassword.setFont(mainFont);
        
                        tfPassword = new JTextField();
                        tfPassword.setFont(mainFont);
                       
                        // Form Panel
        
                        JPanel formPanel = new JPanel();
                        formPanel.setLayout(new GridLayout(4,2,5,5));
                        formPanel.setOpaque(false);
                        formPanel.add(lbFirstName);
                        formPanel.add(tfFirstName);
                        formPanel.add(lbEmail);
                         formPanel.add(tfEmail);
                        formPanel.add(lbPhone);
                         formPanel.add(tfPhone);
                        //  formPanel.add(lbAddress);
                        // formPanel.add(tfAddress);
                        formPanel.add(lbpassword);
                        formPanel.add(tfPassword);
        
        
        
                          //Buttons Panel
                          
                           JButton Login = new JButton("Login");
                           Login.setFont(mainFont);
        
                           Login.addActionListener(new ActionListener(){
        
                            @Override

                            public void actionPerformed(ActionEvent e) {
                                
        
                              //  Login login = new Login();

                                
                                
                                
                            }
                               
                           });
        
        
        
        
                           JButton Register = new JButton("Submit");
                           Register.setFont(mainFont);
        
                           Register.addActionListener(new ActionListener(){
        
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
            
                                   
                                    
            
            
                                }catch (Exception e) {

                                    System.err.println("Got an exception!");
                                     System.err.println(e.getMessage());
                              
                                
                            }
                              }
        
                            
                           });
        
        
        
                           JPanel buttonPanel = new JPanel();
                           buttonPanel.setLayout(new GridLayout(1,2,5,5));
                           buttonPanel.setOpaque(false);
                           buttonPanel.add(Login);
                           buttonPanel.add(Register);
        
        
                       
        
        
        
                       
        
                    // Main Panel
                        JPanel mainPanel = new JPanel();
                        mainPanel.setLayout(new BorderLayout());
                        mainPanel.setBackground(new Color(205,205,252));
                        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                        mainPanel.add(formPanel,BorderLayout.NORTH);
                       
                        mainPanel.add(buttonPanel,BorderLayout.SOUTH);
                        
                      
        
                        add(mainPanel);
        
        
        
                        setTitle("Register Form");
                        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        setSize(350, 450);
                        setMinimumSize(new Dimension(350,450));
                        setLocationRelativeTo(null);
                        setVisible(true);
                   }
        
        
                   
        }
      
       


