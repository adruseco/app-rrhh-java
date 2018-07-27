/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utn.ofa.java.app.rrhh.*;


/**
 *
 * @author Adru
 */
public class EmpleadoDaoJdbc implements EmpleadoDao {
   
    private final String INSERT_EMPLEADO = "INSERT INTO empleados (nombre, correo, cuil, "
                                            + "fecha_ingreso, hs_trabajadas, sueldo_basico, "
                                            + "comisiones, hs_minimas, costo_hora, tipo_empleado) "
                                            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_EMPLEADO = "UPDATE empleados set correo=? where id=?";
    
    private final String DELETE_EMPLEADO = "DELETE FROM empleados WHERE id=?";
    
    private final String BUSCAR_EMPLEADO = "SELECT id, nombre, correo, cui, fecha_ingreso, hs_trabajadas, "
                                            +"suledo_basico, comisiones, hs_minimas, costo_hora, tipo_empleado"
                                            +"FROM empleados WHERE id = ?";
    
    private final String BUSCAR_TODOS = " SELECT * FORM empleados";
            
    @Override
    public void crear(Empleado e) {
        PreparedStatement ps = null;
        Connection conn = ConexionJDBC.getConexion();
        try{
            ps = conn.prepareStatement(INSERT_EMPLEADO);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCorreoElectronico());
            ps.setString(3, e.getCuil());
            ps.setDate(4, (java.sql.Date) new Date(e.getFechaDeIngreso().getTime()));
            ps.setInt(5, e.getHorasTrabajadas());
            if(e.esEfectivo() ){
                Efectivo empEf = (Efectivo) e;
                ps.setDouble(6, empEf.getSueldoBasico());
                ps.setDouble(7, empEf.getComisiones());
                ps.setInt(8, empEf.getHorasMinimasObligatorias());
                ps.setInt(10, 1);
            }
            if(e.esContratado()){
                Contratado c = (Contratado) e;
                ps.setDouble(9, c.getMontoPorHora());
                ps.setInt(10, 2);
            }
            int fila = ps.executeUpdate();
                     
        }catch(SQLException ex){
           ex.printStackTrace();
        }finally{
             try {
                 if (ps!=null) ps.close();
                 ConexionJDBC.liberarConexion();
                } catch (SQLException ex) {
                 Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
             }
           
            }
                
        }

    @Override
    public void actualizar(Empleado e) {
        PreparedStatement ps = null;
        Connection conn = ConexionJDBC.getConexion();
        try {
            ps = conn.prepareStatement(UPDATE_EMPLEADO);
            ps.setString(1, e.getCorreoElectronico());
            ps.setInt(2, e.getId());
            int fila = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(ps!=null)ps.close();
                  ConexionJDBC.liberarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

    @Override
    public void eliminar(Empleado e) {
        PreparedStatement ps = null;
        Connection conn = ConexionJDBC.getConexion();
        try {
            ps = conn.prepareStatement(DELETE_EMPLEADO);
            ps.setInt(1,e.getId());
            int fila = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        try {
             if(ps!=null) ps.close();
             ConexionJDBC.liberarConexion();
         } catch (SQLException ex) {
             Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        }
    }

    @Override
    public Empleado buscarPorId(Integer id) {
          Connection conn = ConexionJDBC.getConexion();
          Empleado e = null;
        try (PreparedStatement stm = conn.prepareStatement(BUSCAR_EMPLEADO)) {
             stm.setInt(1, id);
             ResultSet rs = stm.executeQuery();
             while(rs.next()){
                 Integer i = rs.getInt("tipo_empleado");
                    e.setId(rs.getInt("id"));
                     e.setNombre(rs.getString("nombre"));
                     e.setCorreoElectronico(rs.getString("correo"));
                     e.setCuil(rs.getString("cuil"));
                     e.setFechaDeIngreso(rs.getDate("fecha_ingreso"));
                     e.setHorasTrabajadas(rs.getInt("hs_trabajadas"));
                     if (i==1){
                         Efectivo empEf = (Efectivo) e;
                     empEf.setSueldoBasico(rs.getDouble("sueldo_basico"));
                     empEf.setComisiones(rs.getDouble("comisiones"));
                     empEf.setHorasMinimasObligatorias(rs.getInt("hs_minimas"));
                    }
                     if(i==2){
                         Contratado c = (Contratado) e;
                         c.setMontoPorHora(rs.getDouble("monto_hora"));
                                 
               }
                        
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionJDBC.liberarConexion();
        }
        return e;
    }       
    
    @Override
    public List<Empleado> buscarTodos() {
        
        List<Empleado> empleados = new ArrayList<Empleado>();
       
        Connection conn = ConexionJDBC.getConexion();
        Empleado e = null;
       
        try (PreparedStatement stm = conn.prepareStatement(BUSCAR_TODOS)) {
             ResultSet rs = stm.executeQuery();
             while(rs.next()){
                 if(rs.getInt("tipo_empleado")==1){
                    e.setId(rs.getInt("id"));
                    e.setNombre(rs.getString("nombre"));
                    e.setCorreoElectronico(rs.getString("correo"));
                    e.setCuil(rs.getString("cuil"));
                    e.setFechaDeIngreso(rs.getDate("fecha_ingreso"));
                    e.setHorasTrabajadas(rs.getInt("hs_trabajadas"));
                    Efectivo empEf = (Efectivo) e;
                    empEf.setSueldoBasico(rs.getDouble("sueldo_basico"));
                    empEf.setComisiones(rs.getDouble("comisiones"));
                    empEf.setHorasMinimasObligatorias(rs.getInt("hs_minimas"));
                    e=empEf;
                    empleados.add(e);
                 }
                 if(rs.getInt("tipo_empleado")==2){
                    Contratado c = (Contratado) e;
                     c.setMontoPorHora(rs.getDouble("monto_hora"));
                     e=c;
                    empleados.add(e);    
                 }                    
                 }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionJDBC.liberarConexion();
        }
        return empleados;
        
        
        
    
        
    }
    
    
  }
    
    
     

 
