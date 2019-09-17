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
        Scanner tecladoInt = new Scanner(System.in);
        Inventario inventario = new Inventario();
        
        do {            
            menu();
            System.out.println("Seleccione una opcion: ");
            option = tecladoInt.nextInt();
            switch (option) {
                case 1:
                    Inventario.menuAgregar(inventario);
                    break;
                case 2:
                    Inventario.buscar(inventario);
                    break;
                case 3:
                    Inventario.actualizar(inventario);
                    break;
                case 4:
                    Inventario.eliminar(inventario);
                    break;
                case 5:
                    CRUD.mostrarProductos(inventario.getPlagas(), inventario.getFertilizantes());
                    break;
                case 6:
                    break;
            }
        } while (option<6);
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
