import java.util.ArrayList;
import java.util.Scanner; 

public class StudentGrades {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();

        System.out.println("\n========================================");
        System.out.println("       STUDENT GRADE TRACKER");
        System.out.println("          JAVA PROJECT");
        System.out.println("========================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Please enter a valid number!");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {

            System.out.println("\n--- Student " + (i + 1) + " ---");

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks (0-100): ");
            double mark = sc.nextDouble();
            sc.nextLine();

            while (mark < 0 || mark > 100) {
                System.out.print(
                    "Invalid marks! Enter marks from 0 to 100: "
                );
                mark = sc.nextDouble();
                sc.nextLine();
            }

            names.add(name);
            marks.add(mark);
        }

        double total = 0;
        double highest = marks.get(0);
        double lowest = marks.get(0);
        int topIndex = 0;
        int lowIndex = 0;

        System.out.println("\n========================================");
        System.out.println("          STUDENT REPORT");
        System.out.println("========================================");

        System.out.printf("%-15s %-10s %-10s%n",
                          "NAME", "MARKS", "GRADE");
        System.out.println("----------------------------------------");

        for (int i = 0; i < n; i++) {

            double mark = marks.get(i);
            String grade;

            if (mark >= 90) {
                grade = "A+";
            } else if (mark >= 80) {
                grade = "A";
            } else if (mark >= 70) {
                grade = "B";
            } else if (mark >= 60) {
                grade = "C";
            } else if (mark >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.printf("%-15s %-10.2f %-10s%n",
                              names.get(i), mark, grade);

            total += mark;

            if (mark > highest) {
                highest = mark;
                topIndex = i;
            }

            if (mark < lowest) {
                lowest = mark;
                lowIndex = i;
            }
        }

        double average = total / n;

        System.out.println("----------------------------------------");
        System.out.println("           CLASS SUMMARY");
        System.out.println("----------------------------------------");

        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f (%s)%n",
                          highest, names.get(topIndex));
        System.out.printf("Lowest Marks  : %.2f (%s)%n",
                          lowest, names.get(lowIndex));

        System.out.println("========================================");
        System.out.println("       REPORT GENERATED SUCCESSFULLY!");
        System.out.println("========================================");

        sc.close();
    }
}