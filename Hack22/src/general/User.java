package general;

public class User {
    String name;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    /** used to reset password
     * @param password that take in a new password string
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;

    }



}
