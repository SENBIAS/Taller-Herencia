/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

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
