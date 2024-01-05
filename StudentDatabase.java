import java.util.ArrayList;
import java.util.Scanner;

// Custom exception class for handling negative marks
class NegativeMarksException extends Exception {
    public NegativeMarksException(String message) {
        super(message);
    }
}

// Custom exception class for handling invalid roll numbers
class InvalidRollNumberException extends Exception {
    public InvalidRollNumberException(String message) {
        super(message);
    }
}

// Student class to represent student attributes
class Student {
    private String name;
    private int rollNumber;
    private int age;
    double marks;

    public Student(String name, int rollNumber, int age, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.marks = marks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}

public class StudentDatabase {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Database Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Roll Number: ");
                        int rollNumber = scanner.nextInt();

                        if (isRollNumberExists(studentList, rollNumber)) {
                            System.out.println("Roll Number already exists. Please enter a unique Roll Number.");
                            break;
                        }

                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();

                        System.out.print("Enter Marks: ");
                        double marks = scanner.nextDouble();

                        if (marks < 0) {
                            throw new NegativeMarksException("Marks cannot be negative.");
                        }

                        Student student = new Student(name, rollNumber, age, marks);
                        studentList.add(student);
                        System.out.println("Student added successfully.");
                    } catch (NegativeMarksException e) {
                        System.out.println("Error: " + e.getMessage())                    }
                    break;

                case 2:
                    System.out.println("List of Students:");
                    for (Student student : studentList) {
                        student.displayDetails();
                        System.out.println("---------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRollNumber = scanner.nextInt();
                    boolean found = false;

                    for (Student student : studentList) {
                        if (student.getRollNumber() == searchRollNumber) {
                            student.displayDetails();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student with Roll Number " + searchRollNumber + " not found.");
                    }
                    break;

                case 4:
                    if (studentList.isEmpty()) {
                        System.out.println("No students in the database.");
                    } else {
                        double totalMarks = 0;
                        for (Student student : studentList) {
                            totalMarks += student.marks;
                        }
                        double averageMarks = totalMarks / studentList.size();
                        System.out.println("Average Marks of all students: " + averageMarks);
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    // Function to check if a roll number already exists in the database
    private static boolean isRollNumberExists(ArrayList<Student> studentList, int rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                return true;
            }
        }
        return false;
    }
}