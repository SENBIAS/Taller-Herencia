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
public class CRUD {
    
    public static void crearProducto(ControlPlagas plaga,ArrayList<ControlPlagas>listaPlagas){
        String ica;
        String nombre;
        int frecuenciaAplicacion;
        int periodoCarencia;
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        System.out.println("Ingresar producto control de plagas.");
        System.out.print("Ingrese el ica: ");
        ica = tecladoString.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        nombre = tecladoString.nextLine();
        System.out.print("Ingrese la frecuencia de aplicacion: ");
        frecuenciaAplicacion = tecladoInt.nextInt();
        System.out.print("Ingrese el periodo de carencia: ");
        periodoCarencia = tecladoInt.nextInt();
        
        plaga.setFrecuenciaAplicacion(frecuenciaAplicacion);
        plaga.setIca(ica);
        plaga.setNombreProducto(nombre);
        plaga.setPeriodoCarencia(periodoCarencia);
        
        listaPlagas.add(plaga);
    }
    
    public static void crearProducto(ControlFertilizante fertilizante,ArrayList<ControlFertilizante>listaFertilizantes){
        String ica;
        String nombre;
        int frecuenciaAplicacion;
        String fechaUltimaAplicacion;
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        System.out.println("Ingresar producto control de fertilizante.");
        System.out.print("Ingrese el ica: ");
        ica = tecladoString.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        nombre = tecladoString.nextLine();
        System.out.print("Ingrese la frecuencia de aplicacion: ");
        frecuenciaAplicacion = tecladoInt.nextInt();
        System.out.print("Ingrese la ultima aplicacion: ");
        fechaUltimaAplicacion = tecladoString.nextLine();
        
        fertilizante.setFrecuenciaAplicacion(frecuenciaAplicacion);
        fertilizante.setIca(ica);
        fertilizante.setNombreProducto(nombre);
        fertilizante.setFechaUltimaAplicacion(fechaUltimaAplicacion);
        
        listaFertilizantes.add(fertilizante);
    }
    
    public static void mostrarProductos(ArrayList<ControlPlagas>listaPlagas,ArrayList<ControlFertilizante>listaFertilizantes){
        int cantidadListaPlagas = listaPlagas.size();
        int cantidadListaFertilizantes = listaFertilizantes.size();
        
        System.out.println("Productos de tipos plagas: ");
        
        for(int iterador = 0;iterador < cantidadListaPlagas;iterador++){
            System.out.println("Producto #"+(iterador+1));
            System.out.println("Frecuencia aplicacion: "+listaPlagas.get(iterador).getFrecuenciaAplicacion()+" dias");
            System.out.println("Ica: "+listaPlagas.get(iterador).getIca());
            System.out.println("Nombre producto: "+listaPlagas.get(iterador).getNombreProducto());
            System.out.println("Periodo de carencia: "+listaPlagas.get(iterador).getPeriodoCarencia()+" dias");
        }
        System.out.println("");
        System.out.println("Productos de tipos fertilizantes: ");
        for(int iterador = 0;iterador < cantidadListaPlagas;iterador++){
            System.out.println("Producto #"+(iterador+1));
            System.out.println("Frecuencia aplicacion: "+listaFertilizantes.get(iterador).getFrecuenciaAplicacion()+" dias");
            System.out.println("Ica: "+listaFertilizantes.get(iterador).getIca());
            System.out.println("Nombre producto: "+listaFertilizantes.get(iterador).getNombreProducto());
            System.out.println("Fecha ultima aplicacion: "+listaFertilizantes.get(iterador).getFechaUltimaAplicacion());
        }
    }
    
    /**
     *
     * @param ica
     * @param listaPlagas
     * @return
     */
    public static ControlPlagas buscarPorIcaPla(String ica,ArrayList<ControlPlagas>listaPlagas){
        
        ControlPlagas plagaRetornar;
        int cantidadPlagas = listaPlagas.size();
        int iterador = 0;
        
        if(cantidadPlagas!=0){
            while((listaPlagas.get(iterador).getIca().equals(ica))&&(iterador < cantidadPlagas-1)){
                iterador+=1;
            }
            if(listaPlagas.get(iterador).getIca().equals(ica)){
                plagaRetornar = listaPlagas.get(iterador);
                return plagaRetornar;
            }else{
                return null;
            }
        }else{
            return null;
        }  
    }
    
    /**
     *
     * @param ica
     * @param listaFertilizantes
     * @return
     */
    public static ControlFertilizante buscarPorIcaFer(String ica,ArrayList<ControlFertilizante>listaFertilizantes){
        
        ControlFertilizante fertilizanteRetornar;
        int cantidadPlagas = listaFertilizantes.size();
        int iterador = 0;
        
        if(cantidadPlagas!=0){
            while((listaFertilizantes.get(iterador).getIca().equals(ica))&&(iterador < cantidadPlagas-1)){
                iterador+=1;
            }
            if(listaFertilizantes.get(iterador).getIca().equals(ica)){
                fertilizanteRetornar = listaFertilizantes.get(iterador);
                return fertilizanteRetornar;
            }else{
                return null;
            }
        }else{
            return null;
        }  
    }
    
