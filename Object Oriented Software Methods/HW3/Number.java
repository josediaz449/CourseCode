package HW3;

public class Number implements Comparable<Number>, Comparator<Number>{
   private int number;
   public Number(int number){
      this.number=number;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }
   @Override
   public int compareTo(Number other) {
      if (this.getNumber()<other.getNumber()){
         return -1;
      }
      else if(this.getNumber()==other.getNumber()){
         return 0;
      }
      else {
         return 1;
      }
   }

   @Override
   public int compare(Number first, Number second) {
      if (first.getNumber()<second.getNumber()){
         return -1;
      }
      else if(first.getNumber()==second.getNumber()){
         return 0;
      }
      else {
         return 1;
      }
   }
   public static void main(String[] args){
      Number one = new Number(1);
      Number five = new Number(5);
      Number oneToo = new Number(1);
      System.out.println(one.compareTo(five));
      System.out.println(five.compareTo(one));
      System.out.println(one.compareTo(oneToo));
      System.out.println(one.compare(one,oneToo));
   }

}
