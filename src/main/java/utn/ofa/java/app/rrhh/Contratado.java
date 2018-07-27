/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh;
import java.util.Date;

/**
 *
 * @author Adru
 */
public class Contratado extends Empleado{

    double montoPorHora;
   
   public Contratado(){
    
    }
    
   public Contratado(Integer id,String nomb, String mail, String cuil, 
               Date fechaIng, Integer horasTrabajadas, double montoPorHora) {
                 super(id, nomb, mail, cuil, fechaIng, horasTrabajadas);
                this.montoPorHora = montoPorHora;
}

       public double getMontoPorHora() {
        return montoPorHora;
    }

    public void setMontoPorHora(double montoPorHora) {
        this.montoPorHora = montoPorHora;
    }
    
    @Override
    public boolean esEfectivo() { 
        return false; 
    }
    
    @Override
    public boolean esContratado() { 
        return true;
    } 
    
    @Override
    public double salario() {
       int horasContratado = (int)getHorasTrabajadas();
       double salarioContratado = horasContratado * montoPorHora;
       return salarioContratado;      
    }

    
}
