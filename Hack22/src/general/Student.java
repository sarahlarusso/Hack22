package general;

public class Student extends User{

    //The School for this Student
    private School school;
    //The age of this Student
    private int age;

    /**
     * Creates a new Student
     * @param name the Student's name
     * @param password the Student's system password
     * @param school the Student's School
     * @param age the Student's age
     */
    public Student(String name, String password, School school, int age) {
        super(name, password);
        school.addStudent(this);
        this.school = school;
        this.age = age;
    }

    /**
     * Resets the age of this Student
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the age of this Student
     * @return this.age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Resets the School for this Student
     * @param school the new School
     */
    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * Gets the School for this Student
     * @return this.school
     */
    public School getSchool() {
        return this.school;
    }
}
