/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import utn.frsf.ofa.cursojava.modelo.Proyecto;
 

/**
 *
 * @author Adru
 */
public class ProyectoDaoJPA implements ProyectoDAO{

    private EntityManager em;
    
    
    
    
    @Override
    public void crear(Proyecto e) {
        this.em = ConexionJPA.get();
        try{
          em.getTransaction().begin();
         em.persist(e);
         em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }finally{
            em.close();
        }
        }

    @Override
    public void actualizar(Proyecto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Proyecto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proyecto buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proyecto> buscarTodos() {
        this.em = ConexionJPA.get();
        List <Proyecto> resultado = new ArrayList<Proyecto>();
        try{
            em.getTransaction().begin();
            resultado = this.em.createQuery("Select p from Proyecto p").getResultList();
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        
        }finally{
            em.close();
        }
        return resultado;
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
