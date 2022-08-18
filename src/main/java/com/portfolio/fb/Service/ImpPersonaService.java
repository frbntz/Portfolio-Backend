package com.portfolio.fb.Service;

import com.portfolio.fb.Entity.Persona;
import com.portfolio.fb.Interface.IPersonaService;
import com.portfolio.fb.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired
    IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepository.findAll();
        return persona;
    }
    
    public Optional<Persona> getOne(int id){
        return iPersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNmobre(String nombre){
        return iPersonaRepository.findByNombre(nombre);
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    
    public void deletePersona(int id) {
        iPersonaRepository.deleteById(id);
    }

    
    public Persona findPersona(int id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }

}
