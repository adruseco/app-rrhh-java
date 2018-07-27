/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adru
 */
public class EfectivoTest {
    
    @Test
    public void testSalarioSinHorasExtras() {
        System.out.println("Salario");
        Efectivo empleado = new Efectivo();
        empleado.setHorasTrabajadas(40);
        empleado.setHorasMinimasObligatorias(40);
        empleado.setComisiones(2000.0);
        empleado.setSueldoBasico(30000.0);
        Double expResult = 30000.0+2000.0;
        Double result = empleado.salario();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSalario2HorasExtras() {
        System.out.println("Salario");
        Efectivo empleado = new Efectivo();
        empleado.setHorasTrabajadas(42);
        empleado.setHorasMinimasObligatorias(40);
        empleado.setComisiones(2000.0);
        empleado.setSueldoBasico(30000.0);
        Double expResult = 30000.0+2000.0;
        Double result = empleado.salario();
        assertEquals(expResult, result);
    }
    
}
