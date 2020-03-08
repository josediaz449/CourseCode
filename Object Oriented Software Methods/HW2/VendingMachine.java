package HW2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VendingMachine {
   static private Queue<Product> chips= new LinkedList<>();
   static private Queue<Product> soda = new LinkedList<>();
   static private Queue<Product> juice= new LinkedList<>();
   static private Queue<Product> chocolate = new LinkedList<>();
   private double money;
   static private boolean exchange;
   public VendingMachine() {
      for( int i = 0;i<5;i++){
         chips.add(new Product("chips",1.25));
         soda.add(new Product("soda",1.50));
         juice.add(new Product("juice",1.25));
         chocolate.add(new Product("chocolate",1.00));
         money=0;
         exchange=true;
      }
   }
   public void restock(Product product, int quantity){
      for(int i = 0;i<quantity;i++){
         if(product.getName().equals("chips")){
            chips.add(product);
         }
         if(product.getName().equals("soda")){
            soda.add(product);
         }
         if(product.getName().equals("juice")){
            juice.add(product);
         }
         if(product.getName().equals("chocolate")){
            chocolate.add(product);
         }
      }
      System.out.print("Machine restocked with: "+quantity+" "+product.getName()+".");
   }
   public void withdrawMoney(){
      System.out.println("Money withdrawn: "+ money);
      money =0;
   }
   public void buy(Product product, double amount){
      double change;
      if(product.getName().equals("chips")){
         change = amount - chips.peek().getPrice();
         if(chips.isEmpty()){
            System.out.println("Chips are sold out, sorry for the inconvenience! Money returned.");
         }
         else if(change<0){
            System.out.println("Insufficient amount, money returned.");
         }
         else {
            chips.remove();
            money+=amount;
            System.out.println("Change: $"+change+" Enjoy!");
         }
      }
      if(product.getName().equals("soda")){
         change = amount - soda.peek().getPrice();
         if(change<0){
            System.out.println("Insufficient amount, money returned.");
            soda.remove();
         }
         else {
            money+=amount;
            soda.remove();
            System.out.println("Change: $"+change+" Enjoy!");
         }
      }
      if(product.getName().equals("juice")){
         change = amount - juice.peek().getPrice();
         if(change<0){
            System.out.println("Insufficient amount, money returned.");
         }
         else {
            money+=amount;
            juice.remove();
            System.out.println("Change: $"+change+" Enjoy!");
         }
      }
      if(product.getName().equals("chocolate")){
         change = amount - chocolate.peek().getPrice();
         if(change<0){
            System.out.println("Insufficient amount, money returned.");
         }
         else {
            money+=amount;
            chocolate.remove();
            System.out.println("Change: $"+change+" Enjoy!");
         }
      }

   }
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      VendingMachine vendingMachine = new VendingMachine();
      while (exchange) {
         System.out.println("Enter 1 for buyer and 2 for operator");
         int person = in.nextInt();
         if (person == 1) {
            System.out.println("Choose an option: 1.chips($1.25)  2.soda($1.50)  3.juice($1.25)  4.chocolate($1.00)");
            int choice2 = in.nextInt();
            System.out.println("Please enter amount in coins you will insert.");
            double amount = in.nextDouble();
            if (choice2 == 1) {
               if(!chips.isEmpty()) {
                  vendingMachine.buy(chips.peek(), amount);
               }
               else {
                  System.out.println("Sorry, we are sold out!");
               }
            }
            if (choice2 == 2) {
               if(!soda.isEmpty()) {
                  vendingMachine.buy(soda.peek(), amount);
               }
               else {
                  System.out.println("Sorry, we are sold out!");
               }
            }
            if (choice2 == 3) {
               if(!juice.isEmpty()) {
                  vendingMachine.buy(juice.peek(), amount);
               }
               else {
                  System.out.println("Sorry, we are sold out!");
               }
            }
            if (choice2 == 4) {
               if(!chocolate.isEmpty()) {
                  vendingMachine.buy(chocolate.peek(), amount);
               }
               else {
                  System.out.println("Sorry, we are sold out!");
               }
            }
            System.out.println("Enter 0 to end transaction or 1 to continue with another transaction:");
            int cont = in.nextInt();
            if(cont==0){
               System.out.println("Thanks for shopping.");
               exchange=false;
            }
         } else {
            System.out.println("Please enter 1 to restock or 2 to withdraw money");
            int choice = in.nextInt();
            if (choice == 1) {
               System.out.println("Choose a product to restock: 1.chips  2.soda  3.juice  4.chocolate");
               int item = in.nextInt();
               System.out.println("Enter quantity: ");
               int quantity = in.nextInt();
               if (item == 1) {
                  vendingMachine.restock(new Product("chips", 1.25), quantity);
               }
               if (item == 2) {
                  vendingMachine.restock(new Product("soda", 1.50), quantity);
               }
               if (item == 3) {
                  vendingMachine.restock(new Product("juice", 1.25), quantity);
               }
               if (item == 4) {
                  vendingMachine.restock(new Product("chocolate", 1.00), quantity);
               }
               System.out.println(" Enter 0 to end transaction or 1 to continue with another transaction:");
               int cont = in.nextInt();
               if(cont==0){
                  System.out.println("Thanks for shopping.");
                  exchange=false;
               }
            } else if (choice == 2) {
               vendingMachine.withdrawMoney();
               System.out.println("Enter 0 to end transaction or 1 to continue with another transaction:");
               int cont = in.nextInt();
               if(cont==0) {
                  System.out.println("Thanks for shopping.");
                  exchange = false;
               }
            }
         }
      }
   }
}
