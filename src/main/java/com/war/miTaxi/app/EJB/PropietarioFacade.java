/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.miTaxi.app.EJB;

import com.war.miTaxi.app.model.Persona;
import com.war.miTaxi.app.model.Propietario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Spetsnaz
 */
@Stateless
public class PropietarioFacade extends AbstractFacade<Propietario> implements PropietarioFacadeLocal {

    @PersistenceContext(unitName = "com.war.miTaxi.app.model")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropietarioFacade() {
        super(Propietario.class);
    }

    @Override
    public Propietario findById(Persona persona) {
        String sql;
        Propietario propietario = null;
        try {
            sql = "FROM Propietario p WHERE p.persona = ?1";
            Query query = em.createQuery(sql).setParameter(1, persona);
            List<Propietario> propietarios = query.getResultList();
            if (!propietarios.isEmpty()) {
                propietario = propietarios.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return propietario;
    }

}
