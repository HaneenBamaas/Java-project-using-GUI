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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author lenovo
 */
public class window3 extends JFrame{
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
    private JPanel optionsPanel;
    private JList optionList;
    private JScrollPane scroll;
    private String [] options={"Book Place for Study","Borrow Book","Photocopying or printing"};
    final int WIDTH=1200;
    final int HEIGHT=700;
    private ImageIcon img=new ImageIcon("pop2.JPEG");
    private JLabel background=new JLabel(img);
    Font customFont = new Font("Arial", Font.BOLD, 22);
  // private JButton button=new JButton("jj");
    public window3(){
    
    setTitle("Select your choice");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);
    setLayout(new BorderLayout());
    
    background.setBounds(0, 0, 1200, 700);
    
       buldOptionPanel();
       //background.add(optionsPanel);
      


    
       buildMenuBar();
       setLocationRelativeTo(null);
        add(background);
	    background.setLayout(new FlowLayout());
	    background.add(optionsPanel);
  //  getContentPane().add(background);
    //add(optionsPanel, BorderLayout.CENTER);  // Add the optionsPanel to the frame

       setVisible(true);
    
   
    }//end constructor
    
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
    
    
    private void buldOptionPanel(){
    
      optionsPanel=new JPanel();
      optionList= new JList(options);
      scroll=new JScrollPane(optionList);
      optionList.setFont(customFont);

     
    optionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    optionList.setBackground(Color.LIGHT_GRAY);
    optionList.setForeground(Color.BLUE);
   
    optionList.addListSelectionListener(new NextListener());
    optionsPanel.add(scroll);
    
    }
    
    private class NextListener implements ListSelectionListener
    {
     public void valueChanged(ListSelectionEvent e) {
     
     if(optionList.getSelectedValue().equals("Book Place for Study")){
         
         window4 w= new window4();
         w.setVisible(true);
            dispose();
     }else if(optionList.getSelectedValue().equals("Borrow Book")){
         
         try {
             window5 book=new window5();
             book.setVisible(true);
             dispose();
         } catch (SocSecException ex) {
             Logger.getLogger(window3.class.getName()).log(Level.SEVERE, null, ex);
         }
     }else if(optionList.getSelectedValue().equals("Photocopying or printing")){
         
         window6 copying=new window6();
           copying.setVisible(true);
           dispose();
     }//end ifs
     
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
                optionList.setForeground(Color.black);
                
       else if(redItem.isSelected())
                optionList.setForeground(Color.red);
       else if(blueItem.isSelected())
                optionList.setForeground(Color.BLUE);
                
   }}
      
     private class checkBoxListener implements ActionListener{
       public void actionPerformed(ActionEvent e){
            if(checkBox.isSelected()){
                optionList.setVisible(true);
            }
             else{
                optionList.setVisible(false);
            }
             
       }
   }
}
