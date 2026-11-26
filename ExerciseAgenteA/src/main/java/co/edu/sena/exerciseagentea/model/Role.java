package co.edu.sena.exerciseagentea.model;

/**
 * Fecha: 26/11/2026
 * @author luilonmu
 * Objetivo: modelo rol
 */
public class Role
{
    private int id;
    private String name;

    public Role() {
    }

    public Role(int id, String name) 
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
