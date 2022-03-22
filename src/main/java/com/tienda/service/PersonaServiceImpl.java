package com.tienda.service;

import com.tienda.dao.PersonaDao;
import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {
    
    @Autowired
    
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> getPersonas() {
        return (List<Persona>) personaDao.findAll(); 
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        personaDao.save(persona); 
    }

    @Override
    @Transactional
    public void delete(Persona persona) {
        personaDao.delete(persona); 
    }

    @Override
    @Transactional(readOnly = true)
    public Persona getPersona(Persona persona) {
        return personaDao.findById(persona.getIdpersona()).orElse(null);
    }
    
}
