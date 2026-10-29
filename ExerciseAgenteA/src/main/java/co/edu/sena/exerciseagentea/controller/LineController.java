/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.model.Line;
import co.edu.sena.exerciseagentea.data.DataStore;
import java.util.List;
/**
 * Fecha: 29/10/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public class LineController implements ILineController
{
    private List<Line> lineList = DataStore.getLines();
    
    @Override
    public void insert(Line line) throws Exception 
    {
        if(line == null)
        {
            throw new Exception("El galpon está vacío");
        }
        
        if(line.getId() == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        if("".equals(line.getName()))
        {
            throw new Exception("El estado es obligatorio");
        }
        //insertar
        lineList.add(line);
    }

    @Override
    public void update(Line line) throws Exception 
    {
        if(line == null)
        {
            throw new Exception("La informacion de la linea está vacía");
        }
        
        if(line.getId() == 0)
        {
            throw new Exception("Este campo es obligatorio");
        }
        
        if("".equals(line.getName()))
        {
            throw new Exception("Este campo es obligatorio");
        }
        
        boolean exists = false;
        for (int i = 0; i < lineList.size(); i++)
        {
            if(lineList.get(i).getId() == line.getId())
            {
                //actualizar
                lineList.set(i, line);
                exists = true;
                break;
            }
        }
        
        if(!exists)
        {
            throw new Exception("No existe informacion de la linea a actualizar");
        } 
    }

    @Override
    public void delete(int id) throws Exception 
    {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        boolean exists = false;
        for (int i = 0; i < lineList.size(); i++)
        {
            if(lineList.get(i).getId() == id)
            {
                //actualizar
                lineList.remove(i);
                exists = true;
                break;
            }
        }
    }

    @Override
    public Line find(int id) throws Exception 
    {
        if(id == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
        Line line = null;
        for (Line l : lineList) 
        {
            if(l.getId() == id)
            {
                line = l;
            }
        }
        return line;
    }

    @Override
    public List<Line> findAll() throws Exception 
    {
        return lineList;
    }
}
