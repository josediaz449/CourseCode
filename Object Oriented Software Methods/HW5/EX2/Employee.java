package HW5.EX2;

public class Employee
{
   private String name;
   private double salary;

   public Employee(String name)
   {
      this.name=name;
   }
   public void setSalary(double aSalary)
   {
      this.salary = aSalary;
   }
   public String getName()
   {
      return this.name;
   }
   public double getSalary()
   {
      return this.salary;
   }
   public double getWeeklySalary(){
      return this.getSalary()/52;
   }
}
