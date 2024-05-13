import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> students;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.students = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public int getAvailableSlots() {
        return capacity - students.size();
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> courses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void registerCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void dropCourse(Course course) {
        courses.remove(course);
        course.removeStudent(this);
    }
}

public class CourseManagementSystem {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCourses();

        while (true) {
            System.out.println("\n");
            System.out.println("\nCourse Management System\n");
            System.out.println("1. Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Enrolled Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    displayAvailableCourses();
                    break;
                case 2:
                    performStudentRegistration();
                    break;
                case 3:
                    performCourseRemoval();
                    break;
                case 4:
                    displayEnrolledStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void initializeCourses() {
        courses.add(new Course("001", "Data Structures & Algorithms", "Learn DSA basics", 30, "Mon-Wed-Fri 11:00 AM"));
        courses.add(new Course("002", "C++ Programming", "Learn fundamentals of C++", 25, "Mon-Thu 7:00 PM"));
        courses.add(new Course("003", "React JS Programming", "Learn React javascript fundamentals", 25, "Wed-Sat 2:00 PM"));
    }

    private static void displayAvailableCourses() {
        System.out.println("Available Courses:");
        System.out.println("\n");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + course.getAvailableSlots());
            System.out.println();
        }
    }

    private static void performStudentRegistration() {
        System.out.println("Enter student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);
        students.add(student);

        System.out.println("Available Courses for Registration:");
        displayAvailableCourses();

        System.out.println("Enter course code to register:");
        String courseCode = scanner.nextLine();
        Course selectedCourse = findCourseByCode(courseCode);

        if (selectedCourse != null && selectedCourse.getAvailableSlots() > 0) {
            student.registerCourse(selectedCourse);
            System.out.println("Student registered successfully for course: " + selectedCourse.getCode());
        } else {
            System.out.println("Either course not found or no available slots!");
        }
    }

    private static void performCourseRemoval() {
        System.out.println("Enter student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine();  

        System.out.println("Enter course code to drop:");
        String courseCode = scanner.nextLine();

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null && student.getCourses().contains(course)) {
            student.dropCourse(course);
            System.out.println("Course dropped successfully for student: " + studentId);
        } else {
            System.out.println("Either student not found or not registered for the course!");
        }
    }

    private static void displayEnrolledStudents() {
        System.out.println("Enrolled Students:");
        for (Course course : courses) {
            System.out.println("Course: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Enrolled Students:");
            for (Student student : course.getStudents()) {
                System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName());
            }
            System.out.println();
        }
    }

    private static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
