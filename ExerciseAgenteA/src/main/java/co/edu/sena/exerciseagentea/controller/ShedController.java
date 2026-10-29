package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.model.Shed;
import co.edu.sena.exerciseagentea.data.DataStore;
import java.util.List;

/**
 * Fecha: 22/10/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public class ShedController implements IShedController
{
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
        shedList.add(shed);
    }
    
    @Override
    public void update(Shed shed) throws Exception 
    {
        if(shed == null)
        {
            throw new Exception("El galpon está vacía");
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
        boolean exists = false;
        for (int i = 0; i < shedList.size(); i++)
        {
            if(shedList.get(i).getNumber() == shed.getNumber())
            {
                //actualizar
                shedList.set(i, shed);
                exists = true;
                break;
            }
        }
        
        if(!exists)
        {
            throw new Exception("No existe el galpón a actualizar");
        }        
    }
    
    @Override
    public void delete(int number) throws Exception 
    {
        if(number == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        boolean exists = false;
        for (int i = 0; i < shedList.size(); i++)
        {
            if(shedList.get(i).getNumber() == number)
            {
                //actualizar
                shedList.remove(i);
                exists = true;
                break;
            }
        }
  
    }
    
    @Override
    public Shed find(int number) throws Exception
    {
        if(number == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        Shed shed = null;
        for (Shed s : shedList) 
        {
            if(s.getNumber() == number)
            {
                shed = s;
            }
        }
        return shed;
    }

    @Override
    public List<Shed> findAll() throws Exception {
        return shedList;
    }
}
