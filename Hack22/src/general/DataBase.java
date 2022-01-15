package general;

public class DataBase {
    HashList<Organization> organizations;
    HashList<School> schools;
    HashList<User> users;

    public DataBase(){
        HashList<Organization> organizations = new HashList<>();
        HashList<School> schools = new HashList<>();
        HashList<User> users = new HashList<>();
    }

    /**
     * Adds a given org to the HashList of Organization
     * @param org the input organization
     */
    public boolean addOrg(Organization org){
        return organizations.add(org);
    }

    /**
     * Removes a given organization from the HashList of Organizations
     * @param org
     * @return
     */
    public boolean removeOrg(Organization org){
        return organizations.remove(org);
    }

    /**
     * Adds a given school to the HashList of Schools
     * @param school the input school
     * @return yeah it does this
     */
    public boolean addSchool(School school){
        return schools.add(school);
    }

    /**
     * Removes a given school to the HashList of Schools
     * @param school the input school
     * @return yeah it does this
     */
    public boolean removeSchool(School school){
        return schools.remove(school);
    }

    /**
     * Adds a given user to the HashList of Users
     * @param user the input user
     * @return yeah it does this
     */
    public boolean addUser(User user){
        return users.add(user);
    }

    /**
     * Removes a given user from the HashList of Users
     * @param user the nput user
     * @return yeah it does this
     */
    public boolean removeUser(User user){
        return users.remove(user);
    }


}