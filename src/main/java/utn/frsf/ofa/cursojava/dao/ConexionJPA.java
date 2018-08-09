/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adru
 */
public class ConexionJPA {
    private static EntityManagerFactory _entityManagerFactory = null;
    
    private static void inicializar(){
        if (_entityManagerFactory == null){
            _entityManagerFactory = Persistence.createEntityManagerFactory("app-rrhh-PU");
        }
        
    }
    public static EntityManager get(){
        inicializar();
            return _entityManagerFactory.createEntityManager();
}
}