    /**
     *
     * @param ica
     * @param listaFertilizantes
     */
    public static void actualizarFer(String ica,ArrayList<ControlFertilizante>listaFertilizantes){
        ControlFertilizante fertilizante;
        int option;
        Scanner tecladoInt = new Scanner(System.in);
        fertilizante = buscarPorIcaFer(ica, listaFertilizantes);
        
        if(fertilizante == null){
            System.out.println("El producto no se encontro.");
        }else{
            
            do{
                menuFertilizante();
                option = tecladoInt.nextInt();
                
                switch(option){
                    case 1:
                        actualizarIca(fertilizante);
                        break;
                    case 2:
                        actualizarNombre(fertilizante);
                        break;
                    case 3:
                        actualizarFrecuenciaAplicaicon(fertilizante);
                        break;
                    case 4:
                        actualizarFechaUltimaAplicacion(fertilizante);
                        break;
                    case 5:
                        break;
                }
            }while(option < 5);
        }
    }
     
    public static void actualizarPla(String ica,ArrayList<ControlPlagas>listaPlagas){
        ControlPlagas plaga;
        int option;
        Scanner tecladoInt = new Scanner(System.in);
        plaga = buscarPorIcaPla(ica, listaPlagas);
        
        if(plaga == null){
            System.out.println("El producto no se encontro.");
        }else{
            
            do{
                menuPlaga();
                option = tecladoInt.nextInt();
                
                switch(option){
                    case 1:
                        actualizarIca(plaga);
                        break;
                    case 2:
                        actualizarNombre(plaga);
                        break;
                    case 3:
                        actualizarFrecuenciaAplicaicon(plaga);
                        break;
                    case 4:
                        actualizarPeriodoCarencia(plaga);
                        break;
                    case 5:
                        break;
                }
            }while(option < 5);
        }
    }
    
    private static void actualizarNombre(ControlPlagas plaga){
        String nuevoNombre;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el nuevo nombre: ");
        nuevoNombre = tecladoString.nextLine();
        plaga.setNombreProducto(nuevoNombre);
    }
    
    private static void actualizarFrecuenciaAplicaicon(ControlPlagas plaga) {
        int nuevaFrecuencia;
        Scanner tecladoInt = new Scanner(System.in);
        System.out.print("Ingrese el nuevo nombre: ");
        nuevaFrecuencia = tecladoInt.nextInt();
        plaga.setFrecuenciaAplicacion(nuevaFrecuencia);
    }
    
    private static void actualizarIca(ControlPlagas plaga){
        String nuevoIca;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el nuevo ica: ");
        nuevoIca = tecladoString.nextLine();
        plaga.setIca(nuevoIca);
    }
    
    private static void actualizarPeriodoCarencia(ControlPlagas plaga) {
        int nuevoPeriodo;
        Scanner tecladoInt = new Scanner(System.in);
        System.out.print("Ingrese el nuevo periodo de carencia: ");
        nuevoPeriodo = tecladoInt.nextInt();
        plaga.setPeriodoCarencia(nuevoPeriodo);
    }
    
    private static void actualizarNombre(ControlFertilizante fertilizante){
        String nuevoNombre;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el nuevo nombre: ");
        nuevoNombre = tecladoString.nextLine();
        fertilizante.setNombreProducto(nuevoNombre);
    }
    
    private static void actualizarFrecuenciaAplicaicon(ControlFertilizante fertilizante) {
        int nuevaFrecuencia;
        Scanner tecladoInt = new Scanner(System.in);
        System.out.print("Ingrese el nuevo nombre: ");
        nuevaFrecuencia = tecladoInt.nextInt();
        fertilizante.setFrecuenciaAplicacion(nuevaFrecuencia);
    }
    
    private static void actualizarIca(ControlFertilizante fertilizante){
        String nuevoIca;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el nuevo ica: ");
        nuevoIca = tecladoString.nextLine();
        fertilizante.setIca(nuevoIca);
    }
    
    private static void actualizarFechaUltimaAplicacion(ControlFertilizante fertilizante) {
        int nuevoPeriodo;
        Scanner tecladoInt = new Scanner(System.in);
        System.out.print("Ingrese la nueva fecha de apliacion: ");
        nuevoPeriodo = tecladoInt.nextInt();
        fertilizante.setFrecuenciaAplicacion(nuevoPeriodo);
    }
    
    private static void menuPlaga(){
        System.out.println("Escoja los valores a modificar: ");
        System.out.println("1.Actualizar ICA.");
        System.out.println("2.Actualizar nombre.");
        System.out.println("3.Actualizar frecuencia de aplicacion.");
        System.out.println("4.Actualizar periodo de carencia.");
        System.out.println("5.Salir.");
    }
    
    private static void menuFertilizante(){
        System.out.println("Escoja los valores a modificar: ");
        System.out.println("1.Actualizar ICA.");
        System.out.println("2.Actualizar nombre.");
        System.out.println("3.Actualizar frecuencia de aplicacion.");
        System.out.println("4.Actualizar la ultima fecha de aplicacion.");
        System.out.println("5.Salir.");
    }
}
