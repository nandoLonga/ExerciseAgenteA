/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.exerciseagentea.controller;

import co.edu.sena.exerciseagentea.model.Role;
import java.util.List;

/**
 * Fecha: 26/11/2026
 * @author luilonmu
 * Objetivo: Interface controlador rol
 */
public interface IRoleController 
{
    public Role find(int id) throws Exception;
    public List<Role> findAll() throws Exception;
}
