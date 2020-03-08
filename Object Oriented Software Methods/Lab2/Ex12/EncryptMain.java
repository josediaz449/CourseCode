package Lab2.Ex12;
import java.io.*;

public class EncryptMain {
   public static void main(String[] args) throws IOException
   {
      EncryptingWriter encryptingWriter = new EncryptingWriter(new FileWriter("main.out"));
      encryptingWriter.write("abcdefghijklmnopqrstuvwxyz1abcdefghijklmnopqrstuvwxyz", 20, 27);
      encryptingWriter.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ1ABCDEFGHIJKLMNOPQRSTUVWXYZ", 20, 27);

      PrintWriter w = new PrintWriter(encryptingWriter,true);
      w.println("abcdefghijkl2mnopqrstuvwxyz");
      w.println("ABCDEFGHIJKL2MNOPQRSTUVWXYZ");

      char inChars[] =
         "----------------------------------------------".toCharArray();

      DecryptingReader dr = new DecryptingReader(new FileReader("main.out"));
      dr.read(inChars, 10, 27);
      System.out.println(inChars);
      dr.read(inChars, 10, 27);
      System.out.println(inChars);

      BufferedReader b = new BufferedReader(dr);
      String s = b.readLine();
      System.out.println(s);
      s = b.readLine();
      System.out.println(s);
   }
}
