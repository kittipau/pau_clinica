/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import entidades.Empleado;
import java.sql.Connection;
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
    private Empleado e;

    public EmpleadoDAO() {
        c = ConexionBD.establecerConexion();
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public Empleado getE() {
        return e;
    }

    public void setE(Empleado e) {
        this.e = e;
    }

    public ArrayList<Empleado> verTodosEmpleados() {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");

            while (rs.next()) {
                int idEmple = rs.getInt("id");
                String nomEmp = rs.getString(2);
                String apeEmp = rs.getString(3);
                String telEmp = rs.getString(4);
                String NIFEmp = rs.getString(5);
                String DireEmp =rs.getString(6);
                
                
                Empleado nuevo = new Empleado(idEmple, nomEmp,apeEmp, telEmp, NIFEmp, DireEmp );
                ret.add(nuevo);                
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean insertarEmpleado(Empleado e) {
         boolean ret = false;
        try {         
            
            Statement st = c.createStatement();
            String sql ="INSERT INTO empleados (nombre, apellido, telefono ,NIF, direccion ) VALUES ('"+e.getNombre()+"'  , '"+e.getApellido()+"' , '"+e.getTlfn()+"' , '"+e.getNIF()+"' , '"+e.getDireccion()+"')";
            int mod = st.executeUpdate(sql);
            ret = (mod>0);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ret;
    }

}
