package co.scastillos.tallerArquitectura.dto;

import co.scastillos.tallerArquitectura.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonaDto {

    private Long id;

    private Integer cedula;

    private String nombre;

    private Integer telefono;

    private Integer edad;

    private String profesion;


    public PersonaDto(Persona p) {
        this.id = p.getId();
        this.cedula = p.getCedula();
        this.nombre = p.getNombre();
        this.telefono = p.getTelefono();
        this.edad = p.getEdad();
        this.profesion = p.getProfesion();
    }
}
