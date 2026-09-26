package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {


    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        int max_age =0;
        Student oldest =null;
        for(Student s:students){
            if(s.getAge()>max_age){
                max_age =s.getAge();
                oldest =s;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count=0;
        for(Student s:students){
            if(s.isAdult()) count++;
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double avg=0;
        if(students.length==0) return Double.NaN;
        for(Student s:students) avg+=s.getGrade();
        avg/=students.length;
        return avg;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        Student result =null;
        for(Student s:students){
            if (name.equalsIgnoreCase(s.getName())) {
                result = s;
                break;
            }
        }
        return result;

    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for(int i=0;i<students.length;i++){
            for(int j=0;j<students.length-i-1;j++){
                if(students[j+1].getGrade()>students[j].getGrade()) {
                    Student temp = students[j+1];
                    students[j+1] = students[j];
                    students[j] =temp;
                }
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student s:students){
            if(s.getGrade()>=15){
                System.out.println(s.toString());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student s:students){
            if(s.getId()==id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        int count =0;
        int i=0;
        while(i<students.length){
            for(Student s:students){
                if(s.getName().equalsIgnoreCase(students[i].getName())) count++;
            }
            i++;
        }
        if(count> students.length){
            System.out.println("Duplicates found");
            return true;
        }
        return false;

    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents =new Student[students.length+1];
        for(int i=0;i<students.length;i++) newStudents[i] =students[i];
        newStudents[students.length] =newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1,"Bob");
        arr[1] = new Student(2,"Sam",20);
        arr[2] =new Student(3,"Lin");
        arr[3] = new Student(4,"Lara",19,15);
        arr[4] = new Student(5,"Liz",20);


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("The oldest student is: "+findOldest(arr).toString());

        // 3) Count adults
        System.out.println("The number of adult students is: "+countAdults(arr));

        // 4) Average grade
        System.out.println("The average grade of the class is: "+averageGrade(arr));

        // 5) Find by name
        System.out.println("Check if there is a student named Liz: "+findStudentByName(arr,"Liz"));
        System.out.println("Check if there is a student named Mohammed: "+findStudentByName(arr,"Mohammed"));
        System.out.println("Check if there is a student named Dina: "+findStudentByName(arr, "Dina"));


        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        sortByGradeDesc(arr);
        for (Student s : arr) System.out.println(s);


        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated =updateGrade(arr,4,15);
        System.out.println("\nUpdated id=4? " + updated);



        // 9) Duplicate names
        System.out.println("Are there duplicate names? "+(hasDuplicateNames(arr)?"yes":"no"));


        // 10) Append new student
        Student[] newArr =appendStudent(arr,new Student(6,"Sami"));
        System.out.println("== All Students ==");
        for (Student s : newArr) System.out.println(s);

    }
}

