import java.util.Scanner;

public class Welcome {
      public static void main (String args[]) {
      Scanner scan=new Scanner(System.in);
      
      System.out.println("Enter your First Name");
      String name1=scan.nextLine();
      
      System.out.println("Enter your Last Name");
      String name2=scan.nextLine();
      
      System.out.printf("Welcome to the Second Year %s %s", name1,name2);
      
      
      }
      }