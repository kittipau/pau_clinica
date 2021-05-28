/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import entidades.EmpleadoEnt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author punib
 */
public class EmpleadoDAO {

    private Connection c;
    private EmpleadoEnt e;

    public EmpleadoDAO() {
        c = ConexionBD.establecerConexion();
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public EmpleadoEnt getE() {
        return e;
    }

    public void setE(EmpleadoEnt e) {
        this.e = e;
    }

    public ArrayList<EmpleadoEnt> verTodosEmpleados() {
        ArrayList<EmpleadoEnt> ret = new ArrayList<EmpleadoEnt>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleado");

            while (rs.next()) {
                int idEmple = rs.getInt("id");
                String nomEmp = rs.getString(2);
                String apeEmp = rs.getString(3);
                String telEmp = rs.getString(4);
                String NIFEmp = rs.getString(5);
                String DireEmp =rs.getString(6);
                
                
                EmpleadoEnt nuevo = new EmpleadoEnt(idEmple, nomEmp,apeEmp, telEmp, NIFEmp, DireEmp );
                ret.add(nuevo);                
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean insertarEmpleado(EmpleadoEnt e) {
         boolean ret = false;
        try {         
            
            Statement st = c.createStatement();
            String sql ="INSERT INTO empleado (nombre, apellido, telefono ,NIF, direccion ) VALUES ('"+e.getNombre()+"'  , '"+e.getApellido()+"' , '"+e.getTlfn()+"' , '"+e.getNIF()+"' , '"+e.getDireccion()+"')";
            int mod = st.executeUpdate(sql);
            ret = (mod>0);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ret;
    }
    
    public boolean eliminarEmpleado(int idEmpl) {
        boolean ret = false;
         try {
            if (c == null || c.isClosed()) {
                c = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = c.prepareStatement("DELETE FROM empleado WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEmpl));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el empleado de la BD.");
                ret = true;
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("El empleado no se ha eliminado de la BD.");
            } finally {
                if (c != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return ret;
    }

}
