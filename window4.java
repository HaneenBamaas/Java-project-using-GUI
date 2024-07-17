/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author lenovo
 */
public class window4 extends JFrame{
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
    private JLabel label=new JLabel("Enter the Time you Want to vitit the Library");
    private JTextField text2= new JTextField(10);
    private JButton next =new JButton("next");
    private JLabel label1=new JLabel("You choose book place for studay survice");
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    final int WIDTH=1200;
    final int HEIGHT=700;
    private ImageIcon img=new ImageIcon("pop2.JPEG");
    private JLabel background=new JLabel(img);
Font customFont = new Font("Arial", Font.BOLD, 20);

  public window4(){
    setTitle("Select your choice");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);
    setLayout(new BorderLayout());
    
    buildPanel1();
    next.addActionListener(new ButtonListener());
    add(panel3,BorderLayout.NORTH);
  //  add(panel1,BorderLayout.CENTER);
    add(panel2,BorderLayout.SOUTH);

    buildMenuBar();
    setLocationRelativeTo(null);
        add(background);
	    background.setLayout(new FlowLayout());
	    background.add(label);
            background.add(text2);
 
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
  
  private void buildPanel1(){
  panel1 = new JPanel();
  panel1.setBackground(Color.LIGHT_GRAY);
  
  panel1.add(label);
  panel1.add(text2);
  label.setForeground(Color.BLUE);
  
   label.setFont(customFont);
   next.setFont(customFont);
   
   panel2 = new JPanel();
   panel2.setBackground(Color.LIGHT_GRAY);
   next.setForeground(Color.BLUE);
   next.setBackground(Color.LIGHT_GRAY);
   panel2.add(next);
  
   label1.setFont(customFont);
   panel3=new JPanel();
   panel3.add(label1);
  }
  
  
  public class ButtonListener implements ActionListener{
   public void actionPerformed(ActionEvent e)
   {
             String time= text2.getText();
             try{
               int timeInt=Integer.parseInt(time);
          if(time.isEmpty()){
            JOptionPane.showMessageDialog(null,"You have to write the time you want to visit the library");  
          }
          else{
  JOptionPane.showMessageDialog(null,"Student name: "+windows1.getString()+"\nand with ID number: "+windows1.getId()+"\n has "
            + "choosen visit Library for studay in time: "+time
            + "\nplease visit office number A07 to help you to find your own place\n\n"
            + "\nhope you Enjoy with our survic have agood day!");
          }}
          
      catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null,"you have to enter number value");
}
   }
  }
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
                label1.setForeground(Color.black);
                
       else if(redItem.isSelected())
                label1.setForeground(Color.red);
       else if(blueItem.isSelected())
                label1.setForeground(Color.BLUE);
                
   }}
      
     private class checkBoxListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
            if(checkBox.isSelected()){
                label1.setVisible(true);
            }
             else{
                label1.setVisible(false);
            }
             
       }
   }
}
