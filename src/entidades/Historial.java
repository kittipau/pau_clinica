/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author punib
 */
public class Historial {
    private long historia; // >0
    private String descripcion; // Máximo 40 caracteres alfanuméricos
    private ArrayList<Alergia> alergias = new ArrayList<Alergia>();
}
