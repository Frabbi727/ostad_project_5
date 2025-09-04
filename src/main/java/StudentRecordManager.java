import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRecordManager {

    public static Student findLowestCGPAStudent(List<Student> students) {
        if (students.isEmpty()) {
            return null;
        }

        Student lowestCGPAStudent = students.getFirst();
        for (Student student : students) {
            if (student.getCgpa() < lowestCGPAStudent.getCgpa()) {
                lowestCGPAStudent = student;
            }
        }
        return lowestCGPAStudent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");

            long id;
            while (true) {
                try {
                    System.out.print("ID (must be a number): ");
                    id = Long.parseLong(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for ID.");
                }
            }

            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();

            System.out.print("Blood Group: ");
            String bloodGroup = scanner.nextLine();

            float cgpa;
            while (true) {
                try {
                    System.out.print("CGPA (must be a decimal number): ");
                    cgpa = Float.parseFloat(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid decimal number for CGPA.");
                }
            }

            students.add(new Student(id, fullName, bloodGroup, cgpa));
        }

        System.out.print("Enter query string: ");
        String query = scanner.nextLine();

        System.out.println("\nMatching students:");
        boolean foundMatches = false;
        for (Student student : students) {
            if (student.matchesCriteria(query)) {
                student.print();
                foundMatches = true;
            }
        }

        if (!foundMatches) {
            System.out.println("No students found matching the criteria.");
        }

        Student lowestCGPAStudent = findLowestCGPAStudent(students);
        if (lowestCGPAStudent != null) {
            System.out.println("\nStudent with lowest CGPA:");
            lowestCGPAStudent.print();
        }

        scanner.close();
    }
}