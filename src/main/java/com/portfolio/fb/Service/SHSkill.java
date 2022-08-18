package com.portfolio.fb.Service;

import com.portfolio.fb.Entity.HSkill;
import com.portfolio.fb.Repository.RHSkill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHSkill {
    @Autowired
    RHSkill rHSkill;
    
    public List<HSkill> list(){
        return rHSkill.findAll();
    }
    
    public Optional<HSkill> getOne(int id){
        return rHSkill.findById(id);
    }
    
    public Optional<HSkill> getByNombre(String nombre){
        return rHSkill.findByNombre(nombre);
    }
    
   public void save(HSkill hSkill){
       rHSkill.save(hSkill);
   }
    
   public void delete(int id){
       rHSkill.deleteById(id);
   }
   
   public boolean existsById(int id){
       return rHSkill.existsById(id);
   }
   
   public boolean existsByNombre(String nombre){
       return rHSkill.existsByNombre(nombre);
   }
}
