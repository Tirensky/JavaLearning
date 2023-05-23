package atm;

public class User {
    private String name;
    private boolean isSignUp = false;
    private boolean admin = false;

    public User(String name) {
        this.name = name;
    }

    public void sighUp() {
        isSignUp = true;
    }

    public boolean logIn() {
        return isSignUp;
    }

    public void setAdminAllow(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getName() {
        return name;
    }
}
