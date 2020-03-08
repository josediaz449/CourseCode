package HW5.EX2;

public class SalariedEmployee extends Employee {
   public SalariedEmployee(String name, double annualSalary){
      super(name);
      super.setSalary(annualSalary);
   }
}
