package com.elfuturodelsaber.controlladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elfuturodelsaber.dtos.EstudianteAsignaturaDto;
import com.elfuturodelsaber.dtos.EstudianteDto;
import com.elfuturodelsaber.dtos.RegistroEstudianteAsignaturaDto;
import com.elfuturodelsaber.servicios.EstudianteService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // Obtener todos los estudiantes
    @GetMapping
    public ResponseEntity<List<EstudianteDto>> getAllStudents() {
        List<EstudianteDto> estudiantesDtos = estudianteService.findAllStudents();
        return ResponseEntity.ok(estudiantesDtos);
    }

    // Obtener un estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> getStudentById(@PathVariable Long id) {
        try {
            EstudianteDto estudianteDto = estudianteService.findStudentById(id);
            return ResponseEntity.ok(estudianteDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<EstudianteDto> createStudent(@RequestBody EstudianteDto estudianteDto) {
        EstudianteDto newStudentDto = estudianteService.createStudent(estudianteDto);
        return new ResponseEntity<>(newStudentDto, HttpStatus.CREATED);
    }

    // Actualizar un estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDto> updateStudent(@PathVariable Long id,
            @RequestBody EstudianteDto estudianteDto) {
        EstudianteDto updatedStudentDto = estudianteService.updateStudent(id, estudianteDto);
        if (updatedStudentDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudentDto);
    }

    // Eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            estudianteService.deleteStudent(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Registrar un estudiante en una asignatura
    @PostMapping("/{estudianteId}/asignaturas/{asignaturaId}")
    public ResponseEntity<EstudianteAsignaturaDto> registerStudentToSubject(
            @PathVariable Long estudianteId,
            @PathVariable Long asignaturaId,
            @RequestBody RegistroEstudianteAsignaturaDto registroDto) {
        EstudianteAsignaturaDto registro = estudianteService.registerStudentToSubject(
                estudianteId, asignaturaId, registroDto);
        if (registro != null) {
            return new ResponseEntity<>(registro, HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
