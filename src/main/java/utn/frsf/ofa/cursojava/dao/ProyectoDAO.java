/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.dao;

import java.util.List;
import utn.frsf.ofa.cursojava.modelo.Proyecto;

/**
 *
 * @author Adru
 */
public interface ProyectoDAO {
    
    public void crear(Proyecto e);
    public void actualizar(Proyecto e);
    public void eliminar(Proyecto e);
    public Proyecto buscarPorId(Integer id);
    public List<Proyecto> buscarTodos();
}
