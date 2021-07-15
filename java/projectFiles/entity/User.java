package projectFiles.entity;

public class User extends BaseEntity {
    private String userName;
    private UserRole role;
    private String mailContact;
    private String login;
    private String password;

    public User(Integer id, String userName, String role, String mailContact, String login, String password) {
        super(id);
        this.userName = userName;
        this.setRole(role);
        this.mailContact = mailContact;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setRole(String role) {
        if(role.equals(UserRole.ADMIN.toString()))
            this.role = UserRole.ADMIN;
        else if(role.equals(UserRole.MANUFACTURER.toString()))
            this.role = UserRole.MANUFACTURER;
        else this.role = UserRole.USER;
    }

    public UserRole getRole() {
        return role;
    }

    public String getMailContact() {
        return mailContact;
    }

    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }

    @Override
    public String toString(){
        return "User{id=" + getId() +
                ",username=" + getUserName() +
                ",role=" + getRole() +
                ",mailcontact=" + getMailContact() +
                ",login=" + getLogin() +
                ",password=" + getPassword() + '}';
    }

}