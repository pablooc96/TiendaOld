package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private PersonaService personaService;
 /**
 esta funcion hace que cuando esta en localhost/ lo redirija al login, es necesario pasar el html que se pone en return a la carpeta templates
 si quiero mas palabras para poder llegar al mismo lugar le pongo {} y lo separo con comas
     * @param model
     * @return 
 */
    
    @GetMapping({"/","/perro"})
    public String index(Model model){
        log.info("Estamos usando una arquitectura mvc");
        
        var personas = personaService.getPersonas();
                
        model.addAttribute("personas",personas);
        return "index";
    }
    
    @GetMapping("/nuevaPersona")
    public String nuevaPersona(Persona persona){
        return "modificarPersona"; 
    }
    
    @PostMapping("/guardarPersona")
    public String guardarPersona(Persona persona){
        personaService.save(persona);
        return "redirect:/";
    }
    
    @GetMapping("/modificarPersona/{idpersona}")
    public String modificarPersona(Persona persona, Model model) {
        persona = personaService.getPersona(persona);
        model.addAttribute("persona",persona);
        return "modificarPersona";
    }
    
    @GetMapping("/eliminarPersona/{idpersona}")
    public String eliminarPersona(Persona persona) {
        personaService.delete(persona);
        return "redirect:/";
    }
    
}
