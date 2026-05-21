package com.musicgallery.musicgallery.controller;

import com.musicgallery.musicgallery.dto.CdDTO;
import com.musicgallery.musicgallery.service.CdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cds")
@CrossOrigin(origins = "http://localhost:4200")
public class CdController {

    @Autowired
    private CdService cdService;

    @GetMapping
    public ResponseEntity<List<CdDTO>> getAll() {
        return ResponseEntity.ok(cdService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CdDTO> getById(@PathVariable Long id) {
        return cdService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CdDTO> create(@RequestBody CdDTO dto) {
        CdDTO saved = cdService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cdService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
