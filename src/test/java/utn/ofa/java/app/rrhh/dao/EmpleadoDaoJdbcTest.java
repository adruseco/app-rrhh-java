/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh.dao;


//import java.util.Date;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import utn.ofa.java.app.rrhh.*;

/**
 *
 * @author Adru
 */
public class EmpleadoDaoJdbcTest {
       
   EmpleadoDao empleadoDao ;
    
@Before
  public void init(){
     empleadoDao = new EmpleadoDaoJdbc();
   }
    
    @Test
    public void CrearEmpleadoDaoJdbcTest() {
        System.out.println("Crear Empleado");
        
        Contratado eC=new Contratado();
        eC.setNombre("Adriana Seco");
        eC.setCorreoElectronico("correo@mail.com");
        eC.setCuil("11-11111111-1");
       // eC.setFechaDeIngreso(new Date());
        eC.setHorasTrabajadas(35);
        eC.setMontoPorHora(250.8);
        Efectivo eF=new Efectivo();
        eF.setNombre("Cristian Sosa");
        eF.setCorreoElectronico("mail@correo.com");
        eF.setCuil("22-22222222-2");
     //   e2.setFechaDeIngreso(new Date());
        eF.setHorasMinimasObligatorias(40);
        eF.setHorasTrabajadas(40);
        eF.setSueldoBasico(25000.0);
        eF.setComisiones(2500.0);
        empleadoDao.crear(eC);
        empleadoDao.crear(eF);
        Empleado e1 =empleadoDao.buscarPorId(eC.getId());
        Empleado e2=empleadoDao.buscarPorId(eF.getId());
        assertEquals(eC.getNombre(),e1.getNombre());
        assertEquals(eF.getNombre(),e2.getNombre());
    }
            }
   
    
