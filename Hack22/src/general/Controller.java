package general;

import java.io.IOException;

public class Controller {

    private static HashList<Organization> orgs; // orgs from .txt file
    private static HashList<School> schools; // schools from .txt file
    private static Student stud; // this student

    /**
     * parses .txt files to create all of the saved schools and saved organizations
     * @throws IOException if file is not found
     */
    public static void initialize() throws IOException {
        orgs = OrgParser.parseFile("Organizations.txt");
        schools = SchoolParser.parseFile("Schools.txt");
    }

    /**
     * Creates a student object (assumes age 16)
     * @param name of user given by user
     * @param password for user given by user
     * @param sch school that the user is from, selected by user
     */
    public static void setStudent(String name, String password, School sch){
        stud = new Student(name, password, sch, 16);

    }

    /**
     *
     * adds preferences to this student
     * @param c
     */
    public static void updatePreferences(Category c){
        stud.addPreference(c);
    }

    /**
     *
     * @return HashList of all of the schools
     */
    public static HashList<School> getSchools(){
        return schools;
    }

    /**
     *
     * @return hashlist of all of the organizations meeting the needs of the student
     */
    public static HashList<Organization> getRecs(){
        return stud.getPreferredOrganizations("", orgs);
    }


}
