package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    
    private Long idpersona;
    
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    public Persona(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Persona() {
    }  
    
}
