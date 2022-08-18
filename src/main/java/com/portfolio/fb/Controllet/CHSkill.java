package com.portfolio.fb.Controllet;

import com.portfolio.fb.Dto.dtoHSkill;
import com.portfolio.fb.Entity.HSkill;
import com.portfolio.fb.Security.Controller.Mensaje;
import com.portfolio.fb.Service.SHSkill;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/hskills")
@CrossOrigin(origins = "http://localhost:4200")
public class CHSkill {
    @Autowired
    SHSkill sHSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HSkill>> list(){
        List<HSkill> list = sHSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HSkill> getById(@PathVariable("id") int id){
        if(!sHSkill.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        HSkill experiencia = sHSkill.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        sHSkill.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHSkill dtohskill){      
        if(StringUtils.isBlank(dtohskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sHSkill.existsByNombre(dtohskill.getNombre()))
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
        
        HSkill hSkill = new HSkill(dtohskill.getNombre(), dtohskill.getPorcentaje(), dtohskill.getImg(), dtohskill.getColor());
        sHSkill.save(hSkill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHSkill dtohskill){
        //Validamos si existe el ID
        if(!sHSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sHSkill.existsByNombre(dtohskill.getNombre()) && sHSkill.getByNombre(dtohskill.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtohskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HSkill hSkill = sHSkill.getOne(id).get();
        hSkill.setNombre(dtohskill.getNombre());
        hSkill.setPorcentaje(dtohskill.getPorcentaje());
        hSkill.setImg(dtohskill.getImg());
        hSkill.setColor(dtohskill.getColor());
        
        sHSkill.save(hSkill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
             
    }
}