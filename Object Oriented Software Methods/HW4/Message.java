package HW4;

public class Message {
   String text;
   User author;
   public Message(String message, User user){
      this.text=message;
      this.author=user;
   }
   public String toString(){
      return this.author.getName()+" says: "+this.text;
   }
}
