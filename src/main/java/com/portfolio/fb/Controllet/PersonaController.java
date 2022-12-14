package com.portfolio.fb.Controllet;

import com.portfolio.fb.Dto.dtoPersona;
import com.portfolio.fb.Entity.Persona;
import com.portfolio.fb.Interface.IPersonaService;
import com.portfolio.fb.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://portfolio-b6ed1.web.app")
public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id) {
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    // URL: port/personas/editar/4/nombre & apellido & img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editPersona(@PathVariable("id") int id, @RequestBody dtoPersona dtop) {
            
        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(dtop.getNombre());
        persona.setApellido(dtop.getApellido());
        persona.setImg(dtop.getImg());
        persona.setAbout(dtop.getAbout());

        ipersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("Atributos actualizados"), HttpStatus.OK);

    }

    @GetMapping("/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((int) 1);
    }
}
