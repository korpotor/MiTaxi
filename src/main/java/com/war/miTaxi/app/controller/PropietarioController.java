/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.miTaxi.app.controller;

import com.war.miTaxi.app.EJB.PropietarioFacadeLocal;
import com.war.miTaxi.app.model.Persona;
import com.war.miTaxi.app.model.Propietario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Spetsnaz
 */
@Named
@ViewScoped
public class PropietarioController implements Serializable{

    @EJB
    private PropietarioFacadeLocal propietarioFacadeLocalEJB ;
    
    private Persona persona ;
    
    private Propietario propietario ;   
    
    private List<Persona> personas ;
    
    private List<Propietario> propietarios ;
    
    @PostConstruct
    public void init(){        
        persona = new Persona() ;
        propietario = new Propietario() ;
        propietarios = propietarioFacadeLocalEJB.findAll() ;
    }
    
    public void create(){
        propietario.setPersona(persona);
        propietarioFacadeLocalEJB.create(propietario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Registro exitoso"));
    }
    
    public void edit(Propietario propietario){
        propietario.setPersona(persona);         
        System.out.println(propietario);
        propietarioFacadeLocalEJB.edit(propietario);
        propietarios = propietarioFacadeLocalEJB.findAll() ;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Edición exitosa"));
        
    }
    
    public void remove(Propietario propietario){
        propietarioFacadeLocalEJB.remove(propietario);
        propietarios = propietarioFacadeLocalEJB.findAll() ;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Registro eliminado con exitoso"));
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }
    
    
}
