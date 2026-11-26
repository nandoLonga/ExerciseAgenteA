package co.edu.sena.exerciseagentea.db;

import co.edu.sena.exerciseagentea.model.Role;
import co.edu.sena.exerciseagentea.model.User;
import co.edu.sena.exerciseagentea.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 25/11/2026
 * @author luilonmu
 * Objetivo: Clase para conexion a tabla role
 */
public class DBUser extends DBConnection
{
    public void insert(User user)
    {
        try{
            connect();  
            String sql = "Insert into user values (null, ?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, user.getDocument());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole().getId());
            ps.setString(6, user.getStatus());
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException e){
            MessageUtils.getInstance().showError("Error al insertar al usuario " + e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
    public void update (User user)
    {
        try{
            connect();  
            String sql = "update user set document = ?, fullname = ?, email = ?, password = ?, status = ?, role_id = ?, where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            int position = 0;
            ps.setLong(++position, user.getDocument());
            ps.setString(++position, user.getFullname());
            ps.setString(++position, user.getEmail());
            ps.setString(++position, user.getPassword());
            ps.setInt(++position, user.getRole().getId());
            ps.setString(++position, user.getStatus());
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException e){
            MessageUtils.getInstance().showError("Error al modificar el usuario " + e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
     public void delete (int id)
    {
        try{
            connect();  
            String sql = "delete from user where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException e){
            MessageUtils.getInstance().showError("Error al eliminar la línea " + e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
   public List<User> findAll()
   {
       List<User> result = new ArrayList<>();
       try {
           connect();
           String query = "select * from user, role where user.role_id = role.id";
           statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next())
           {
               Role role = new Role (resultSet.getInt(8), resultSet.getString("name"));
               
               User user = new User();
               user.setId(resultSet.getInt("id"));
               user.setDocument(resultSet.getLong("document"));
               user.setFullname(resultSet.getString("fullname"));
               user.setEmail(resultSet.getString("email"));
               user.setPassword(resultSet.getString("password"));
               user.setStatus(resultSet.getString("status"));
               user.setRole(role);
 
               result.add(user);
           }
           
           resultSet.close();
           
       } catch (SQLException e) {
           MessageUtils.getInstance().showError("Error al consultar el usuario " + e.getMessage());
       }
       finally
       {
           disconnect();
       }
       
       return result;
   }
   
   public User find(int id)
   {
       User user = null;
       try {
           connect();
           String query = "select * from user, role where user.role_id = role.id";
           PreparedStatement ps = connection.prepareCall(query);
           ps.setInt(1, id);
           ResultSet resultSet = ps.executeQuery();
           
           if(resultSet.next())
           {
               Role role = new Role (resultSet.getInt(8), resultSet.getString("name"));
               
               user = new User();
               user.setId(resultSet.getInt("id"));
               user.setDocument(resultSet.getLong("document"));
               user.setFullname(resultSet.getString("fullname"));
               user.setEmail(resultSet.getString("email"));
               user.setPassword(resultSet.getString("password"));
               user.setStatus(resultSet.getString("status"));
               user.setRole(role);
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
       
       return user;
   }

}
