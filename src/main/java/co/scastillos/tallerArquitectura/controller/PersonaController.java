package co.scastillos.tallerArquitectura.controller;

import co.scastillos.tallerArquitectura.dto.PersonaDto;
import co.scastillos.tallerArquitectura.service.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {


    @Autowired
    ServicioPersona servicioPersona;

    @GetMapping({  "/personas"})
    public String listarEquipos(Model model){
        model.addAttribute("personas",servicioPersona.listarPersonas());
        return "personas";
    }
    @GetMapping("/personas/nuevo")
    public String mostrarFormulario(Model model){
        PersonaDto personaDto = new PersonaDto();
        model.addAttribute("persona", personaDto);
        return "crear_persona";
    }
    @PostMapping("/personas")
    public String registrarEquipo(@ModelAttribute("persona") PersonaDto personaDto) {
        servicioPersona.crear(personaDto);
        return "redirect:/personas";
    }


    @GetMapping("/personas/modificar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model){
        PersonaDto personaDto = new PersonaDto();
        model.addAttribute("persona", servicioPersona.obtenerPersona(id));
        return "editar_persona";
    }

    @PostMapping("/personas/{id}")
    public String modificarEquipo(@PathVariable Long id,@ModelAttribute( "persona") PersonaDto personaDto, Model model){
        model.addAttribute("persona", servicioPersona.actualizar(personaDto));
        return "redirect:/personas";
    }
    @GetMapping("/personas/{id}")
    public String eliminarEquipo(@PathVariable Long id){

        servicioPersona.eliminar(id);
        return "redirect:/personas";
    }

}
