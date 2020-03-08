package HW4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JComponent implements ActionListener {
   private User user;
   private  JTextArea textArea;
   private JTextField textField;
   static JButton button;
   private static ArrayList<Frame> frames = new ArrayList<>();
   public Frame(User user){
      this.user =user;
      textArea = new JTextArea(20,20);
      button = new JButton("Send!");
      button.addActionListener(this);
      textField = new JTextField(16);
      JPanel panel = new JPanel();
      panel.add(textField);
      panel.add(button);
      panel.add(textArea);
      JFrame chat = new JFrame("Chat");
      chat.add(panel);
      chat.setVisible(true);
      chat.setSize(400,500);
      frames.add(this);
   }
   public void update(){
      textArea.setText("");
      for(int i = 0;i< User.getMessages().size();i++){
         textArea.append(User.getMessages().get(i).toString()+"\n");
      }
   }

   public User getUser() {
      return user;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String s = e.getActionCommand();
      if (s.equals("Send!")) {
         this.getUser().addMessage(this.textField.getText());
         // set the text of field to blank
         textField.setText("");
      }
      for(int i =0;i<frames.size();i++){
         frames.get(i).update();
      }
   }
}
