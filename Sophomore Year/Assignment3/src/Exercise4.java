import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter grade percentage: ");
        int gradePercentage = input.nextInt();

        String letterGrade;

        if (gradePercentage >= 93 && gradePercentage <= 100) {
            letterGrade = "A";
        } else if (gradePercentage >= 90 && gradePercentage <= 92) {
            letterGrade = "A-";
        } else if (gradePercentage >= 88 && gradePercentage <= 89) {
            letterGrade = "B+";
        } else if (gradePercentage >= 84 && gradePercentage <= 87) {
            letterGrade = "B";
        } else if (gradePercentage >= 80 && gradePercentage <= 83) {
            letterGrade = "B-";
        } else if (gradePercentage >= 78 && gradePercentage <= 79) {
            letterGrade = "C+";
        } else if (gradePercentage >= 74 && gradePercentage <= 77) {
            letterGrade = "C";
        } else if (gradePercentage >= 70 && gradePercentage <= 73) {
            letterGrade = "C-";
        } else if (gradePercentage >= 68 && gradePercentage <= 69) {
            letterGrade = "D+";
        } else if (gradePercentage >= 64 && gradePercentage <= 66) {
            letterGrade = "D";
        } else if (gradePercentage >= 60 && gradePercentage <= 63) {
            letterGrade = "D-";
        } else {
            letterGrade = "F";
        }

        System.out.println("Your letter grade is: " + letterGrade);
    }
}
