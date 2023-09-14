import java.util.*;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name;
    }
}

public class StudentEnrollmentSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            processChoice(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("\nStudent Enrollment System Menu:");
        System.out.println("1. Enroll Student");
        System.out.println("2. Unenroll Student");
        System.out.println("3. Print All Students");
        System.out.println("4. Sort Students by Name"); // Updated option label
        System.out.println("5. Search Student by Name"); // Updated option label
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                enrollStudent();
                break;
            case 2:
                unenrollStudent();
                break;
            case 3:
                printAllStudents();
                break;
            case 4:
                sortStudentsByName(); // Updated method call
                break;
            case 5:
                searchStudentByName(); // Updated method call
                break;
            case 6:
                System.out.println("Exiting the program.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void enrollStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        studentList.add(new Student(name));
        System.out.println("Student enrolled successfully.");
    }

    private static void unenrollStudent() {
        System.out.print("Enter student name to unenroll: ");
        String unenrollName = scanner.nextLine();
        boolean removed = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).name.equalsIgnoreCase(unenrollName)) {
                studentList.remove(i);
                removed = true;
                System.out.println("Student unenrolled successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found.");
        }
    }

    private static void printAllStudents() {
        System.out.println("List of enrolled students:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void sortStudentsByName() {
        Collections.sort(studentList, (s1, s2) -> s1.name.compareToIgnoreCase(s2.name)); // Sort by name
        System.out.println("Students sorted by Name.");
    }

    private static void searchStudentByName() {
        System.out.print("Enter student name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Student student : studentList) {
            if (student.name.equalsIgnoreCase(searchName)) {
                System.out.println("Student found: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
