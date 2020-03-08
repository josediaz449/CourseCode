package HW5.EX17;

import java.awt.*;
import java.awt.geom.Point2D;

public interface SceneShape {
   void setSelected(boolean b);
   boolean isSelected();
   void drawSelection(Graphics2D g2);
   void draw(Graphics2D g2);
   void translate(double dx, double dy);
   boolean contains(Point2D p);
   Rectangle getBounds();
}
