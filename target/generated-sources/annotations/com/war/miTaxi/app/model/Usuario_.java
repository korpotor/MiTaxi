package com.war.miTaxi.app.model;

import com.war.miTaxi.app.model.Persona;
import com.war.miTaxi.app.model.Rol;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.3.v20160914-rNA", date="2019-06-14T09:43:51")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Persona> persona;
    public static volatile SingularAttribute<Usuario, String> user;
    public static volatile SingularAttribute<Usuario, Date> createAt;
    public static volatile SingularAttribute<Usuario, Rol> rol;

}