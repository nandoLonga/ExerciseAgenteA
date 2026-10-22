/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.model.Shed;
import java.util.List;

/**
 * Fecha: 22/10/2026
 * @author luilonmu
 * Objetivo: Controller galpon
 */
public interface IShedController 
{
    public void insert(Shed shed) throws Exception;
    public void update(Shed shed) throws Exception;
    public void delete(int number) throws Exception;
    public Shed find(int number) throws Exception;
    public List<Shed> findAll() throws Exception;
}
