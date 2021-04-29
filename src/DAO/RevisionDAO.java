/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import entidades.Cirugia;
import entidades.Revision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author punib
 */
public class RevisionDAO {

    private Revision r;
    private Connection c;

    public RevisionDAO() {
        c = ConexionBD.establecerConexion();
    }

    public Revision getR() {
        return r;
    }

    public void setR(Revision r) {
        this.r = r;
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public void eliminarRevision(int idRev) {
         try {
            if (c == null || c.isClosed()) {
                c = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = c.prepareStatement("DELETE FROM Revision WHERE id = ?");
                pstmt.setString(1, String.valueOf(idRev));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado la revisión de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(RevisionDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado la revision de la BD.");
            } finally {
                if (c != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RevisionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public void modificarRevision(Revision e) {
        try {
            if (c == null || c.isClosed()) {
                c = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String anotacion = e.getAnotacion();
                long idCita=e.getIdCita();
                long idCiru=e.getIdCirujano();               
                
                String sql = "UPDATE ejemplares SET ";
                sql += "anotacion=" + anotacion;
                sql += ", idCita=" + idCita;
                sql += ", idCirugia=" + idCiru;
                sql += " WHERE id = ?";
                pstmt = c.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(RevisionDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado la revisión de la BD.");
            } finally {
                if (c != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RevisionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
