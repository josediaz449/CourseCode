package HW5.EX2;

public class EmployeeTest {

   public static void main(String[] args){
      Employee hourly = new HourlyEmployee("Jose", 55.50);
      Employee salaried = new SalariedEmployee("Jamar", 90550);
      System.out.println(hourly.getWeeklySalary());
      System.out.println(salaried.getWeeklySalary());
   }
}
