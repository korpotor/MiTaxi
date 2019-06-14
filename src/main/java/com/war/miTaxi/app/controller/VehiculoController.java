/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.miTaxi.app.controller;

import com.war.miTaxi.app.EJB.VehiculoFacadeLocal;
import com.war.miTaxi.app.model.Vehiculo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Spetsnaz
 */
@Named
@ViewScoped
public class VehiculoController implements Serializable{
    
    @EJB
    private VehiculoFacadeLocal vehiculoFacadeLocalEJB ;
    
    private Vehiculo vehiculo ;
    
    private List<Vehiculo> vehiculos ;
    
    @PostConstruct
    public void init(){
        vehiculo =  new Vehiculo() ;
        vehiculos =  vehiculoFacadeLocalEJB.findAll() ;
    }
    
    public void create(){
       vehiculoFacadeLocalEJB.create(vehiculo);
       vehiculos = vehiculoFacadeLocalEJB.findAll() ;
    }
    
    public void edit(Vehiculo vehiculo){
        
    }
    
    public void remove(Vehiculo vehiculo){
        
    }
    
    public void findAll(){
        
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    
}
