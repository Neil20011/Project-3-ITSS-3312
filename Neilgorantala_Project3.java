import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Collections;

public class Neilgorantala_Project3{

    public static void main(String[] args) {
        //holds student information

        int choice = 0;
        int option = 0;
        int count = 0;
        String first = "";
        String last = "";
        String level = "";


        Scanner h = new Scanner(System.in); //Prompts user input

        //Asks user how many students are there
        System.out.println("Welcome to Student and Course Management System!");
        System.out.println("This system will allow you to manage students and courses. Let’s start with the number of students this system will have:");
        int num = h.nextInt();

        //Declares and initializes array
        Student[] list = new Student[num + 50];

        h.nextLine();

        //ask user information about student
        for(int a = 0; a < num; a++) {

            // Asks for first, last and grade of student

            System.out.println("Enter first name: ");
            first = h.nextLine();

            System.out.println("Enter last name: ");
            last = h.nextLine();

            System.out.println("Enter level of the student: ");
            level = h.nextLine();

            Student student = new Student();
            int ID = (int)(Math.random()*99+1);  // assigns a random student ID
            student.addStudent(ID, first, last, level, true);
            list[a] = student;

            System.out.println(first + " " + last + " has been added as a "  +level  + " with ID " + ID);
        }

        System.out.println("***Welcome to Student and Course Management System***"); // menu
        System.out.println("Press ‘1’ for Student Management System");
        System.out.println("Press ‘2’ for Course Management System");
        System.out.println("Press ‘0’ to exit");

        option = h.nextInt();

        while(option < 0 || option > 2) {
            System.out.println("Invalid option. Please enter a number between 0-2"); // menu
            option = h.nextInt();
        }

        count = num;

        while(true) {
            if(option == 1) {
                System.out.println("***Welcome to Student Management System***"); // menu
                System.out.println("Press ‘1’ to add a student");
                System.out.println("Press ‘2’ to deactivate a student");
                System.out.println("Press ‘3’ to display all students");
                System.out.println("Press ‘4’ to search for a student by ID");
                System.out.println("Press ‘5’ to assign on-campus job");
                System.out.println("Press ‘6’ to display all students with on-campus jobs");
                System.out.println("Press ‘0’ to exit the system");

                choice = h.nextInt();
                count = num;

                while(true) {
                    if(choice == 1) {
                        h.nextLine();

                        System.out.println("Enter First Name: ");
                        first = h.nextLine();

                        System.out.println("Enter Last Name: ");
                        last = h.nextLine();

                        System.out.println("Enter level of the student: ");
                        level = h.nextLine();

                        Student student = new Student();
                        int ID = (int)(Math.random()*99+1);
                        student.addStudent(ID, first, last, level, true);
                        list[count] = student;
                        count++;

                        System.out.println(first + " " + last + " has been added as a "  + level  + " with ID " + ID);
                    }
                    else if(choice == 2) {
                        System.out.println("Enter ID of student: ");
                        int ID = h.nextInt();

                        if(search(list, num + (count - num), ID) == -1) {
                            System.out.println("Student not found");
                            continue;
                        }

                        list[search(list, num + (count - num), ID)].activateStudent(false);
                        System.out.println(list[search(list, num + (count - num), ID)].getFirst
                                () + " " +
                                list[search(list, num + (count - num), ID)].getLast() + " has been deactivated.");
                    }       // deactivates the desired student when asked what the ID is
                    else if(choice == 3) {
                        displayStudents(list, num + (count - num));
                    }
                    else if(choice == 4) {
                        System.out.println("Enter ID of student:");
                        int ID = h.nextInt();

                        if(search(list, num + (count - num), ID) == -1) {
                            System.out.println("Student not found");  // if ID is not found then it displays "student not found"
                            continue;
                        }

                        list[search(list, num + (count - num), ID)].display();
                    }
                    else if(choice == 5) {
                        System.out.println("Enter student ID: ");
                        int ID = h.nextInt();

                        h.nextLine();

                        System.out.println("Enter job: ");
                        String job = h.nextLine();

                        System.out.println("Enter job type: ");
                        String jobType = h.nextLine();

                        list[search(list, num + (count - num), ID)].addJob(job, jobType);
                        System.out.println(list[search(list, num + (count - num), ID)].getFirst() + " " +
                                list[search(list, num + (count - num), ID)].getLast() + " has been assigned " +
                                jobType + " " + job + " job.");
                    }
                    else if(choice == 6) {
                        displayEmployedStudents(list, num + (count - num));
                    }
                    else {
                        break;
                    }

                    System.out.println("***Welcome to Student Management System***");
                    System.out.println("Press ‘1’ to add a student");
                    System.out.println("Press ‘2’ to deactivate a student");
                    System.out.println("Press ‘3’ to display all students");
                    System.out.println("Press ‘4’ to search for a student by ID");
                    System.out.println("Press ‘5’ to assign on-campus job");
                    System.out.println("Press ‘6’ to display all students with on-campus jobs");
                    System.out.println("Press ‘0’ to exit the system");

                    choice = h.nextInt();
                }
            }
            else if(option == 2) {
                System.out.println("***Welcome to Course Management System***");
                System.out.println("Press ‘1’ to add a new course");
                System.out.println("Press ‘2’ to assign student a new course");
                System.out.println("Press ‘3’ to display student with assigned courses");
                System.out.println("Press ‘0’ to exit Course Management System");
                choice = h.nextInt();

                while(true) {
                    if(choice == 1) {
                        Course course = new Course();

                        System.out.println("Enter course ID: ");
                        int ID = h.nextInt();

                        h.nextLine();

                        System.out.println("Enter course name: ");
                        String name = h.nextLine();

                        course.newCourse(name, ID);
                        System.out.println("Confirmation: New course " + ID + " has been added");
                    }
                    else if(choice == 2) {
                        System.out.println("Enter student ID: ");
                        int ID = h.nextInt();

                        System.out.println("Enter course ID: ");
                        int courseID = h.nextInt();

                        list[search(list, num + (count - num), ID)].addCourse(courseID);
                        System.out.println("Confirmation: " + list[search(list, num + (count - num), ID)].getFirst() + " " +
                                list[search(list, num + (count - num), ID)].getLast() +
                                " has been assigned course " + courseID);
                    }
                    else if(choice == 3) {
                        displayStudentCourses(list, num + (count - num));
                    }
                    else {
                        break;
                    }

                    System.out.println("***Welcome to Course Management System***");
                    System.out.println("Press ‘1’ to add a new course");
                    System.out.println("Press ‘2’ to assign student a new course");
                    System.out.println("Press ‘3’ to display student with assigned courses");
                    System.out.println("Press ‘0’ to exit Course Management System");
                    choice = h.nextInt();
                }
            }
            else {
                System.out.println("Exited");
                System.exit(0);
            }

            System.out.println("***Welcome to Student and Course Management System***");
            System.out.println("Press ‘1’ for Student Management System");
            System.out.println("Press ‘2’ for Course Management System");
            System.out.println("Press ‘0’ to exit");
            option = h.nextInt();

            while(option < 0 || option > 2) {
                System.out.println("Error. Choose a number between 0-2");
                option = h.nextInt();
            }
        }
    }

