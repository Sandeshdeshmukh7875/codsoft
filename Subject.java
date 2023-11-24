                                   
import java.util.Scanner;

class Subject {
    private String name;
    private int marks;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        Subject[] subjects = new Subject[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            String subjectName = scanner.next();

            subjects[i] = new Subject(subjectName);

            System.out.print("Enter marks for " + subjects[i].getName() + " (out of 100): ");
            int subjectMarks = scanner.nextInt();

            subjects[i].setMarks(subjectMarks);
            totalMarks += subjectMarks;
        }

        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);

        String grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
