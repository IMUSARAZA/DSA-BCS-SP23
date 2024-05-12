
import java.util.Scanner;

public class Driverer {
    static Scanner sc = new Scanner(System.in);
    static Scanner scDouble = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("What do you want to calculate?");
        System.out.println("1)CGPA");
        System.out.println("2)GPA");
        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("Your cgpa is: " + cgpaCalculator());
                break;

            case 2:
                System.out.println("Your gpa is: " + gpaCalculator());
                break;

            default:
                System.out.println("Invaid option");
        }
    }

    public static double cgpaCalculator(){
        System.out.println("Enter the number of semesters you have cleared: ");
        int semNumber = sc.nextInt();
        int semesters = semNumber;
        double total = 0;
        while(semNumber > 0){
            System.out.printf("Enter gpa of %d semester: ", semNumber);
            double gpa = scDouble.nextDouble();
            total = total + gpa;
            semNumber--;
        }
        return total/semesters;
    }

    public static double gpaCalculator(){
        System.out.println("How many subjects did you study in this semester?");
        int subjectNum = sc.nextInt();
        double totalGpa = 0;
        int totalCreditHours = 0;
        double gpaIn1Subject = 0;

        while(subjectNum > 0){
            System.out.println("Enter name of subject: ");
            String subjectName = scString.nextLine();

            System.out.println("Enter your marks in " + subjectName);
            int marks = sc.nextInt();

            System.out.println("Enter credit hours of " + subjectName);
            int creditHours = sc.nextInt();
            totalCreditHours = totalCreditHours + creditHours;

            gpaIn1Subject = calculatingGPA(marks) * creditHours;
            totalGpa = totalGpa + gpaIn1Subject;

            subjectNum--;

            System.out.println("Your grade in " + subjectName);
            System.out.println(grade(marks));
        }
        return totalGpa/totalCreditHours;
    }

    public static double calculatingGPA(int marks){
        String grade;
        if(marks >= 85 && marks <= 100){
            grade = "A";
            return 4.0;
        }
        else if(marks >= 80 && marks <= 84){
            grade = "A-";
            return 3.66;
        }
        else if(marks >= 75 && marks <= 79){
            grade = "B+";
            return 3.33;
        }
        else if(marks >= 71 && marks <= 74){
            grade = "B";
            return 3.0;
        }
        else if(marks >= 68 && marks <= 70){
            grade = "B-";
            return 2.66;
        }
        else if(marks >= 64 && marks <= 67){
            grade = "C+";
            return 2.33;
        }
        else if(marks >= 61 && marks <= 63){
            grade = "C";
            return 2.0;
        }
        else if(marks >= 58 && marks <= 60){
            grade = "C-";
            return 1.66;
        }
        else if(marks >= 54 && marks <= 57){
            grade = "D+";
            return 1.3;
        }
        else if(marks >= 50 && marks <= 53){
            grade = "D";
            return 1.0;
        }
        else{
            grade = "F";
            return 0.0;
        }
    }

    public static String grade(int marks){
        if(marks >= 85 && marks <= 100){
            return "A";
        }
        else if(marks >= 80 && marks <= 84){
            return "A-";
        }
        else if(marks >= 75 && marks <= 79){
            return "B+";
        }
        else if(marks >= 71 && marks <= 74){
            return "B";
        }
        else if(marks >= 68 && marks <= 70){
            return "B-";
        }
        else if(marks >= 64 && marks <= 67){
            return "C+";
        }
        else if(marks >= 61 && marks <= 63){
            return "C";
        }
        else if(marks >= 58 && marks <= 60){
            return "C-";
        }
        else if(marks >= 54 && marks <= 57){
            return "D+";
        }
        else if(marks >= 50 && marks <= 53){
            return "D";
        }
        else{
            return "F";
        }
    }

}
