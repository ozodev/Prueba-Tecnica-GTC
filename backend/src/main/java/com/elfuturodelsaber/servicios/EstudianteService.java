package com.elfuturodelsaber.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elfuturodelsaber.dtos.EstudianteAsignaturaDto;
import com.elfuturodelsaber.dtos.EstudianteDto;
import com.elfuturodelsaber.dtos.RegistroEstudianteAsignaturaDto;
import com.elfuturodelsaber.entidades.Asignatura;
import com.elfuturodelsaber.entidades.Estudiante;
import com.elfuturodelsaber.entidades.EstudianteAsignatura;
import com.elfuturodelsaber.repositorios.AsignaturaRepository;
import com.elfuturodelsaber.repositorios.EstudianteAsignaturaRepository;
import com.elfuturodelsaber.repositorios.EstudianteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final EstudianteAsignaturaRepository estudianteAsignaturaRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository,
            AsignaturaRepository asignaturaRepository,
            EstudianteAsignaturaRepository estudianteAsignaturaRepository) {
        this.estudianteRepository = estudianteRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.estudianteAsignaturaRepository = estudianteAsignaturaRepository;
    }

    @Transactional(readOnly = true)
    public List<EstudianteDto> findAllStudents() {
        return estudianteRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EstudianteDto findStudentById(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return convertToDto(estudiante);
    }

    @Transactional
    public EstudianteDto createStudent(EstudianteDto estudianteDto) {
        Estudiante estudiante = convertToEntity(estudianteDto);
        estudiante = estudianteRepository.save(estudiante);
        return convertToDto(estudiante);
    }

    @Transactional
    public EstudianteDto updateStudent(Long id, EstudianteDto estudianteDto) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        // Actualiza los datos del estudiante con los datos del DTO
        estudiante.setNombres(estudianteDto.getNombres());
        estudiante.setApellidos(estudianteDto.getApellidos());
        estudiante.setEmail(estudianteDto.getEmail());
        // Aquí puedes continuar actualizando el resto de campos que sean necesarios

        estudiante = estudianteRepository.save(estudiante);
        return convertToDto(estudiante);
    }

    @Transactional
    public void deleteStudent(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        estudianteRepository.delete(estudiante);
    }

    @Transactional
    public EstudianteAsignaturaDto registerStudentToSubject(Long estudianteId, Long asignaturaId,
            RegistroEstudianteAsignaturaDto registroDto) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Asignatura asignatura = asignaturaRepository.findById(asignaturaId)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        EstudianteAsignatura estudianteAsignatura = new EstudianteAsignatura();
        estudianteAsignatura.setEstudiante(estudiante);
        estudianteAsignatura.setAsignatura(asignatura);
        estudianteAsignatura.setNota(registroDto.getNota());
        estudianteAsignatura.setPeriodo(registroDto.getPeriodo());

        estudianteAsignatura = estudianteAsignaturaRepository.save(estudianteAsignatura);

        // Convertimos el resultado a DTO antes de devolverlo
        return convertToEstudianteAsignaturaDto(estudianteAsignatura);
    }

    // Método auxiliar para convertir una entidad en un DTO
    private EstudianteDto convertToDto(Estudiante estudiante) {
        EstudianteDto dto = new EstudianteDto();
        dto.setId(estudiante.getId());
        dto.setNombres(estudiante.getNombres());
        dto.setApellidos(estudiante.getApellidos());
        dto.setEmail(estudiante.getEmail());
        dto.setAsignaturasIds(estudianteAsignaturaRepository
                .findByEstudianteId(estudiante.getId())
                .stream()
                .map(estudianteAsignatura -> estudianteAsignatura.getAsignatura().getId())
                .collect(Collectors.toList()));
        return dto;
    }

    // Método auxiliar para convertir un DTO en una entidad
    private Estudiante convertToEntity(EstudianteDto estudianteDto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(estudianteDto.getId());
        estudiante.setNombres(estudianteDto.getNombres());
        estudiante.setApellidos(estudianteDto.getApellidos());
        estudiante.setEmail(estudianteDto.getEmail());
        return estudiante;
    }

    // Método auxiliar para convertir una entidad EstudianteAsignatura en un DTO
    private EstudianteAsignaturaDto convertToEstudianteAsignaturaDto(EstudianteAsignatura estudianteAsignatura) {
        EstudianteAsignaturaDto dto = new EstudianteAsignaturaDto();
        dto.setEstudianteId(estudianteAsignatura.getEstudiante().getId());
        dto.setAsignaturaId(estudianteAsignatura.getAsignatura().getId());
        dto.setNota(estudianteAsignatura.getNota());
        dto.setPeriodo(estudianteAsignatura.getPeriodo());
        return dto;
    }
}
