package Lab2.Ex9;

import javax.swing.*;

public class IconMain {
   public static void main(String[] args)
   {
      CompositeIcon composite = new CompositeIcon(100, 100);
      composite.addIcon(new CircleIcon(10), 0, 0);
      JOptionPane.showMessageDialog(
         null,
         "Circle",
         "Message",
         JOptionPane.INFORMATION_MESSAGE,
         composite);
      System.exit(0);
   }
}
