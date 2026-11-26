package co.edu.sena.exerciseagentea.db;

import static co.edu.sena.exerciseagentea.db.DBConnection.connection;
import static co.edu.sena.exerciseagentea.db.DBConnection.statement;
import co.edu.sena.exerciseagentea.model.Line;
import co.edu.sena.exerciseagentea.model.Role;
import co.edu.sena.exerciseagentea.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 26/11/2026
 * @author luilonmu
 * Objetivo: 
 */
public class DBRole extends DBConnection
{
    public List<Role> findAll()
   {
       List<Role> result = new ArrayList<>();
       try {
           connect();
           String query = "select * from role";
           statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next())
           {
               Role role = new Role(resultSet.getInt("id"), resultSet.getString("name"));
               result.add(role);
           }
           
           resultSet.close();
           
       } catch (SQLException e) {
           MessageUtils.getInstance().showError("Error al consultar las lineas " + e.getMessage());
       }
       finally
       {
           disconnect();
       }
       
       return result;
   }
   
   public Role find(int id)
   {
       Role role = null;
       try {
           connect();
           String query = "select * from line where id = ?";
           PreparedStatement ps = connection.prepareCall(query);
           ps.setInt(1, id);
           ResultSet resultSet = ps.executeQuery();
           
           if(resultSet.next())
           {
               role = new Role(resultSet.getInt("id"), resultSet.getString("name"));
           }
           
           resultSet.close();
           ps.close();
           
       } catch (SQLException e) {
           MessageUtils.getInstance().showError("Error al consultar las lineas " + e.getMessage());
       }
       finally
       {
           disconnect();
       }
       
       return role;
   }
}
