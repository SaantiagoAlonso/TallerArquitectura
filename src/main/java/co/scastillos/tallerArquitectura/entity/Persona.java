package co.scastillos.tallerArquitectura.entity;

import co.scastillos.tallerArquitectura.dto.PersonaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity(name = "PERSONAS")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cedula;

    private String nombre;

    private Integer telefono;

    private Integer edad;

    private String profesion;


    public Persona(PersonaDto personaDto) {
        this.cedula = personaDto.getCedula();
        this.nombre = personaDto.getNombre();
        this.telefono = personaDto.getTelefono();
        this.edad = personaDto.getEdad();
        this.profesion = personaDto.getProfesion();
    }
}
