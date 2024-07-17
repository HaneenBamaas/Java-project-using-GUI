/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author lenovo
 */
public class window2 extends JFrame {
    private final int WINDOW_WIDTH=1200;
    private final int WINDOW_HEIGHT=700;
    private JLabel Welcom; 
    private JLabel message; 
    private JLabel message2;
    private JLabel message3;
    private JLabel message4;
    private JLabel errorLabel;
    private JTextField text;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JButton signUp;
    private ImageIcon img=new ImageIcon("pop2.JPEG");
    private JLabel background=new JLabel(img);
    Font customFont = new Font("Arial", Font.BOLD, 16);

    public window2() {
      setTitle("University Library");
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout(10,10));  
      buildPanel();
      
       add(p1,BorderLayout.NORTH);
       add(p3,BorderLayout.SOUTH);

      setLocationRelativeTo(null);
      add(background);
	    background.setLayout(new FlowLayout());
	    background.add(p2);
       setVisible(true);    
    }
    
    public void buildPanel(){
       p1=new JPanel();
       p2=new JPanel();
       p3=new JPanel();
       Welcom=new JLabel("Sign Up Now!!");
       p2.setLayout(new GridLayout(5,2,10,10));
       errorLabel=new JLabel("*");
       
       message=new JLabel("Enter Your Name: ");
       text= new JTextField(12);
       message2=new JLabel("Enter ID Number: ");
       text2= new JTextField(12);
       message3=new JLabel("Enter passward: ");
       text3= new JTextField(12);
       message4=new JLabel("confirm passward: ");
       text4= new JTextField(12);
       
       signUp=new JButton("Rigste");

       Welcom.setForeground(Color.BLUE);
       signUp.setBackground(Color.LIGHT_GRAY);
       signUp.setForeground(Color.BLUE);
       
       Welcom.setFont(customFont);
       message.setFont(customFont);
       message2.setFont(customFont);
       message4.setFont(customFont);
       message3.setFont(customFont);
       signUp.setFont(customFont);
       
       p1.add(Welcom);
       p2.add(message);
       p2.add(text);
       p2.add(message2);
       p2.add(text2);
       p2.add(message3);
       p2.add(text3);
       p2.add(message4);
       p2.add(text4);
       p2.add(errorLabel);
       p3.add(signUp);
       signUp.addActionListener(new signUpListener());
       
    }
     private  class signUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
          String user_name=text.getText();
          String user_id=text2.getText();
          String user_password=text3.getText();
          String user_confirm_password=text4.getText();
          
           
          if(user_name.isEmpty()){
              errorLabel.setText("Please enter name ");
          }
          else if(user_id.isEmpty()){
               errorLabel.setText("Please enter ID ");
          }
          else if(user_password.isEmpty()){
               errorLabel.setText("Please enter password");
          }
          else if(user_confirm_password.isEmpty()){
               errorLabel.setText("Please enter confirm password");
          }
          else if(!user_password.equals(user_confirm_password)){
              errorLabel.setText("Password and Confirm password must be same");
          }
          else if(user_password.length()<5){
              System.out.println(user_password.length());
              errorLabel.setText("Password must be at least 10 character");
          }
          else{
              try {
                   File file = new File("userInfo.txt");
                   Scanner inputFile= new Scanner(file);
                   ArrayList<String> emails=new ArrayList<>();
                  while(inputFile.hasNext()){
                      inputFile.next();
                      String email=inputFile.next();
                      emails.add(email);
                      
                      inputFile.nextLine();
                  }
                  if(emails.contains(user_id)){
                      errorLabel.setText("This email already registered");
                  }else{
                  FileWriter fwriter = new FileWriter("userInfo.txt", true);
                  PrintWriter outputFile = new PrintWriter(fwriter);
                  outputFile.println(user_name+" "+user_id+" "+user_password);
                  fwriter.close();
                  windows1 login=new windows1();
                  login.setVisible(true);
                  dispose();
                  }
                   
              } catch (IOException ex) {
                  System.out.println("Error in File");
              }
              
          }
    
}
     }
}
