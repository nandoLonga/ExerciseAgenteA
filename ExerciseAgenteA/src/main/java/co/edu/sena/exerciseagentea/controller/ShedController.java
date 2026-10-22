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
    public static List<Shed> sheds = new ArrayList<>();
    
    public  ShedController ()
    {
        Shed shed = new Shed(1, "Ocupado");
        sheds.add(shed);
        shed = new Shed(2, "Diponible");
        sheds.add(shed);
        shed = new Shed(3, "Ocupado");
        sheds.add(shed);
        shed = new Shed(4, "Diponible");
        sheds.add(shed);
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
        sheds.add(shed);
    }
    
    @Override
    public void update(Shed shed) throws Exception 
    {
        if(shed == null)
        {
            throw new Exception("La ciudad está vacía");
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
        for (int i = 0; i < sheds.size(); i++) {
            if(sheds.get(i).getNumber() == shed.getNumber())
            {
                //actualizar
                sheds.set(i, shed);
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
        
        //eliminar
        for (Shed shed : sheds) {
            if(shed.getNumber() == number)
            {
                sheds.remove(shed);
                break;
            }
        }
    }
    
    @Override
    public Shed find(int number) throws Exception {
        if(number == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        Shed result = null;
        for (Shed shed : sheds) {
            if(shed.getNumber() == number)
            {
                result = shed;
            }
        }
        
        return result;
    }

    @Override
    public List<Shed> findAll() throws Exception {
        return sheds;
    }
}
