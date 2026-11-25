package co.edu.sena.exerciseagentea.db;

import co.edu.sena.exerciseagentea.utils.MessageUtils;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fecha: 25/11/2026
 * @author luilonmu
 * Objetivo: Clase para conexion a base de datos
 */
public class DBConnection 
{
    public static Connection connection;
    public static Statement statement;
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DATABASE_NAME = "agentea_db";
    private final String USER = "root";
    private final String PASSWORD = "root";
    
    public void connect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME, USER, PASSWORD);
            IO.println("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME);
            statement = connection.createStatement();
            IO.println("Conectado...");
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
        {
            MessageUtils.getInstance().showError("Error de conexión a la base de datos " + e.getMessage());
        }
    }
    
    public void disconnect()
    {
        try
        {
            if(statement != null)
            {
                statement.close();
            }
            if(connection != null)
            {
                connection.close();
            }
            IO.println("Desconectado...");
        }catch(SQLException e){
            MessageUtils.getInstance().showError("Error desconectándose de la base de datos" + e.getMessage());
        }
    }
}
