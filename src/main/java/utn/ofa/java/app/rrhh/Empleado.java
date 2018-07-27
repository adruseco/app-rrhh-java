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

public abstract class Empleado {
    
    private Integer id;
    private String nombre;
    private String correoElectronico;
    private String cuil;
    private Date fechaDeIngreso;
    private Integer horasTrabajadas;
    
   
    public Empleado(){
    
    }
    
    public Empleado(Integer id, String nombre, String correoElectronico, 
           String cuil, Date fechaDeIngreso, int horasTrabajadas){
      this.id = id;
     this.nombre = nombre;
    this.correoElectronico = correoElectronico;
      this.cuil = cuil;
       this.fechaDeIngreso = fechaDeIngreso;
      this.horasTrabajadas = horasTrabajadas;        
     }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public abstract double salario();

    public abstract boolean esEfectivo();

    public abstract boolean esContratado();
    
    


    
}
