package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.model.Shed;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 22/10/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public class ShedController implements IShedController
{
    public static List<Shed> shedList = new ArrayList<>();
    
    public  ShedController ()
    {
        Shed shed = new Shed(1, "Ocupado");
        shedList.add(shed);
        shed = new Shed(2, "Diponible");
        shedList.add(shed);
        shed = new Shed(3, "Ocupado");
        shedList.add(shed);
        shed = new Shed(4, "Diponible");
        shedList.add(shed);
    }
    
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
