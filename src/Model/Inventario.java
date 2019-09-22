/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Main.CRUD;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Inventario {
    
    //ATRIBUTOS
    
    private ArrayList<ProductosDeControl> listaProductos;
 
    //CONSTRUCTOR
    
    public Inventario() {
        listaProductos = new ArrayList<>();
    }
    
    //METODOS

    public ArrayList<ProductosDeControl> getListaProductos() {
        return listaProductos;
    } 
}
