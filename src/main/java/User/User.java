package User;


import FarmaStore.FarmaStore;

public class User {

    private String email;
    private String password;
    static FarmaStore store = FarmaStore.getInstance();

    public void newUser(String mail, String pass){
        this.setEmail(mail);
        this.setPassword(pass);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
