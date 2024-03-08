package com.elfuturodelsaber.controlladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elfuturodelsaber.entidades.TipoDane;
import com.elfuturodelsaber.repositorios.TipoDaneRepository;

import java.util.List;

@RestController
@RequestMapping("/tipo-dane")
public class TipoDaneController {

    @Autowired
    private TipoDaneRepository tipoDaneRepository;

    // Endpoint para obtener todos los tipos de DANE
    @GetMapping
    public ResponseEntity<List<TipoDane>> getAllTipoDane() {
        List<TipoDane> tipoDaneList = tipoDaneRepository.findAll();
        return new ResponseEntity<>(tipoDaneList, HttpStatus.OK);
    }

    // Endpoint para obtener un tipo de DANE por su ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoDane> getTipoDaneById(@PathVariable Long id) {
        TipoDane tipoDane = tipoDaneRepository.findById(id)
                .orElse(null);
        if (tipoDane != null) {
            return new ResponseEntity<>(tipoDane, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para agregar un nuevo tipo de DANE
    @PostMapping
    public ResponseEntity<TipoDane> addTipoDane(@RequestBody TipoDane tipoDane) {
        TipoDane newTipoDane = tipoDaneRepository.save(tipoDane);
        return new ResponseEntity<>(newTipoDane, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un tipo de DANE existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoDane> updateTipoDane(@PathVariable Long id, @RequestBody TipoDane tipoDaneDetails) {
        TipoDane tipoDane = tipoDaneRepository.findById(id)
                .orElse(null);
        if (tipoDane != null) {
            tipoDane.setDescripcion(tipoDaneDetails.getDescripcion());
            TipoDane updatedTipoDane = tipoDaneRepository.save(tipoDane);
            return new ResponseEntity<>(updatedTipoDane, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un tipo de DANE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDane(@PathVariable Long id) {
        TipoDane tipoDane = tipoDaneRepository.findById(id)
                .orElse(null);
        if (tipoDane != null) {
            tipoDaneRepository.delete(tipoDane);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}