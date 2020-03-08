package HW4;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class User extends Observable implements Observer {

   static ArrayList<Message> messages = new ArrayList<>();
   private String name;
   public User(String name){
      this.name=name;
   }
   public void addMessage(String message){
      updateWithNewMessage(new Message(message,this));
   }
   private void updateWithNewMessage(Message message){
      messages.add(message);
   }

   public String getName() {
      return name;
   }
   public static ArrayList<Message> getMessages() {
      return messages;
   }

   @Override
   public void update(Observable o, Object arg) {
      //System.out.println( this.name + " hears " + o + " saying: " + arg );

   }
   public String toString() {
      return this.name;
   }
}
