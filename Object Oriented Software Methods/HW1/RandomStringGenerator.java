package HW1;

import java.util.ArrayList;
import java.util.Random;

public class RandomStringGenerator {
   private ArrayList<Range> ranges = new ArrayList<Range>();

   public void addRange(char a, char z) {
      ranges.add(new Range(a,z));
   }

   public String nextString(int i) {
      String s ="";
      for(int j =0; j<i;j++){
         Random rand = new Random();
         int randRange = rand.nextInt(ranges.size());
         Range range = ranges.get(randRange);
         int min = range.getStart();
         int max = range.getEnd();
         int randomChar=rand.nextInt(max-min)+min;
         char c = (char) randomChar;
         s+=c;
      }
      return s;
   }
   public static void main(String[] args){
      RandomStringGenerator generator = new RandomStringGenerator();
      generator.addRange('a', 'z');
      generator.addRange('A', 'Z');
      String s = generator.nextString(10);
      System.out.println(s);
   }

}
