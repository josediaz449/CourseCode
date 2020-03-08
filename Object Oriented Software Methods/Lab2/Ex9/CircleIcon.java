package Lab2.Ex9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleIcon implements Icon {
   private int width;
   public CircleIcon(int width){
      this.width=width;
   }
   @Override
   public void paintIcon(Component c, Graphics g, int x, int y) {
      Graphics2D g2 = (Graphics2D)g;
      Ellipse2D circle = new Ellipse2D.Double(x,y,width,width);
      g2.fill(circle);
   }

   @Override
   public int getIconWidth() {
      return width;
   }

   @Override
   public int getIconHeight() {
      return width;
   }
}
