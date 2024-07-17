/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author lenovo
 */
public class windows1 extends JFrame  {
    private final int WINDOW_WIDTH=950;
    private final int WINDOW_HEIGHT=450;
    private JLabel pic; 
    private JLabel message2;
    private JLabel welcomLabel;
    private JLabel errorLabel;
    private JLabel message4;
    private JTextField text;
    private JPasswordField text2;
    private JButton log;
    private JButton signUp;
    private JCheckBox checkBox; 
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private ImageIcon image;
    private JLabel messageError;
    public static String Name;
    public static String id;
    Font customFont = new Font("Arial", Font.BOLD, 16);
    
    
    public windows1() {
        
       setTitle("University Library");
       setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout(10,10));
       
      
       welcomLabel=new JLabel("Welcom to Jeddah university Library");
       message2=new JLabel("Enter ID Number: ");
       message4=new JLabel("Enter passward: ");
       text= new JTextField(12);
       text2= new JPasswordField(12);
       log=new JButton("Log in");
       signUp= new JButton("signUp");
       errorLabel=new JLabel("*");
       image = new ImageIcon(getClass().getResource("image.JPG"));
       
       welcomLabel.setFont(customFont);
       message2.setFont(customFont);
       message4.setFont(customFont);
       log.setFont(customFont);
       signUp.setFont(customFont);
       
       pic= new JLabel(image);
       checkBox=new JCheckBox("show passworad",false);
       messageError=new JLabel("You are not regested in the system before.");
       messageError.setVisible(false);
       
       checkBox.addActionListener(new checkBoxListener());
        buildPanel();
       
       add(p1, BorderLayout.EAST);
       add(p2, BorderLayout.CENTER);
       setLocationRelativeTo(null);
       setResizable(false);
       setVisible(true);    
    }
    
    public static String getString(){
        return Name;
    }
    public static String getId(){
        return id;
    }
    
    public void buildPanel(){
       p1=new JPanel(); //for picture
       p2=new JPanel(); //for all panels
       p3=new JPanel(); //for North panel
       p4=new JPanel(); //for Center panel
       p5=new JPanel(); //for South Panel
  
       p1.add(pic);  //
       p3.add(welcomLabel);
       p4.setLayout(new GridLayout(4,2,5,5));
       
       p4.add(message2);
       p4.add(text);
       p4.add(message4 );
       p4.add(text2 );
       p4.add(checkBox);
       p4.add(messageError);
       p4.add(errorLabel);
       
       p5.add(log );
       p5.add(signUp);
       
       log.addActionListener(new logInListener());
       signUp.addActionListener(new signUpListener());
       
       p2.add(p3,BorderLayout.NORTH);
       p2.add(p4,BorderLayout.CENTER);
       p2.add(p5,BorderLayout.SOUTH);
    
}
  private class checkBoxListener implements ActionListener{
      
      public void actionPerformed(ActionEvent e){
          if(checkBox.isSelected()){
              text2.setEchoChar((char)0);
          }
          else{
               text2.setEchoChar('*');
          }
      }
  }
  
  
   private class logInListener implements ActionListener{

      public void actionPerformed(ActionEvent e){
          
            String user_ID=text.getText();
            String user_password=text2.getText();
            
            if(user_ID.isEmpty()){
                errorLabel.setText("Please enter ID ");
            }
            else if(user_password.isEmpty()){
                errorLabel.setText("Please enter password ");
            }
            else{
                String name="";
                    try {
                        File file = new File("userInfo.txt");
                        Scanner inputFile= new Scanner(file);
                         boolean flag=false;
                       
                         while(inputFile.hasNext()){
                              name=inputFile.next();
                              String userID=inputFile.next();
                              if(userID.equals(user_ID)){
                                  String pass=inputFile.next();
                                  if(user_password.equals(pass)){
                                      flag=true;
                                      break;
                                  }
                              }
                             inputFile.nextLine();   
                          }
                         id=user_ID;
                         Name=name;

                         if(flag){
                              window3 home=new window3();
                              home.setVisible(true);
                              dispose();
                         }else
                             errorLabel.setText("Wrong email or password");
                         
                    
            } catch (FileNotFoundException ex) {
                System.out.println("Error in file");
            }        
            }
      }
   }
    private class signUpListener implements ActionListener{
      
      public void actionPerformed(ActionEvent e){
           window2 window= new window2();
           window.setVisible(true);
           dispose();
      }
  }
}
