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
public class ProductosDeControl {
    //ATRIBUTOS
    private String ica;
    private String nombreProducto;
    private int frecuenciaAplicacion;

    //CONSTRUCTOR

    public ProductosDeControl(String ica, String nombreProducto, int frecuenciaAplicacion) {
        this.ica = ica;
        this.nombreProducto = nombreProducto;
        this.frecuenciaAplicacion = frecuenciaAplicacion;
    }
    
    
    //METODOS
    public String getIca() {
        return ica;
    }

    public void setIca(String ica) {
        this.ica = ica;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getFrecuenciaAplicacion() {
        return frecuenciaAplicacion;
    }

    public void setFrecuenciaAplicacion(int frecuenciaAplicacion) {
        this.frecuenciaAplicacion = frecuenciaAplicacion;
    }  
}
