package com.elfuturodelsaber.controlladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salud")
public class Health {

    /**
     * Salud del Servidor
     * @return
     */
    @GetMapping
    public ResponseEntity<String> salud() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}