package HW5.EX2;

public class HourlyEmployee extends Employee {
   private double hourlySalary;
   public HourlyEmployee(String name, double hourlySalary){
      super(name);
      this.hourlySalary=hourlySalary;
      super.setSalary(hourlySalary*40*52);
   }

   @Override
   public double getWeeklySalary() {
      return hourlySalary*40;
   }
}
