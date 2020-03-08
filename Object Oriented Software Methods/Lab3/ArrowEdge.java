package Lab3;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class ArrowEdge extends AbstractEdge {
   @Override
   public void draw(Graphics2D g2) {

      Line2D line = getConnectionPoints();
      float midX = (float) ((line.getX1() + line.getX2()) / 2.0);
      float midY = (float) ((line.getY1() + line.getY2()) / 2.0);
      g2.draw(line);
      g2.drawString(label, midX, midY);
      Polygon arrowHead = new Polygon();
      arrowHead.addPoint(0, 5);
      arrowHead.addPoint(-5, -5);
      arrowHead.addPoint(5, -5);
      arrowHead.translate((int)getConnectionPoints().getX2(), (int)getConnectionPoints().getY2());
      g2.fill(arrowHead);

   }

   @Override
   public boolean contains(Point2D aPoint) {
      final double MAX_DIST = 2;
      return getConnectionPoints().ptSegDist(aPoint)
         < MAX_DIST;
   }
   public void setLabel(String newValue) { label = newValue; }

   public String getLabel() { return label; }
   private String label = "arrow edge";
}
