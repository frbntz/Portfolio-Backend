package com.portfolio.fb.Interface;

import com.portfolio.fb.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(int id);
    
    //Buscar una persona
    public Persona findPersona(int id);
}
