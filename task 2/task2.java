import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\n");

        System.out.println("Enter Marks in Maths:");
        int Math = sc.nextInt();
        
        System.out.println("Enter Marks in Social studies:");
        int sst = sc.nextInt();
        
        System.out.println("Enter Marks in Accounts:");
        int acc = sc.nextInt();
        
        System.out.println("Enter Marks in Chemistry:");
        int chem = sc.nextInt();
        
        System.out.println("Enter Marks in Physics:");
        int phy = sc.nextInt();

        System.out.println("Marks in Maths are: " + Math);
        System.out.println("Marks in Social studies: " + sst);
        System.out.println("Marks in Accounts: " + acc);
        System.out.println("Marks in Chemistry: " + chem);
        System.out.println("Marks is physics: " + phy);

        int total = (Math+sst+acc+chem+phy);
        System.out.println("Total marks : " + total);

        double avg = (total * 100)/500;
        System.out.println(avg + "%");

        System.out.println("!! Your results are !!");
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + avg +"%");

        if(avg > 95 && avg <= 100){
            System.out.println("Your grade is: A+");
        }
        else if(avg > 90 && avg <= 95){
            System.out.println("Your grade is: A");
        }
        else if(avg > 80 && avg <= 90){
            System.out.println("Your grade is: B+");
        }
        else if(avg > 75 && avg <= 80){
            System.out.println("Your grade is: B");
        }
        else if(avg > 65 && avg <= 75){
            System.out.println("Your grade is: C+");
        }
        else if(avg > 65 && avg <= 75){
            System.out.println("Your grade is: C");
        }
        else if(avg > 50 && avg <= 65){
            System.out.println("Your grade is: D");
        }
        else{
            System.out.println("Your grade is: E");
        }
        
    }
}