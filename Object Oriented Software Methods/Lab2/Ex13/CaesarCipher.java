package Lab2.Ex13;

public class CaesarCipher implements Cipher{
   static final int CAESAR_OFFSET = 3;
   static final int ALPHABET_SIZE = 26;
   public void encrypt(char[] charBuffer, int offset, int length){
      for(int i = offset; i < offset + length; i++)
      {
         char c = charBuffer[i];
         if (Character.isLetter(c))
         {
            c = (char) ((int) c + CAESAR_OFFSET);
            if (!Character.isLetter(c)) {
               c = (char) ((int) c - ALPHABET_SIZE);
            }
            charBuffer[i] = c;
         }
      }
   }
   public void decrypt(char[] charBuffer, int offset, int length){
      for(int i = offset; i < offset + length; i++)
      {
         char c = charBuffer[i];
         if (Character.isLetter(c))
         {
            c = (char) ((int) c - CAESAR_OFFSET);
            if (!Character.isLetter(c)) {
               c = (char) ((int) c + ALPHABET_SIZE);
            }
            charBuffer[i] = c;
         }
      }

   }
}
