/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.ControlFertilizante;
import Model.ProductosDeControl;
import Model.ControlPlagas;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class CRUD {
    
    private static void menuCrearProducto(){
        System.out.println("1.Crear control de fertilizantes.");
        System.out.println("2.Crear control de plagas");
    }
    
    private static void menuCrearPlagas(ArrayList<ProductosDeControl> listaProductos){
        int periodoCarencia;
        String ica;
        String nombreProducto;
        int frecuenciaAplicacion;
        try {
            ControlPlagas plaga;
            Scanner tecladoInt = new Scanner(System.in);
            Scanner tecladoString = new Scanner(System.in);
            System.out.println("Creacion de plaga.");
            System.out.print("Ingrese el ica: ");
            ica = tecladoString.nextLine();
            System.out.print("Ingrese el nombre del producto: ");
            nombreProducto = tecladoString.nextLine();
            System.out.print("Ingrese el periodo de carencia (dias): ");
            periodoCarencia = tecladoString.nextInt();
            System.out.print("Ingrese la frecuencia de aplicacion (días):");
            frecuenciaAplicacion = tecladoInt.nextInt();
            
            plaga = new ControlPlagas(periodoCarencia, ica, nombreProducto, frecuenciaAplicacion);
            
            listaProductos.add(plaga);
            
            System.out.println("Producto agregado correctamente");
        } catch (Exception e) {
            System.out.println(e+"Error");
        }      
    }
     
    private static void menuCrearFertilizante(ArrayList<ProductosDeControl> listaProductos){
        String ultimaAplicacion;
        String ica;
        String nombreProducto;
        int frecuenciaAplicacion;
        try {
            ControlFertilizante fertilizante;
            Scanner tecladoInt = new Scanner(System.in);
            Scanner tecladoString = new Scanner(System.in);
            System.out.println("Creacion de fertilizante.");
            System.out.print("Ingrese el ica: ");
            ica = tecladoString.nextLine();
            System.out.print("Ingrese el nombre del producto: ");
            nombreProducto = tecladoString.nextLine();
            System.out.print("Ingrese la fecha de la ultima aplicacion: ");
            ultimaAplicacion = tecladoString.nextLine();
            System.out.print("Ingrese la frecuencia de aplicacion (días)");
            frecuenciaAplicacion = tecladoInt.nextInt();
        
            fertilizante = new ControlFertilizante(ultimaAplicacion, ica, nombreProducto, frecuenciaAplicacion);
        
            listaProductos.add(fertilizante);
        
            System.out.println("Producto agregado correctamente");
        } catch (Exception e) {
            System.out.println(e+"Error");
        }      
    }
    
    public static void crearProducto(ArrayList<ProductosDeControl> listaProductos){
        int opcion;
        Scanner tecladoInt = new Scanner(System.in);
        do {            
            menuCrearProducto();
            opcion = tecladoInt.nextInt();
            switch (opcion) {
                case 1:
                    menuCrearFertilizante(listaProductos);
                    break;
                case 2:
                    menuCrearPlagas(listaProductos);
                    break;
                case 3:
                    break;
            }
        } while (opcion>2);
    }
    
    public static void listarProductos(ArrayList<ProductosDeControl> listaProductos){
        
        for(ProductosDeControl producto : listaProductos){
            if(producto instanceof ControlPlagas){
                ControlPlagas plaga = (ControlPlagas) producto;
                plaga.imprimirDatos();
            }else{
                ControlFertilizante fertilizante;
                fertilizante=(ControlFertilizante) producto;
                fertilizante.imprimirDatos();
            }
        }
    }
    
    public static ProductosDeControl bucarPorIca(String ica,ArrayList<ProductosDeControl> listaProductos){
        for (ProductosDeControl producto : listaProductos) {
            if(producto.getIca().equals(ica)){
                return producto;
            }
        }
        return null;
    }
    
    private static void menuActualizarFertilizante(){
        System.out.println("Actualizar fertilizante");
        System.out.println("1.Actualizar nombre.");
        System.out.println("2.Actualizar fecha ultima aplicacion.");
        System.out.println("3.Actualizar frecuencia de aplicacion.");
        System.out.println("4.Volver.");
    }
    
    private static void menuActualizarPlaga(){
        System.out.println("Actualizar plaga");
        System.out.println("1.Actualizar nombre.");
        System.out.println("2.Actualizar periodod de carecia (dias).");
        System.out.println("3.Actualizar frecuencia de aplicacion.");
        System.out.println("4.Volver");
    }
    
    private static int actualizarFrecuenciaAplicacion(){
        int nuevaFrecuencia;
        Scanner tecladoInt = new Scanner(System.in);
        System.out.print("Ingrese la nueva frecuencia de aplicacion: ");
        nuevaFrecuencia = tecladoInt.nextInt();
        
        return nuevaFrecuencia;
    }
    
    private static String actualizarFechaUltimaAplicacion(){
        String nuevaFecha;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese la nueva fecha de la ultima aplicacion: ");
        nuevaFecha = tecladoString.nextLine();
        
        return nuevaFecha;
    }
    
    private static String actualizarNombre(){
        String nombre;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el nuevo nombre del producto: ");
        nombre = tecladoString.nextLine();
        
        return nombre;
    }
    
    private static int actualizarPeriodoCarencia(){
        int nuevoPeriodoCarencia;
        Scanner tecladoInt = new Scanner(System.in);
        System.out.print("Ingrese el nuevo periodo de carencia: ");
        nuevoPeriodoCarencia = tecladoInt.nextInt();
        
        return nuevoPeriodoCarencia;
    }
    
    public static void actualizarProducto(String ica,ArrayList<ProductosDeControl> listaProductos){
        String fechaNuevaUltimaAplicacion;
        String nombreNuevoProducto;
        int frecuenciaNuevaAplicacion;
        int periodoNuevoCarencia;
        int option;
        ProductosDeControl producto;
        producto = bucarPorIca(ica, listaProductos);
        Scanner tecladoInt = new Scanner(System.in);
        if(producto == null){
            System.out.println("No existe un producto asociado al ica "+ica);
        }else{
            if(producto instanceof ControlFertilizante){
                do {     
                    menuActualizarFertilizante();
                    option = tecladoInt.nextInt();
                    switch (option) {
                        case 1:
                            nombreNuevoProducto = actualizarNombre();
                            producto.setNombreProducto(nombreNuevoProducto);
                            break;
                        case 2:
                            fechaNuevaUltimaAplicacion = actualizarFechaUltimaAplicacion();
                            ((ControlFertilizante) producto).setFechaUltimaAplicacion(fechaNuevaUltimaAplicacion);
                            break;
                        case 3:
                            frecuenciaNuevaAplicacion = actualizarFrecuenciaAplicacion();
                            producto.getFrecuenciaAplicacion();
                            break;
                    }
                } while (option<3);
            }else{
                do {     
                    menuActualizarPlaga();
                    option = tecladoInt.nextInt();
                    switch (option) {
                        case 1:
                            nombreNuevoProducto = actualizarNombre();
                            producto.setNombreProducto(nombreNuevoProducto);
                            break;
                        case 2:
                            periodoNuevoCarencia = actualizarPeriodoCarencia();
                            ((ControlPlagas) producto).setPeriodoCarencia(periodoNuevoCarencia);
                            break;
                        case 3:
                            frecuenciaNuevaAplicacion = actualizarFrecuenciaAplicacion();
                            producto.getFrecuenciaAplicacion();
                            break;
                    }
                } while (option<3); 
            }
        }
    }
    
    public static void eliminarProducto(String ica, ArrayList<ProductosDeControl> listaProductos){
        ProductosDeControl producto;
        producto = bucarPorIca(ica, listaProductos);
        if(producto != null){
            listaProductos.remove(producto);
            System.out.println("Eliminado correctamente.");
        }else{
            System.out.println("El producto no exite.");
        }
    }    
    
}
