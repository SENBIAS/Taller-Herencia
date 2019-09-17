/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Inventario {
    
    //ATRIBUTOS
    
    private ArrayList<ControlPlagas> listaPlagas;
    private ArrayList<ControlFertilizante>listaFertilizantes;
 
    //CONSTRUCTOR

    public Inventario() {
        this.listaFertilizantes = new ArrayList<>();
        this.listaPlagas = new ArrayList<>();
    }
    
    //METODOS
     public static void eliminar(Inventario inventario){
        String ica;
        Scanner tecladoString = new Scanner(System.in);
        System.out.println("Ingrese el ICA del producto a buscar ");
        ica = tecladoString.nextLine();
        ControlPlagas plaga = CRUD.buscarPorIcaPlaga(ica, inventario.getPlagas());
        ControlFertilizante fertilizante = CRUD.buscarPorIcaFertilizante(ica, inventario.getFertilizantes());
        if(plaga!=null){
            CRUD.eliminarPlaga(plaga,inventario.getPlagas());
            System.out.println("Producto eliminado");
        }else if(fertilizante != null){
            CRUD.eliminarFertilizante(fertilizante,inventario.getFertilizantes());
            System.out.println("Producto eliminado");
        }else{
            System.out.println("EL PRODUCTO NO EXITE.");
        }  
    }
    
    public static void actualizar(Inventario inventario){
        String ica;
        Scanner tecladoString = new Scanner(System.in);
        System.out.println("Ingrese el ICA del producto a buscar ");
        ica = tecladoString.nextLine();
        ControlPlagas plaga = CRUD.buscarPorIcaPlaga(ica, inventario.getPlagas());
        ControlFertilizante fertilizante = CRUD.buscarPorIcaFertilizante(ica, inventario.getFertilizantes());
        if(plaga!=null){
            System.out.println("EL PRODUCTO ES DE CONTROL DE PLAGAS.");
            CRUD.actualizarPlaga(ica, inventario.getPlagas());
        }else if(fertilizante != null){
            System.out.println("EL PRODUCTO ES DE FERTILIZANTES.");
            CRUD.actualizarFertilizante(ica, inventario.getFertilizantes());
        }else{
            System.out.println("EL PRODUCTO NO EXITE.");
        }  
    }
            
    public static void buscar(Inventario inventario){
        String ica;
        Scanner tecladoString = new Scanner(System.in);
        System.out.println("Ingrese el ICA del producto a buscar ");
        ica = tecladoString.nextLine();
        ControlPlagas plaga = CRUD.buscarPorIcaPlaga(ica, inventario.getPlagas());
        ControlFertilizante fertilizante = CRUD.buscarPorIcaFertilizante(ica, inventario.getFertilizantes());
        if(plaga!=null){
            System.out.println("EL PRODUCTO ES DE CONTROL DE PLAGAS.");
            System.out.println("ICA: "+plaga.getIca());
            System.out.println("Nombre: "+plaga.getNombreProducto());
            System.out.println("Periodo de carencia: "+plaga.getPeriodoCarencia());
            System.out.println("Frecuencia de aplicacion: "+plaga.getFrecuenciaAplicacion());
        }else if(fertilizante != null){
            System.out.println("EL PRODUCTO ES DE FERTILIZANTES.");
            System.out.println("ICA: "+fertilizante.getIca());
            System.out.println("Nombre: "+fertilizante.getNombreProducto());
            System.out.println("Fecha ultima aplicacion: "+fertilizante.getFechaUltimaAplicacion());
            System.out.println("Frecuencia de aplicacion: "+fertilizante.getFrecuenciaAplicacion());
        }else{
            System.out.println("EL PRODUCTO NO EXITE.");
        }   
    }
    
    public static void menuAgregar(Inventario inventario){
        int option;
        String ica;
        System.out.println("1.Agregar producto de plagas.");
        System.out.println("2.Agregar producto fertilizante.");
        Scanner tecladoInt = new Scanner(System.in);
        option = tecladoInt.nextInt();
        
        switch (option) {
            case 1:
                agregarPlaga(inventario.getPlagas());
                break;
            case 2:
                agregarFertilizante(inventario.getFertilizantes());
                break;
            default:
                System.out.println("La opcion no existe.");
                break;
        }
    }
    
    private static void agregarFertilizante(ArrayList<ControlFertilizante> listaFertiliantes){
        String fechaUltimaAplicacion;
        String ica;
        String nombreProducto;
        int frecuenciaAplicacion;
        ControlFertilizante fertilizante;
        
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        
        System.out.print("Ingrese el ICA: ");
        ica = tecladoString.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        nombreProducto = tecladoString.nextLine();
        System.out.print("Ingrese la ultima fecha de aplicacion: ");
        fechaUltimaAplicacion = tecladoString.nextLine();
        System.out.print("Ingrese la frecuencia de aplicacion: ");
        frecuenciaAplicacion = tecladoInt.nextInt();
        
        fertilizante = new ControlFertilizante(fechaUltimaAplicacion, ica, nombreProducto, frecuenciaAplicacion);
        
        listaFertiliantes.add(fertilizante);
    }
    
    private static void agregarPlaga(ArrayList<ControlPlagas> listaPlagas){
        int periodoCarencia;
        String ica;
        String nombreProducto;
        int frecuenciaAplicacion;
        ControlPlagas plaga;
        
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        
        System.out.print("Ingrese el ICA: ");
        ica = tecladoString.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        nombreProducto = tecladoString.nextLine();
        System.out.print("Ingrese el periodo de carencia: ");
        periodoCarencia = tecladoInt.nextInt();
        System.out.print("Ingrese la frecuencia de aplicacion: ");
        frecuenciaAplicacion = tecladoInt.nextInt();
        
        plaga = new ControlPlagas(periodoCarencia, ica, nombreProducto, frecuenciaAplicacion);
        
        listaPlagas.add(plaga);
    }
    
    public ArrayList<ControlPlagas> getPlagas() {
        return listaPlagas;
    }

    public void setPlagas(ControlPlagas plaga) {
        listaPlagas.add(plaga);
    }

    public ArrayList<ControlFertilizante> getFertilizantes() {
        return listaFertilizantes;
    }

    public void setFertilizantes(ControlFertilizante fertilizante) {
        listaFertilizantes.add(fertilizante);
    }
}
