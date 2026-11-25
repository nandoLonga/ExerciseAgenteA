package co.edu.sena.exerciseagentea.db;

import co.edu.sena.exerciseagentea.model.Line;
import co.edu.sena.exerciseagentea.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 25/11/2026
 * @author luilonmu
 * Objetivo: Clase para conexion a tabla line
 */
public class DBLine extends DBConnection
{
    public void insert(Line line)
    {
        try{
            connect();  
            String sql = "Insert into line (name) values (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, line.getName());
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException e){
            MessageUtils.getInstance().showError("Error al insertar la línea" + e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
    public void update (Line line)
    {
        try{
            connect();  
            String sql = "update line set name = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, line.getName());
            ps.setInt(2, line.getId());
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException e){
            MessageUtils.getInstance().showError("Error al modificar la línea " + e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
     public void update (int id)
    {
        try{
            connect();  
            String sql = "delete from line where id = ?";
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
    
   public List<Line> findAll()
   {
       List<Line> result = new ArrayList<>();
       try {
           connect();
           String query = "select * from line";
           statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next())
           {
               Line line = new Line(resultSet.getInt("id"), resultSet.getString("name"));
               result.add(line);
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
   
   public Line find(int id)
   {
       Line line = null;
       try {
           connect();
           String query = "select * from line where id = ?";
           PreparedStatement ps = connection.prepareCall(query);
           ps.setInt(1, id);
           ResultSet resultSet = ps.executeQuery();
           
           if(resultSet.next())
           {
               line = new Line(resultSet.getInt("id"), resultSet.getString("name"));
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
       
       return line;
   }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
}
