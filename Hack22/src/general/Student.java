package general;

public class Student extends User{

    //The School for this Student
    private School school;
    //The age of this Student
    private int age;
    //The list of Category preferences for this Student
    private final HashList<Category> preferences;

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
        this.preferences = new HashList<>();
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

    /**
     * Adds a Category to this Student's preferences
     * @param preference the specified Category preference
     * @return false if the Category already existed in this Student's preferences, else true
     */
    public boolean addPreference(Category preference) {
        return this.preferences.add(preference);
    }

    /**
     * Determines whether a specified Category is included in this Student's preferences
     * @param preference the target Category preference
     * @return true if the preference is contained in the list, else false
     */
    public boolean preferencesContain(Category preference) {
        return this.preferences.contains(preference);
    }

    /**
     * Removes a Category from this Student's preferences
     * @param preference the target Category preference
     * @return true if this Category previously existed in this Student's preferences, else false
     */
    public boolean removePreference(Category preference) {
        return this.preferences.remove(preference);
    }

    /**
     * Gets all Category preferences for this Student
     * @return this.preferences
     */
    public HashList<Category> getPreferences() {
        return this.preferences;
    }
}
