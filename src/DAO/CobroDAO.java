/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import entidades.Cobro;
import entidades.EmpleadoEnt;
import java.sql.Connection;
import java.sql.Date;
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
public class CobroDAO {

    private Cobro co;
    private Connection c;

    public CobroDAO() {
        c = ConexionBD.establecerConexion();
    }

    public Cobro getCo() {
        return co;
    }

    public void setCo(Cobro co) {
        this.co = co;
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public ArrayList<Cobro> VerTodosCobros() {
        ArrayList<Cobro> ret = new ArrayList<Cobro>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cobro");

            while (rs.next()) {
                int idCobro = rs.getInt("id");
                double importe = rs.getDouble(2);
                Date FechaFin = rs.getDate(3);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
