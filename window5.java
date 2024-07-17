/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author lenovo
 */
public class window5 extends JFrame  {
    final int WIDTH=1200;
final int HEIGHT=700;
private JPanel panel1;
private JPanel panel2;
private JPanel panel3;
private JLabel label=new JLabel("Select the Section");
private JLabel label2=new JLabel("Book Name");
private JTextField text2= new JTextField(10);
private JButton next =new JButton("next");
private JRadioButton scienceSec =new JRadioButton("Science",true);
private JRadioButton technologySec=new JRadioButton("Technology");
private JRadioButton letretureSec =new JRadioButton("Letreture");
private ButtonGroup group;
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
    private ImageIcon img=new ImageIcon("pop2.JPEG");
    private JLabel background=new JLabel(img);
    Font customFont = new Font("Arial", Font.BOLD, 20);
    
public window5()throws SocSecException{
    setTitle("Select your choice");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);
    setLayout(new BorderLayout());
    group=new ButtonGroup() ;
    group.add(scienceSec);
    group.add(technologySec);
    group.add(letretureSec);
    buildPanel1();
    next.addActionListener(new RadioButtonListener());
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
       blackItem=new JRadioButtonMenuItem("Black");
       blackItem.setMnemonic(KeyEvent.VK_B);
       blackItem.addActionListener(new colorListener());
       
       redItem=new JRadioButtonMenuItem("Red");
       redItem.setMnemonic(KeyEvent.VK_R);
       redItem.addActionListener(new colorListener());
       
       blueItem=new JRadioButtonMenuItem("Blue",true);
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
public void buildPanel1() throws SocSecException{
    //setLayout(new FlowLayout());
    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();
    label.setBackground(Color.LIGHT_GRAY);
    label.setForeground(Color.BLUE);
    panel3.add(label);
    
    next.setFont(customFont);
    label.setFont(customFont);
    scienceSec.setFont(customFont);
    technologySec.setFont(customFont);
    letretureSec.setFont(customFont);
    label2.setFont(customFont);
    
    panel1.add(scienceSec);
    panel1.add(technologySec);
    panel1.add(letretureSec);
    label2.setBackground(Color.LIGHT_GRAY);
    label2.setForeground(Color.BLUE);
    next.setBackground(Color.LIGHT_GRAY);
    next.setForeground(Color.BLUE);
    next.addActionListener(new RadioButtonListener());
    panel2.add(label2);
    panel2.add(text2);
    panel2.add(next);
    
    }

private class RadioButtonListener implements ActionListener
{
 @Override
 public void actionPerformed(ActionEvent e){
     try {
         String name1= text2.getText();
         String nameBook=text2.getText();
         
        int index = 0;
        while (index < name1.length()){
            if ( Character.isDigit(name1.charAt(index))){
                    throw new SocSecException ("contains a character that is a digit");
                     }
            index++;
        }
         if(name1.isEmpty()){
             JOptionPane.showMessageDialog(null,"Enter the name of the book");
         }
         else if (scienceSec.isSelected()){
             JOptionPane.showMessageDialog(null,"Student name: "+windows1.Name+"\nand with ID number: "+windows1.id+"\n has "
                     + "choosen book from science Section and the name of the book is: "+nameBook+"\n"
                             + "please visit office number A07 to pick up your book\n\n"
                             + "hope you Enjoy with our survic have agood day!");
             
         }else if(technologySec.isSelected()){
             
             JOptionPane.showMessageDialog(null,"Student name: "+windows1.Name+"\nand with ID number: "+windows1.id+"\n has "
                     + "choosen book from technology Section and the name of the book is: "+nameBook+"\n"
                             + "please visit office number A07 to pick up your book\n\n"
                             + "hope you Enjoy with our survic have agood day!");
             
         }else if(letretureSec.isSelected())
             JOptionPane.showMessageDialog(null,"Student name: "+windows1.Name+"\nand with ID number: "+windows1.id+"\n has "
                     + "choosen book from letreture Section and the name of the book is: "+nameBook+"\n"
                             + "please visit office number A07 to pick up your book\n\n"
                             + "hope you Enjoy with our survic have agood day!");
     } catch (SocSecException ex) {
        System.out.println("Error");
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
                label.setForeground(Color.black);
                
       else if(redItem.isSelected())
                label.setForeground(Color.red);
       else if(blueItem.isSelected())
                label.setForeground(Color.blue);
                
   }}
      
     private class checkBoxListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
            if(checkBox.isSelected()){
                label.setVisible(true);
            }
             else{
                label.setVisible(false);
            }
            
       }
   }
}
