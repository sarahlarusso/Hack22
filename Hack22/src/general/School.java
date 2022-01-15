package general;

import java.util.List;

public class School {

    //The name of this School
    String name;
    //The List of Students at this School
    HashList<Student> students;

    /**
     * Creates a new School
     */
    public School() {
        setName("");
        this.students = new HashList<>();
    }

    /**
     * Creates a new School
     * @param name the name
     */
    public School(String name, Iterable<Student> students) {
        setName(name);
        this.students = new HashList<>(students);
    }

    /**
     * Resets the name of this School
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a Student to this School
     * @param student the new Student
     * @return false if the Student was already a member of this School, else false
     */
    public boolean addStudent(Student student){
        return this.students.add(student);
    }

    /**
     * Gets the List of Students at this School
     * @return this.students
     */
    public HashList<Student> getStudents() {
        return this.students;
    }
}
