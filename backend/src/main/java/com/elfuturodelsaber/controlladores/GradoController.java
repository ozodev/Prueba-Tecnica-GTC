package com.elfuturodelsaber.controlladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elfuturodelsaber.dtos.DocenteDto;
import com.elfuturodelsaber.dtos.EstudianteGradoDto;
import com.elfuturodelsaber.dtos.GradoDto;
import com.elfuturodelsaber.entidades.Docente;
import com.elfuturodelsaber.entidades.Estudiante;
import com.elfuturodelsaber.entidades.Grado;
import com.elfuturodelsaber.repositorios.GradoRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grado")
public class GradoController {

    @Autowired
    private GradoRepository gradoRepository;

    // Endpoint para obtener todos los grados
    @GetMapping
    public ResponseEntity<List<GradoDto>> getAllGrados() {
        List<Grado> gradoList = gradoRepository.findAll();
        List<GradoDto> gradoDtoList = gradoList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(gradoDtoList, HttpStatus.OK);
    }

    // Endpoint para obtener un grado por su ID
    @GetMapping("/{id}")
    public ResponseEntity<GradoDto> getGradoById(@PathVariable Long id) {
        Grado grado = gradoRepository.findById(id).orElse(null);
        if (grado != null) {
            GradoDto gradoDto = convertToDto(grado);
            return new ResponseEntity<>(gradoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para agregar un nuevo grado
    @PostMapping
    public ResponseEntity<Grado> addGrado(@RequestBody Grado grado) {
        Grado newGrado = gradoRepository.save(grado);
        return new ResponseEntity<>(newGrado, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un grado existente
    @PutMapping("/{id}")
    public ResponseEntity<Grado> updateGrado(@PathVariable Long id, @RequestBody Grado gradoDetails) {
        Grado grado = gradoRepository.findById(id)
                .orElse(null);
        if (grado != null) {
            grado.setDescripcion(gradoDetails.getDescripcion());
            Grado updatedGrado = gradoRepository.save(grado);
            return new ResponseEntity<>(updatedGrado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un grado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrado(@PathVariable Long id) {
        Grado grado = gradoRepository.findById(id)
                .orElse(null);
        if (grado != null) {
            gradoRepository.delete(grado);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para convertir una entidad Grado a un DTO GradoDto
    private GradoDto convertToDto(Grado grado) {
        GradoDto gradoDto = new GradoDto();
        gradoDto.setId(grado.getId());
        gradoDto.setDescripcion(grado.getDescripcion());
        gradoDto.setDocente(convertToDocenteDto(grado.getDocenteResponsable()));
        gradoDto.setEstudiantes(convertToEstudianteGradoDtoList(grado.getEstudiantes()));
        return gradoDto;
    }

    // Método para convertir una entidad Docente a un DTO DocenteDto
    private DocenteDto convertToDocenteDto(Docente docente) {
        DocenteDto docenteDto = new DocenteDto();
        if(docente != null){
            docenteDto.setId(docente.getId());
            docenteDto.setNombres(docente.getNombres());
            docenteDto.setApellidos(docente.getApellidos());
            docenteDto.setEmail(docente.getEmail());
        }
        return docenteDto;
    }

    // Método para convertir una lista de entidades Estudiante a una lista de DTO EstudianteGradoDto
    private List<EstudianteGradoDto> convertToEstudianteGradoDtoList(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(estudiante -> {
                    EstudianteGradoDto estudianteGradoDto = new EstudianteGradoDto();
                    estudianteGradoDto.setEstudianteId(estudiante.getId());
                    return estudianteGradoDto;
                })
                .collect(Collectors.toList());
    }
}