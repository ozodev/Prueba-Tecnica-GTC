package com.elfuturodelsaber.controlladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.elfuturodelsaber.entidades.TipoDocumento;
import com.elfuturodelsaber.repositorios.TipoDocumentoRepository;

import java.util.List;

@RestController
@RequestMapping("/tipo-documento")
public class TipoDocumentoController {

    private static final String TIPO_DE_DOCUMENTO_NO_SE_ENCONTRO_CON_LA_ID = "Tipo de documento no se encontro con la Id ";
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    // Obtener todos los registros de TipoDocumento
    @GetMapping()
    public List<TipoDocumento> getAllTipoDocumento() {
        return tipoDocumentoRepository.findAll();
    }

    // Obtener un registro de TipoDocumento por su ID
    @GetMapping("/{id}")
    public TipoDocumento getTipoDocumentoById(@PathVariable Long id) {
        return tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(TIPO_DE_DOCUMENTO_NO_SE_ENCONTRO_CON_LA_ID + id));
    }

    // Crear un nuevo registro de TipoDocumento
    @PostMapping()
    public TipoDocumento createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    // Actualizar un registro de TipoDocumento
    @PutMapping("/{id}")
    public TipoDocumento updateTipoDocumento(@PathVariable Long id, @RequestBody TipoDocumento tipoDocumentoDetails) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(TIPO_DE_DOCUMENTO_NO_SE_ENCONTRO_CON_LA_ID + id));
        tipoDocumento.setDescripcion(tipoDocumentoDetails.getDescripcion());
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    // Eliminar un registro de TipoDocumento
    @DeleteMapping("/{id}")
    public String deleteTipoDocumento(@PathVariable Long id) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(TIPO_DE_DOCUMENTO_NO_SE_ENCONTRO_CON_LA_ID + id));
        tipoDocumentoRepository.delete(tipoDocumento);
        return "Tipo documento eliminado exitosamente";
    }
}
