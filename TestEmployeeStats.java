   import java.util.Scanner; //import scanner class
import java.util.Arrays;
import java.text.NumberFormat;

public class TestEmployeeStats
{
   public static void main(String args[]) //program main method 
   {
      Scanner input = new Scanner(System.in);
      char another = 'y';
      NumberFormat MoneyFormat = NumberFormat.getCurrencyInstance();
      
      while (Character.toLowerCase(another) == 'y')
      {
         System.out.print("\nPlease enter number of employees: ");
         int numberEmployees = input.nextInt();
         assert numberEmployees > 0;
         System.out.print("Please enter number of years: ");
         int numberYears = input.nextInt();
         assert numberYears > 0;
         
         EmployeeStats myObject = new EmployeeStats(numberEmployees, numberYears);
         
         myObject.printSalaries();
         System.out.println("\n\nEmployee" + myObject.mostMoney() + " made most money over the years.");
         System.out.println("Highest salary was made in Year" + myObject.highestSalaryYear());
         System.out.println("Total earning by Employee" + myObject.mostMoney() + " is " + MoneyFormat.format(myObject.totalEarnings(myObject.mostMoney())).replaceAll("\\.00", ""));
         System.out.println("Total earning by all Employees is " + MoneyFormat.format(myObject.allEarnings()).replaceAll("\\.00", ""));
         System.out.println("In year" + myObject.highestSalaryYear() + ", Employee" + myObject.highestSalaryPerson(myObject.highestSalaryYear()) + " has the highest salary.");
         System.out.println("The average salary for year: \n");
         System.out.print("\t\t\t");
         for (int numberYearsCounter = 0; numberYearsCounter < numberYears; numberYearsCounter++)
         {
            System.out.print("Year" + (numberYearsCounter + 1) + "\t\t\t");
         }
         System.out.println("");
         System.out.print("\t\t\t");
         for (int numberYearsCounter = 0; numberYearsCounter < numberYears; numberYearsCounter++)
         {
            System.out.print("------------");
         }
         System.out.println("");
         String averageSalary = Arrays.toString(myObject.averageSalaryEachYear()).replace("[", "").replace("]", "").replaceAll(", ", "  ");
         System.out.print("\t\t\t" + averageSalary + " \t\t");
         
         System.out.print("\nRe-run program with different integer values (y/n)? "); //prompts user to rerun program with different integer inputs
         another = input.next().charAt(0); //read char from user to rerun program or not
      }
   }
}   
