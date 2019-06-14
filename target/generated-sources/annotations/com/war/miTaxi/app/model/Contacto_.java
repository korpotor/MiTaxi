package com.war.miTaxi.app.model;

import com.war.miTaxi.app.model.Conductor;
import com.war.miTaxi.app.model.Propietario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.3.v20160914-rNA", date="2019-06-14T09:43:51")
@StaticMetamodel(Contacto.class)
public class Contacto_ { 

    public static volatile SingularAttribute<Contacto, Propietario> propietario;
    public static volatile SingularAttribute<Contacto, Integer> id;
    public static volatile SingularAttribute<Contacto, Conductor> conductor;

}