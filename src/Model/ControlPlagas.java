/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sebastian
 */
public class ControlPlagas extends ProductosDeControl{
    //ATRIBUTOS
    
    private int periodoCarencia;
    
    //CONSTRUCTOR

    public ControlPlagas(int periodoCarencia, String ica, String nombreProducto, int frecuenciaAplicacion) {
        super(ica, nombreProducto, frecuenciaAplicacion);
        this.periodoCarencia = periodoCarencia;
    }
    
    //METODOS
    
    public int getPeriodoCarencia() {
        return periodoCarencia;
    }

    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }
    
    public void imprimirDatos(){
        System.out.println("Ica: "+getIca());
        System.out.println("Nombre producto: "+getNombreProducto());
        System.out.println("Frecuencia aplicacion: "+getFrecuenciaAplicacion());
        System.out.println("Periodo de carencia: "+getPeriodoCarencia());
    }
}
