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
public class ControlFertilizante extends ProductosDeControl {
    //ATRIBUTOS
    private String fechaUltimaAplicacion;
    
    //CONSTRUCTOR

    public ControlFertilizante(String fechaUltimaAplicacion, String ica, String nombreProducto, int frecuenciaAplicacion) {
        super(ica, nombreProducto, frecuenciaAplicacion);
        this.fechaUltimaAplicacion = fechaUltimaAplicacion;
    }
    
    //METODOS

    public String getFechaUltimaAplicacion() {
        return fechaUltimaAplicacion;
    }

    public void setFechaUltimaAplicacion(String fechaUltimaAplicacion) {
        this.fechaUltimaAplicacion = fechaUltimaAplicacion;
    }
    
}
