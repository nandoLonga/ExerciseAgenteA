/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    }
}
