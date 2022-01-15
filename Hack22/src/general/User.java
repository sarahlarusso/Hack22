package general;

public class User {
    //User name
    private String name;
    //User password
    private String password;

    /**
     * Creates a new User
     * @param name the specified User's name
     * @param password the specified User's password
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Finds the name of this User
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Finds the password of this User
     * @return this.password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Resets password
     * @param password that take in a new password string
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Resets the name of this User
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
