/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adru
 */
public class ConexionJDBC {
    private static final String USUARIO = "root"; //usuario configurado en el paso 1
    private static final String PASSWORD = "root"; //contraseña configurada en el paso 1
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/app-rrhh";
    
    private static Connection _CONEXION;
    
    public static Connection getConexion() {
        if (_CONEXION == null) {
            try {
                 Class.forName("com.mysql.jdbc.Driver");
                _CONEXION = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return _CONEXION;
    }
    
    public static void liberarConexion() {
        if (_CONEXION != null) {
            try {
                _CONEXION.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
                _CONEXION = null;
         }
}
      
}
