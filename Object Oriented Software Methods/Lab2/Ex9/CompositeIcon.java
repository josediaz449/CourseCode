package Lab2.Ex9;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CompositeIcon implements Icon {

   private ArrayList<Icon> icons;
   private ArrayList<Point> locations;
   private int width;
   private int height;
   public CompositeIcon(int width, int height){
      this.width=width;
      this.height=height;
      this.icons=new ArrayList<>();
      this.locations = new ArrayList<>();
   }
   void addIcon(Icon icon, int x, int y){

      icons.add(icon);
      locations.add(new Point(x,y));
   }
   @Override
   public void paintIcon(Component c, Graphics g, int x, int y) {
      int i = 0;
      for (Icon s : icons) {
         Point offset = locations.get(i++);
         s.paintIcon(c, g, x + offset.x, y + offset.y);

      }
   }

   @Override
   public int getIconWidth() {
      return width;
   }

   @Override
   public int getIconHeight() {
      return height;
   }
}
