package Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class One extends JComponent implements MouseMotionListener {
   ArrayList<Circle> circles;
   public One(){
      this.addMouseMotionListener(this);
      this.circles = new ArrayList<>();
   }

   @Override
   public void mouseDragged(MouseEvent e) {
      int x = e.getX();
      int y =e.getY();
      this.circles.add(new Lab1.Circle(new Point(x,y),2));
      this.repaint();
   }
   @Override
   public void mouseMoved(MouseEvent e) {
   }
   public void paintComponent(Graphics g){
     // for(Circle c : this.circles){
     //    c.draw(g)
      //}
      for(int i = 0; i<this.circles.size();i++){
         if(i<this.circles.size()-1){
            g.drawLine(circles.get(i).getX(),circles.get(i).getY(),circles.get(i+1).getX(),circles.get(i+1).getY());
         }
      }
   }
   public static void main(String[] args){
      JFrame a = new JFrame("Jan 16 ,2020");
      a.setVisible(true);
      a.setSize(400,400);
      a.add(new One());
   }
}
