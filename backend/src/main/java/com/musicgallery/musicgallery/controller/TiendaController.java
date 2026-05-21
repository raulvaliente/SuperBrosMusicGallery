package com.musicgallery.musicgallery.controller;

import com.musicgallery.musicgallery.dto.CdDTO;
import com.musicgallery.musicgallery.dto.TiendaDTO;
import com.musicgallery.musicgallery.service.CdService;
import com.musicgallery.musicgallery.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiendas")
@CrossOrigin(origins = "http://localhost:4200")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @Autowired
    private CdService cdService;

    @GetMapping
    public ResponseEntity<List<TiendaDTO>> getAll() {
        return ResponseEntity.ok(tiendaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> getById(@PathVariable Long id) {
        return tiendaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/cds")
    public ResponseEntity<List<CdDTO>> getCdsByTienda(@PathVariable Long id) {
        return ResponseEntity.ok(cdService.findByTiendaId(id));
    }

    @PostMapping
    public ResponseEntity<TiendaDTO> create(@RequestBody TiendaDTO dto) {
        TiendaDTO saved = tiendaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tiendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
