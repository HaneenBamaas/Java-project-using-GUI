/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author lenovo
 */
public class window6 extends JFrame{
     
    final int WIDTH=1200;
    final int HEIGHT=700;
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;
    private JMenuBar menuBar;
    private JMenu File;
    private JMenu text;
    private JMenu home;
    private JMenuItem homeItem;
    private JMenuItem logOut;
    private JMenuItem aboutUs;
    private JMenuItem contact;
    private JRadioButtonMenuItem blackItem;
    private JRadioButtonMenuItem redItem;
    private JRadioButtonMenuItem blueItem;
    private JCheckBoxMenuItem checkBox;
    private JLabel message;
    private JTextField text2;
    private JLabel message2;
    private ImageIcon img=new ImageIcon("pop2.JPEG");
    private JLabel background=new JLabel(img);
    Font customFont = new Font("Arial", Font.BOLD, 20);
    
public JButton next =new JButton("next");
public JRadioButton print =new JRadioButton("printing",true);
public JRadioButton copy=new JRadioButton("Photo Copying");

public ButtonGroup group; 
    
  public window6(){
    setTitle("Select your choice");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);
    setLayout(new BorderLayout());
     group=new ButtonGroup() ;
     group.add(print);
     group.add(copy);

    buildPanel1();
    add(panel3,BorderLayout.NORTH);
    add(panel1,BorderLayout.CENTER);
    add(panel2,BorderLayout.SOUTH);
    

    buildMenuBar();
    setLocationRelativeTo(null);
    add(background);
	    background.setLayout(new FlowLayout());
            background.add(panel1);
    setVisible(true);
  
  }  
  
   public void buildMenuBar(){
       menuBar=new JMenuBar();
       
       
       buildFileMenu();
       buildTextMenu();
       buildHomeMenu();
        
       menuBar.add( File);
       menuBar.add( home);
       menuBar.add( text);
       setJMenuBar(menuBar);
       
   }
   
    public void buildFileMenu(){
     logOut=new JMenuItem("Log out");
     logOut.setMnemonic(KeyEvent.VK_X);
     logOut.addActionListener(new LogOutListener());
     
    aboutUs=new JMenuItem("About Us");
    aboutUs.setMnemonic(KeyEvent.VK_X);
    aboutUs.addActionListener(new aboutUsListener());
    
    contact=new JMenuItem("contact");
    contact.setMnemonic(KeyEvent.VK_X);
    contact.addActionListener(new contactListener());

     File=new JMenu("File");
     File.setMnemonic(KeyEvent.VK_F);
     
     File.add(logOut);
     File.add(aboutUs);
     File.add(contact);
     
}
    
   public void buildTextMenu(){
       blackItem=new JRadioButtonMenuItem("Black",true);
       blackItem.setMnemonic(KeyEvent.VK_B);
       blackItem.addActionListener(new colorListener());
       
       redItem=new JRadioButtonMenuItem("Red");
       redItem.setMnemonic(KeyEvent.VK_R);
       redItem.addActionListener(new colorListener());
       
       blueItem=new JRadioButtonMenuItem("Blue");
       blueItem.setMnemonic(KeyEvent.VK_U);
       blueItem.addActionListener(new colorListener());
       
       ButtonGroup group=new ButtonGroup();
       group.add(blackItem);
       group.add(redItem);
       group.add(blueItem);
       
       checkBox=new JCheckBoxMenuItem("visible",true);
       checkBox.setMnemonic(KeyEvent.VK_V);
       checkBox.addActionListener(new checkBoxListener());
       
       text=new JMenu("text");
       text.setMnemonic(KeyEvent.VK_T);
       
       text.add(blackItem);
       text.add(redItem); 
       text.add(blueItem); 
       text.add(checkBox); 
       
}
    public void buildHomeMenu(){
    
    homeItem=new JMenuItem("Back to home");
    homeItem.setMnemonic(KeyEvent.VK_X);
    homeItem.addActionListener(new homeListener());
    
    home=new JMenu("Home");
    home.setMnemonic(KeyEvent.VK_T);
    
    home.add(homeItem);   
}
  public void buildPanel1(){
    //setLayout(new FlowLayout(FlowLayout.CENTER));
    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();
    message=new JLabel("You choose printing and phtocoping survice"); 
    text2=new JTextField(10);
    message2=new JLabel("Enter number of paper: ");
    panel1.setBackground(Color.LIGHT_GRAY);
    panel1.add(print);
    panel1.add(copy);
    panel1.add(message2);
    panel1.add(text2);
    
    next.addActionListener(new buttonListener());
    panel2.setBackground(Color.LIGHT_GRAY);
    
    next.setBackground(Color.LIGHT_GRAY);
    next.setForeground(Color.BLUE);
    
    
    message.setFont(customFont);
    message2.setFont(customFont);
    next.setFont(customFont);
    print.setFont(customFont);
    copy.setFont(customFont);
    
    panel2.add(next);
    panel3.add(message);

}
 
    private class buttonListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           String number=text2.getText();
         try{
           int number2 =Integer.parseInt(number);
           if(number.isEmpty()){
             JOptionPane.showMessageDialog(null,"you have to enter the number of book");   
           }
//           if else(number.)
         else if(print.isSelected()){
              int total=number2*2;
           JOptionPane.showMessageDialog(null,"Student name: "+windows1.Name+"\nand with ID number: "+windows1.id+"\n has "
            + "choosen print survaice and your total charge is: "+total+"\n"
            + "please visit office number A07 to pick up your paper\n\n"
            + "hope you Enjoy with our survic have a good day!");

          } 
          else if(copy.isSelected()){
             double total=number2*0.5;
             String messageDialoge="visit office number A01 \nand your total charge is: "+total;
            JOptionPane.showMessageDialog(null,"Student name: "+windows1.Name+"\nand with ID number: "+windows1.id+"\n has "
            + "choosen photocopy survaice and your total charge is: "+total+"\n"
            + "please visit office number A07 to pick up your paper\n\n"
            + "hope you Enjoy with our survic have a good day!");
          }
       }
       catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null,"you have to enter number value");
}
} }
    
    
 private class LogOutListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
       
        windows1 window= new windows1();
           window.setVisible(true);
           dispose();    
    }
}
   
   private class aboutUsListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
          JOptionPane.showMessageDialog(null, "We are student in Jeddah university working "
                  + "on \nSystem to control and improve library facility"
                  + "\n"
                  + "\n our name are Haneen with ID number 2216622 and Shrifa with ID number 221156\n"
                  + "from IA department");
       }
   }
    private class contactListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
          JOptionPane.showMessageDialog(null, "Hanen@hotmail.com"
                  + "\n+966571058702");
       }
   }
     private class homeListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
           window3 window= new window3();
           window.setVisible(true);
           dispose();
            
       }
   }
     
    private class colorListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
            if(blackItem.isSelected())
                message.setForeground(Color.black);
                
       else if(redItem.isSelected())
                message.setForeground(Color.red);
       else if(blueItem.isSelected())
                message.setForeground(Color.blue);
                
   }}
      
     private class checkBoxListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
            if(checkBox.isSelected()){
                message.setVisible(true);
            }
             else{
                message.setVisible(false);
            }
            
       }
   }
    
}// end of window 

