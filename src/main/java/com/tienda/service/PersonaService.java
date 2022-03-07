package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

public interface PersonaService {
    public List<Persona> getPersonas();
    
    public void save(Persona persona);
    
    public void delete(Persona persona);
    
    public Persona getPersona(Persona persona);
}
