package co.edu.sena.exerciseagentea.model;

/**
 * Fecha: 26/11/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public class User
{
    private int id;
    private long document;
    private String fullname;
    private String email;
    private String password;
    private Role role;
    private String status;

    public User()
    {
        
    }

    public User(int id, long document, String fullname, String email, String password, Role role, String status) 
    {
        this.id = id;
        this.document = document;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
