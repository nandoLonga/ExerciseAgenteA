package co.edu.sena.exerciseagentea.model;

/**
 * Fecha: 29/10/2026
 * @author luilonmu
 * Objetivo: Modelo línea
 */
public class Line 
{
    private int id;
    private String name;

    public Line() 
    {
    }

    public Line(int id, String name) 
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
