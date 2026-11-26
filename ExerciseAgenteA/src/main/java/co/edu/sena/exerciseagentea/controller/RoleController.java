package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.db.DBRole;
import co.edu.sena.exerciseagentea.model.Role;
import java.util.List;

/**
 * Fecha: 26/11/2026
 * @author luilonmu
 * Objetivo: Controller rol
 */
public class RoleController implements IRoleController
{
    private DBRole dbRole = new DBRole();

    @Override
    public Role find(int id) throws Exception 
    {

        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
       
        return dbRole.find(id);    }

    @Override
    public List<Role> findAll() throws Exception 
    {
        return dbRole.findAll();
    }
    
}
