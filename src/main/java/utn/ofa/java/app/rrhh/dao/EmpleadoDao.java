/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh.dao;
import java.util.List;
import utn.ofa.java.app.rrhh.*;

/**
 *
 * @author Adru
 */
public interface EmpleadoDao {
    public void crear(Empleado e);
    public void actualizar(Empleado e);
    public void eliminar(Empleado e);
    public Empleado buscarPorId(Integer id);
    public List<Empleado> buscarTodos();
}
