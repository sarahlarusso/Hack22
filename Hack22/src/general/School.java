package general;

import java.util.ArrayList;

public class School {

    String name;
    ArrayList<Student> students = new ArrayList<Student>();

    public School(){
        this.name = "";
    }
    public School(String name){
        this.name = name;
    }

    public void addStudent(Student stu){
        students.add(stu);
    }

    public ArrayList getStudents(){
        return students;
    }
}
