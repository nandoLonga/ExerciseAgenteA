package co.edu.sena.exerciseagentea.db;

/**
 * Fecha: 25/11/2026
 * @author luilonmu
 * Objetivo: Clase para conexion a base de datos
 */
public class TestConnection 
{
    public static void main(String[] args) 
    {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        dbc.disconnect();
    }
}
