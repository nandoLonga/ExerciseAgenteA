package co.edu.sena.exerciseagentea.data;

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
    }
    public static List<Shed> getSheds()
    {
        return shedList;
    }
}