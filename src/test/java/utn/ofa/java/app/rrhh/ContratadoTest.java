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
public class ContratadoTest {
    
    @Test
    public void testPagoContatado() {
        System.out.println("Contratado");
        Contratado temporal = new Contratado();
        temporal.setHorasTrabajadas(45);
        temporal.setMontoPorHora(215.0);
        Double expResult = 45*215.0;
        Double result = temporal.salario();
        assertEquals(expResult, result);
    }
    
}
