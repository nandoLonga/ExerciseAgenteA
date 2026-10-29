package co.edu.sena.exerciseagentea.data;

import co.edu.sena.exerciseagentea.model.Line;
import co.edu.sena.exerciseagentea.model.Shed;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 28/10/2026
 * @author luilonmu
 * Objetivo: almacen de datos o listas de tados
 */
public class DataStore 
{
    private static List<Shed> shedList = new ArrayList<>();
    private static List<Line> lineList = new ArrayList<>();
    
    static
    {
        Shed shed = new Shed(1, "Ocupado");
        shedList.add(shed);
        shed = new Shed(2, "Diponible");
        shedList.add(shed);
        shed = new Shed(3, "Ocupado");
        shedList.add(shed);
        shed = new Shed(4, "Diponible");
        shedList.add(shed);
        
        lineList.add(new Line (1, "Gallina Babcock"));
        lineList.add(new Line (2, "Gallina Jersey blanca gigante"));
        lineList.add(new Line (3, "Gallina Light Sussex"));
    }
    public static List<Shed> getSheds()
    {
        return shedList;
    }
    
    public static List<Line> getLines()
    {
        return lineList;
    }
}