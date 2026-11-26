package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.model.Shed;
import co.edu.sena.exerciseagentea.data.DataStore;
import co.edu.sena.exerciseagentea.db.DBShed;
import java.util.List;

/**
 * Fecha: 22/10/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public class ShedController implements IShedController
{
    private DBShed dbshed = new DBShed();
    private List<Shed> shedList = DataStore.getSheds();
    
    @Override
    public void insert(Shed shed) throws Exception 
    {
        if(shed == null)
        {
            throw new Exception("El galpon está vacío");
        }
        
        if(shed.getNumber() == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        if("".equals(shed.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        //insertar
        dbshed.insert(shed);
    }
    
    @Override
    public void update(Shed shed) throws Exception 
    {
        if(shed == null)
        {
            throw new Exception("El galpon está vacía");
        }
        
        if(shed.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if(shed.getNumber() == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        if("".equals(shed.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        
        //validar si el galpón a actualizar existe        
        Shed lineExist = find(shed.getId());
        if(lineExist == null)
        {
            throw new Exception ("No existe el registro a actualizar");
        }
        
        dbshed.update(shed);   
    }
    
    @Override
    public void delete(int id) throws Exception 
    {
        if(id == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        Shed shedExist = find(id);
        if(shedExist == null)
        {
            throw new Exception ("No existe el registro a eliminar");
        }
        
        dbshed.delete(id);
    }
    
    @Override
    public Shed find(int id) throws Exception
    {
        if(id == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        
        return dbshed.find(id);
    }

    @Override
    public List<Shed> findAll() throws Exception {
        return dbshed.findAll();
    }
}
