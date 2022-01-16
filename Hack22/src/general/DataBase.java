package general;

public class DataBase {
    HashList<Organization> organizations;
    HashList<School> schools;
    HashList<User> users;

    /**
     * Creates an empty DataBase
     */
    public DataBase() {
        this.organizations = new HashList<>();
        this.schools = new HashList<>();
        this.users = new HashList<>();
    }

    /**
     * Adds a given org to the HashList of Organization
     * @param organization the input Organization
     * @return true if the Organization was successfully added, else false
     */
    public boolean addOrganization(Organization organization) {
        return this.organizations.add(organization);
    }

    /**
     * Removes a given Organization from the HashList of Organizations
     * @param organization the input Organization
     * @return true if an instance of the specified Organization was successfully removed, else false
     */
    public boolean removeOrganization(Organization organization) {
        return this.organizations.remove(organization);
    }

    /**
     * Adds a given School to the HashList of Schools
     * @param school the input School
     * @return true if the School was successfully added, else false
     */
    public boolean addSchool(School school) {
        return this.schools.add(school);
    }

    /**
     * Removes a given School to the HashList of Schools
     * @param school the input School
     * @return true if an instance of the specified School was successfully removed, else false
     */
    public boolean removeSchool(School school) {
        return this.schools.remove(school);
    }

    /**
     * Adds a given User to the HashList of Users
     * @param user the input User
     * @return true if the User was successfully added, else false
     */
    public boolean addUser(User user) {
        return this.users.add(user);
    }

    /**
     * Removes a given User from the HashList of Users
     * @param user the input User
     * @return true if an instance of the specified User was successfully removed, else false
     */
    public boolean removeUser(User user) {
        return this.users.remove(user);
    }
}