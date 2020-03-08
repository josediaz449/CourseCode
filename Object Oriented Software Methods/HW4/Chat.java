package HW4;

public class Chat{
   public static void main(String[] args) {
      User a = new User("Adrian");
      User b = new User("Rebekah");
      User c = new User("Ari");
      a.addObserver(b);
      a.addObserver(c);
      b.addObserver(a);
      b.addObserver(c);
      c.addObserver(a);
      c.addObserver(b);
      Frame frame=new Frame(a);
      Frame frame1=new Frame(b);
      Frame frame2=new Frame(c);

   }
}
