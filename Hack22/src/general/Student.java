package general;

public class Student extends User{

    School school = new School();
    int age = 0;
    //User stud;

    public Student(String name, String password, School school) {
        super(name, password);
        school.addStudent(this);
        this.school = school;

    }



}
