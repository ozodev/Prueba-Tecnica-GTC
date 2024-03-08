package com.elfuturodelsaber.controlladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elfuturodelsaber.entidades.Dane;
import com.elfuturodelsaber.repositorios.DaneRepository;

import java.util.List;

@RestController
@RequestMapping("/dane")
public class DaneController {

    @Autowired
    private DaneRepository daneRepository;

    // Obtener todos los registros de Dane
    @GetMapping()
    public List<Dane> getAllDane() {
        return daneRepository.findAll();
    }

    // Obtener un registro de Dane por su ID
    @GetMapping("/{id}")
    public Dane getDaneById(@PathVariable Long id) {
        return daneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro Dane con la id: " + id));
    }

    // Crear un nuevo registro de Dane
    @PostMapping()
    public Dane createDane(@RequestBody Dane dane) {
        return daneRepository.save(dane);
    }

    // Actualizar un registro de Dane
    @PutMapping("/{id}")
    public Dane updateDane(@PathVariable Long id, @RequestBody Dane daneDetails) {
        Dane dane = daneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro Dane con la id: " + id));
        dane.setDescripcion(daneDetails.getDescripcion());
        dane.setTipoDane(daneDetails.getTipoDane());
        return daneRepository.save(dane);
    }

    // Eliminar un registro de Dane
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDane(@PathVariable Long id) {
        Dane dane = daneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro Dane con la id: " + id));
        daneRepository.delete(dane);
        return new ResponseEntity<>("Dane eliminada Correctamente",HttpStatus.ACCEPTED);
    }
}