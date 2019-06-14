package com.war.miTaxi.app.model;

import com.war.miTaxi.app.model.Persona;
import com.war.miTaxi.app.model.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.3.v20160914-rNA", date="2019-06-14T09:43:51")
@StaticMetamodel(Conductor.class)
public class Conductor_ { 

    public static volatile SingularAttribute<Conductor, Persona> persona;
    public static volatile SingularAttribute<Conductor, String> foto;
    public static volatile SingularAttribute<Conductor, Vehiculo> vehiculo;

}