public class Student {
    //Declares variables
    private int[] courseList;
    private int id, count;
    private String level, first, last, type, job;
    private boolean active, hasJob;

    //initializes variables
    public Student() {
        courseList = new int[30];
        level = "";
        id = 0;
        count = 0;
        first = "";
        last = "";
        type = "";
        active = false;
        job = "";
        hasJob = false;

    }

    //Returns first name
    public String getFirst() {

        return first;
    }

    //Returns last name
    public String getLast() {

        return last;
    }

    //Returns student ID
    public int getId() {

        return id;
    }


    //Method to add new student
    public void addStudent(int id, String first, String last, String level, boolean active) {
        this.first = first;
        this.last = last;
        this.level = level;
        this.active = active;
        this.id = id;
    }

    //Method to set a student to active or inactive
    public void activateStudent(boolean active) {

        this.active = active;
    }

    //Method to return active status of student
    public boolean getStatus() {

        return active;
    }

    public void addCourse(int courseID) {
        courseList[count] = courseID;
        count++;
    }

    public void addJob(String job, String Type) {
        this.job = job;
        this.type = type;
        hasJob = true;
    }

    public String getJob() {

        return job;
    }

    public String getType() {

        return type;
    }

    public boolean hasJob() {

        return hasJob;
    }

    public void displayListofCourses() {
        System.out.println("Courses:");

        for(int a = 0; a < count; a++) {
            System.out.println(courseList[a]);
        }
    }

    //Display the single Student
    public void display() {
        System.out.println("");
        System.out.println("Student ID: " + id);
        System.out.println("");
        System.out.println("Name: " + first + " " + last);
        System.out.println("");
        System.out.println("Student Level: " + level);
        System.out.println("");
        System.out.println("Active: " + active);
        System.out.println("");
    }
}

