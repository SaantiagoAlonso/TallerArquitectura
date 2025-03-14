package co.scastillos.tallerArquitectura.repository;

import co.scastillos.tallerArquitectura.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,Long> {
}
