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
public class Efectivo extends Empleado{
    
    double sueldoBasico;
    double comisiones;
    Integer horasMinimasObligatorias; 
    int horasExtras;
    double salarioEfectivo;
        
    public Efectivo (){
            
    }
    
    public Efectivo(Integer id, String nomb, String mail, String cuil, Date fechaIng,
            Integer horasTrabajadas, double sueldoBasico, double comisiones, 
            int horasExtras, Integer horasMinimasObligatorias, double salarioEfectivo){
        super(id, nomb, mail, cuil, fechaIng, horasTrabajadas);
        this.sueldoBasico = sueldoBasico;
        this.comisiones = comisiones;
        this.horasExtras = horasExtras;
        this.horasMinimasObligatorias = horasMinimasObligatorias;
       this.salarioEfectivo = salarioEfectivo;
     }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getComisiones() {
        return comisiones;
    }

    public void setComisiones(double comisiones) {
        this.comisiones = comisiones;
    }

    public int getHorasMinimasObligatorias() {
        return horasMinimasObligatorias;
    }

    public void setHorasMinimasObligatorias(int horasMinimasObligatorias) {
        this.horasMinimasObligatorias = horasMinimasObligatorias;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }
    
    @Override
    public boolean esEfectivo() {
                return true; 
    } 
    @Override
    public boolean esContratado() {
        return false; 
    }
      
    @Override
    public double salario(){
        Integer horasTrab = getHorasTrabajadas();
            
    if(horasTrab.equals(horasMinimasObligatorias)){ 
        
        horasExtras = (int)(horasTrab)-(horasMinimasObligatorias);
        
        salarioEfectivo = sueldoBasico + comisiones;
        }else {
              salarioEfectivo = sueldoBasico + comisiones + (horasExtras * (sueldoBasico/20));
        }
        return salarioEfectivo;
    }
   
   }
