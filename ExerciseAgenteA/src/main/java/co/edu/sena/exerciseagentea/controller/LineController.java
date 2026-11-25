/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.model.Line;
import co.edu.sena.exerciseagentea.data.DataStore;
import co.edu.sena.exerciseagentea.db.DBLine;
import java.util.List;
/**
 * Fecha: 29/10/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public class LineController implements ILineController
{   private DBLine dbline = new DBLine();
    private List<Line> lineList = DataStore.getLines();
    
    @Override
    public void insert(Line line) throws Exception 
    {
        if(line == null)
        {
            throw new Exception("El galpon está vacío");
        }
        
        if("".equals(line.getName()))
        {
            throw new Exception("El estado es obligatorio");
        }
        //insertar
        dbline.insert(line);
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
        
        Line lineExist = find(line.getId());
        if(lineExist == null)
        {
            throw new Exception ("No existe el registro a actualizar");
        }
        
        dbline.update(line);
    }

    @Override
    public void delete(int id) throws Exception 
    {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Line lineExist = find(id);
        if(lineExist == null)
        {
            throw new Exception ("No existe el registro a eliminar");
        }
        
        dbline.delete(id);
    }

    @Override
    public Line find(int id) throws Exception 
    {
        if(id == 0)
        {
            throw new Exception("El número es obligatorio");
        }
        
       
        return dbline.find(id);
    }

    @Override
    public List<Line> findAll() throws Exception 
    {
        return dbline.findAll();
    }
}
