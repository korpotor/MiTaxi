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
public class PropietarioController implements Serializable {

    @EJB
    private PropietarioFacadeLocal propietarioFacadeLocalEJB;

    private Persona persona;

    private Propietario propietario;

    private List<Persona> personas;

    private List<Propietario> propietarios;

    @PostConstruct
    public void init() {
        persona = new Persona();
        propietario = new Propietario();
        propietarios = propietarioFacadeLocalEJB.findAll();
    }

    public void create() {
        try {
            if (findById(persona) == null) {
                propietario.setPersona(persona);
                propietarioFacadeLocalEJB.create(propietario);
                propietarios = propietarioFacadeLocalEJB.findAll();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Registro exitoso"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Ya existe un registro la identificación"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error en el registro"));
        }

    }

    public void edit(Propietario propietario) {
        try {
            propietario.setPersona(propietario.getPersona());
            propietarioFacadeLocalEJB.edit(propietario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Edición exitosa"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al editar el registro"));
        }

    }

    public void remove(Propietario propietario) {
        try {
            propietarioFacadeLocalEJB.remove(propietario);
            propietarios = propietarioFacadeLocalEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Registro eliminado con exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar el registro"));
        }
    }

    public Propietario findById(Persona persona) {
        return propietarioFacadeLocalEJB.findById(persona);
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
