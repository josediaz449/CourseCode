package HW5.EX17;

import java.awt.*;

public abstract class SelectableShape implements SceneShape{
   private boolean selected;
   public void setSelected(boolean b)
{
      selected = b;
      }
   public boolean isSelected()
{
      return selected;
      }
   public void drawSelection(Graphics2D g2)
   {
      g2.translate(1, 1);
      draw(g2);
      g2.draw(getBounds());
      g2.translate(1, 1);
      draw(g2);
      g2.translate(-2, -2);
   }
}