    //Returns the index of the student in the array
    public static int search(Student[] list, int num, int ID) {
        for(int a = 0; a < num; a++) {
            if(list[a].getId() == ID) {
                return a;
            }
        }

        //Returns -1 if student is not found
        return -1;
    }

    //Displays students in order
    public static void displayStudents(Student[] list, int num) {
        ArrayList<String> first = new ArrayList<>();
        Student[] List = new Student[num];

        for(int a = 0; a < num; a++) {
            first.add(list[a].getFirst());
        }

        Collections.sort(first);

        for(int a = 0; a < num; a++) {
            for(int b = 0; b < num; b++) {
                if(list[b].getFirst().equals(first.get(a)) && list[b].getStatus()) {
                    list[b].display();
                }
            }

            System.out.println("----------------------");
        }

        for(int a = 0; a < num; a++) {

            try {
                FileWriter myWriter = new FileWriter("StudentReport.txt");
                myWriter.write(list[a].getFirst() + " " + list[a].getLast());
                myWriter.close();

            }
            catch (IOException f) {
                System.out.println("Error occurred.");
                f.printStackTrace();
            }
        }
    }

    public static void displayEmployedStudents(Student[] list, int num) {
        for(int a = 0; a < num; a++) {
            if(list[a].hasJob()) {
                System.out.println(list[a].getFirst() + " " + list[a].getLast());
                System.out.println("ID - " + list[a].getId());
                System.out.println(list[a].getJob() + " " + list[a].getJob());
            }
        }
    }

    private static void displayStudentCourses(Student[] list, int num) {
        for(int a = 0; a < num; a++) {
            System.out.println(list[a].getFirst() + " " + list[a].getLast());
            System.out.println("ID - " + list[a].getId());
            list[a].displayListofCourses();
        }
    }
}

