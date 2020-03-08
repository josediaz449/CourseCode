package Lab3;

import java.awt.*;
import java.awt.geom.*;

/**
   An edge that is shaped like a straight line.
*/
public class LineEdge extends AbstractEdge
{
   public void draw(Graphics2D g2)
   {
      Line2D line = getConnectionPoints();
      g2.draw(line);
      float midX = (float) ((line.getX1() + line.getX2()) / 2.0);
      float midY = (float) ((line.getY1() + line.getY2()) / 2.0);
      g2.draw(line);
      g2.drawString(label, midX, midY);
   }

   public boolean contains(Point2D aPoint)
   {
      final double MAX_DIST = 2;
      return getConnectionPoints().ptSegDist(aPoint) 
         < MAX_DIST;
   }

   public void setLabel(String newValue) { label = newValue; }

   public String getLabel() { return label; }
   private String label = "line edge";
}
