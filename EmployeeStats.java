   import java.text.NumberFormat;
import java.util.Arrays;

public class EmployeeStats
{
   private int[][] employeeSalaries;
   private NumberFormat MoneyFormat = NumberFormat.getCurrencyInstance();
   
   EmployeeStats(int numberEmployees, int numberYears)
   {
      employeeSalaries = new int[numberEmployees][numberYears];
      
      for (int rows = 0; rows < employeeSalaries.length; rows++)
      {
         for (int columns = 0; columns < employeeSalaries[0].length; columns++)
         {
            employeeSalaries[rows][columns] = (int)(Math.random() * 45001) + 5000;
         }
      }
   }
   
   public int mostMoney()
   {
      int mostMoney = 0;
      int index = 0;
      
      for (int rows = 0; rows < employeeSalaries.length; rows++)
      {
         for (int columns = 0; columns < employeeSalaries[0].length; columns++)
         {
            if (employeeSalaries[rows][columns] > mostMoney)
            {
               mostMoney = employeeSalaries[rows][columns];
               index = rows + 1;
            }
         }
      }
      return index;
   }
   
   public int highestSalaryYear()
   {
      int mostMoney = 0;
      int highestSalaryYear = 0;
      
      for (int rows = 0; rows < employeeSalaries.length; rows++)
      {
         for (int columns = 0; columns < employeeSalaries[0].length; columns++)
         {
            if (employeeSalaries[rows][columns] > mostMoney)
            {
               mostMoney = employeeSalaries[rows][columns];
               highestSalaryYear = columns + 1;
            }
         }
      }
      return highestSalaryYear;
   }
   
   public int totalEarnings(int rowIndex)
   {
      int sum = 0;
      
      for (int columns = 0; columns < employeeSalaries[0].length; columns++)
      {
         sum = sum + employeeSalaries[rowIndex - 1][columns];
      }
      return sum;
   }
   
   public int allEarnings()
   {
      int totalSum = 0;
      
      for (int rows = 0; rows < employeeSalaries.length; rows++)
      {
         for (int columns = 0; columns < employeeSalaries[0].length; columns++)
         {
            totalSum = totalSum + employeeSalaries[rows][columns];
         }
      }
      return totalSum;
   }
   
   public int highestSalaryPerson(int columnIndex)
   {
      int temp = 0;
      int index = 0;
      
      for (int rows = 0; rows < employeeSalaries.length; rows++)
      {
         if (temp < employeeSalaries[rows][columnIndex - 1])
         {
            temp = employeeSalaries[rows][columnIndex - 1];
            index = rows + 1;
         }
      }
      return index;
   }   
   
   public String[] averageSalaryEachYear()
   {
      double[] sum = new double[employeeSalaries[0].length];
      double[] averageSalaryEachYear = new double[employeeSalaries[0].length];
      int index = 0;
      String[] averageSalary = new String[employeeSalaries[0].length];
      
      for (int columns = 0; columns < employeeSalaries[0].length; columns++)
      {
         for (int rows = 0; rows < employeeSalaries.length; rows++)
         {
            sum[index] = sum[index] + employeeSalaries[rows][columns];
         }
         index++;
      }
      
      String temp;
      for (int rows = 0; rows < averageSalaryEachYear.length; rows++)
      {
         averageSalaryEachYear[rows] = sum[rows]/averageSalaryEachYear.length;
         temp = Double.toString(averageSalaryEachYear[rows]);
         temp = MoneyFormat.format(averageSalaryEachYear[rows]);
         averageSalary[rows] = temp;
      }
      
      return averageSalary;
   }
   
   public void printSalaries()
   {
      System.out.println("Employee Data:\n");
      System.out.print("\t\t\t");
      for (int columns = 0; columns < employeeSalaries[0].length; columns++)
      {
         System.out.print("\t\tYear" + (columns + 1) + "\t");
      }
      System.out.print("\n\t\t\t\t   ---");
      
      for (int columns = 0; columns < employeeSalaries[0].length; columns++)
      {
         System.out.print("-----------");
      }
   
      for (int rows = 0; rows < employeeSalaries.length; rows++)
      {
         System.out.print("\nEmployee" + (rows + 1) + " \t\t");
         for (int columns = 0; columns < employeeSalaries[0].length; columns++)
         {
            System.out.print(MoneyFormat.format(employeeSalaries[rows][columns]).replaceAll("\\.00", "") + "\t\t");
         }
      }
   }
}

