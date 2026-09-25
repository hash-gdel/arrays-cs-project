package samplearrays;
import java.util.Arrays;

public class CourseNumbersArray {
    public static int[] updateCourses(int[] registeredCourses,int course){
        int[] updatedCourses = new int[registeredCourses.length+1];
        for(int i=0;i<registeredCourses.length;i++){
            updatedCourses[i]=registeredCourses[i];
        }
        updatedCourses[registeredCourses.length] =course;
        return updatedCourses;
    }
    public static boolean checkCourse(int[] courses,int course){
        for(int x : courses){
            if(x ==course) {return true;}

        }
        return false;
    }
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = updateCourses(registeredCourses,3100);
        System.out.println("Courses : "+ Arrays.toString(updatedCourses));
        System.out.println(CourseNumbersArray.checkCourse(updatedCourses,3080));
        System.out.println(CourseNumbersArray.checkCourse(updatedCourses,1010));


    }
}
