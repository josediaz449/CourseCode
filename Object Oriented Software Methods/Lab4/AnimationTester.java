package Lab4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.*;

/**
   This program animates a sort algorithm.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      SortAnimator animator1 = new SortAnimator(new BubbleSorter());
      SortAnimator animator2 = new SortAnimator(new SelectionSorter());
      animator2.setBounds(animator1.getWidth(),
         0, animator2.getWidth(), animator2.getHeight());
   }
}
