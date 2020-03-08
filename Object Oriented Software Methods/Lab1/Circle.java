package Lab1;

import java.awt.*;

public class Circle {
   Point center;
   int radius;
   public void draw(Graphics g){
      //g.drawOval(center.x-this.radius,center.y-this.radius,2*this.radius,2*this.radius);
      g.setColor(Color.WHITE);
      g.fillOval(center.x - this.radius,
         center.y - this.radius,
         2 * this.radius,
         2 * this.radius);
      g.setColor(Color.BLACK);
   }
   public Circle(Point center, int radius){
      this.center = center;
      this.radius = radius;
   }
   public int getX(){
      return center.x;
   }
   public int getY(){
      return center.y;
   }
}
