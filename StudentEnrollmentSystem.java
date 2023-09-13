import java.util.*;

class Student {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public String toString() {
        return "ID: " + id + " | Name: " + name;
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
        System.out.println("4. Sort Students by ID");
        System.out.println("5. Search Student by ID");
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
                sortStudentsByID();
                break;
            case 5:
                searchStudentByID();
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
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        studentList.add(new Student(name, id));
        System.out.println("Student enrolled successfully.");
    }

    private static void unenrollStudent() {
        System.out.print("Enter student ID to unenroll: ");
        int unenrollId = scanner.nextInt();
        boolean removed = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == unenrollId) {
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

    private static void sortStudentsByID() {
        Collections.sort(studentList, (s1, s2) -> Integer.compare(s1.id, s2.id));
        System.out.println("Students sorted by ID.");
    }

    private static void searchStudentByID() {
        System.out.print("Enter student ID to search: ");
        int searchId = scanner.nextInt();
        boolean found = false;
        for (Student student : studentList) {
            if (student.id == searchId) {
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