import java.io.File;
import java.io.IOException;

public class Course {
    private String course;
    private int courseID;

    public Course() {
        course = "";
        courseID = 0;
    }

    public String getCourse(){

        return course;
    }

    public void newCourse(String course, int courseID) {
        this.course = course;
        this.courseID = courseID;

        int num = 0;
        for(int a = 0; a <= num; a++) {

            //Creates file
            try {
                File courseReport = new File("CourseReport.txt");
                if (courseReport.createNewFile()) {
                    System.out.println("New Course Report Created");
                } else {
                    System.out.println("File already exists.");
                }
            }
            catch(IOException h){
                System.out.println("Invalid");
                h.printStackTrace();
            }


        }
    }
}

