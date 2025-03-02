package co.scastillos.tallerArquitectura.service;

import co.scastillos.tallerArquitectura.dto.PersonaDto;
import co.scastillos.tallerArquitectura.entity.Persona;
import co.scastillos.tallerArquitectura.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPersona {

    @Autowired
    private PersonaRepo personaRepo;

    public void crear(PersonaDto personaDto){
        Persona persona = new Persona(personaDto);
        personaRepo.save(persona);
    }

    public List<PersonaDto> listarPersonas(){
        return personaRepo.findAll().stream().map(PersonaDto::new).toList();
    }

    public PersonaDto actualizar(PersonaDto personaDto){
        Persona persona = personaRepo.getReferenceById(personaDto.getId());
        if (personaDto.getCedula() != null){
            persona.setCedula(personaDto.getCedula());
        }
        if (personaDto.getNombre() != null){
            persona.setNombre(personaDto.getNombre());
        }
        if (personaDto.getEdad() != null){
            persona.setEdad(personaDto.getEdad());
        }
        if (personaDto.getTelefono() != null){
            persona.setTelefono(personaDto.getTelefono());
        }
        if (personaDto.getProfesion() != null){
            persona.setProfesion(personaDto.getProfesion());
        }

        Persona personaActulizada = personaRepo.save(persona);
        return new PersonaDto(personaActulizada);
    }

    public PersonaDto obtenerPersona(Long id){
        Persona persona = personaRepo.getReferenceById(id);
        return  new PersonaDto(persona);
    }

    public void eliminar(Long id){
        personaRepo.deleteById(id);
    }



}
