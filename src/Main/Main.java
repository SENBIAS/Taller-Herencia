/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.*;

import java.util.Scanner;
/**
 *
 * @author Sebastian
 */
public class Main
{    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option;
        String ica;
        Scanner tecladoInt = new Scanner(System.in);
        Inventario inventario = new Inventario();
        ProductosDeControl producto;
        do {            
            menu();
            System.out.println("Seleccione una opcion: ");
            option = tecladoInt.nextInt();
            switch (option) {
                case 1:
                    System.out.println("CREAR PRODUCTO.");
                    CRUD.crearProducto(inventario.getListaProductos());
                    break;
                case 2:
                    System.out.println("BUSCAR PRODUCTO.");
                    ica = obtenerIca();
                    producto = CRUD.bucarPorIca(ica,inventario.getListaProductos());
                    imprimirProductoBuscado(producto);
                    break;
                case 3:
                    System.out.println("ACTUALIZAR PRODUCTO.");
                    ica = obtenerIca();
                    CRUD.actualizarProducto(ica, inventario.getListaProductos());
                    break;
                case 4:
                    System.out.println("ELIMINAR PRODUCTO.");
                    ica = obtenerIca();
                    CRUD.eliminarProducto(ica, inventario.getListaProductos());
                    break;
                case 5:
                    CRUD.listarProductos(inventario.getListaProductos());
                    break;
                case 6:
                    break;
            }
        } while (option<6);
    }
    
    private static void imprimirProductoBuscado(ProductosDeControl producto){
        if(producto != null){
            
            if(producto instanceof ControlPlagas){
                ((ControlPlagas) producto).imprimirDatos();
            }else{
                ((ControlFertilizante)producto).imprimirDatos();
            }
        }else{
            System.out.println("Producto no exite.");
        }
    }
    
    private static String obtenerIca(){
        String ica;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el ica del producto: ");
        ica = tecladoString.nextLine();
        
        return ica;
    }
    
    private static void menu() {
        System.out.println("1.Agregar producto.");
        System.out.println("2.Buscar producto.");
        System.out.println("3.Actualizar producto.");
        System.out.println("4.Eliminar producto.");
        System.out.println("5.Mostrar productos.");
        System.out.println("6.Salir.");
    }
    
}
