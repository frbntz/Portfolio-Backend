package com.portfolio.fb.Repository;

import com.portfolio.fb.Entity.HSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHSkill extends JpaRepository<HSkill, Integer> {

    public Optional<HSkill> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
