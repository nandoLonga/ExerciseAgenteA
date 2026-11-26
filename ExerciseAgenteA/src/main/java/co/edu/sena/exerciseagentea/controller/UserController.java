package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.db.DBUser;
import co.edu.sena.exerciseagentea.model.User;
import java.util.List;
/**
 * Fecha: 26/11/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public class UserController implements IUserController
{   private DBUser dbUser = new DBUser();
    
    @Override
    public void insert(User user) throws Exception 
    {
        if(user == null)
        {
            throw new Exception("El galpon está vacío");
        }
        
        if(user.getDocument() == 0)
        {
            throw new Exception("El documento está vacío");
        }
        
        if("".equals(user.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(user.getEmail()))
        {
            throw new Exception("El correo es obligatorio");
        }
        
        if("".equals(user.getPassword()))
        {
            throw new Exception("la contraseña es obligatorio");
        }
        
        if(user.getRole() == null)
        {
            throw new Exception("El rol es obligatorio");
        }
        //insertar
        dbUser.insert(user);
    }

    @Override
    public void update(User user) throws Exception 
    {
        if(user == null)
        {
            throw new Exception("El galpon está vacío");
        }
        
        if(user.getDocument() == 0)
        {
            throw new Exception("El documento está vacío");
        }
        
        if("".equals(user.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(user.getEmail()))
        {
            throw new Exception("El correo es obligatorio");
        }
        
        if("".equals(user.getPassword()))
        {
            throw new Exception("la contraseña es obligatorio");
        }
        
        if(user.getRole() == null)
        {
            throw new Exception("El rol es obligatorio");
        }
        
        User userExist = find(user.getId());
        if(userExist == null)
        {
            throw new Exception ("No existe el registro a actualizar");
        }
        
        dbUser.update(user);
    }

    @Override
    public void delete(int id) throws Exception 
    {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        User userExist = find(id);
        if(userExist == null)
        {
            throw new Exception ("No existe el registro a eliminar");
        }
        
        dbUser.delete(id);
    }

    @Override
    public User find(int id) throws Exception 
    {
        if(id == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
       
        return dbUser.find(id);
    }

    @Override
    public List<User> findAll() throws Exception 
    {
        return dbUser.findAll();
    }
}
