package Lab2.Ex13;

public interface Cipher {
   public void encrypt(char[] charBuffer, int offset, int length);
   public void decrypt(char[] charBuffer, int offset, int length);
}
