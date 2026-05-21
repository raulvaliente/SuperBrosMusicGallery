package com.musicgallery.musicgallery.service;

import com.musicgallery.musicgallery.dto.CdDTO;
import com.musicgallery.musicgallery.model.Cd;
import com.musicgallery.musicgallery.model.Tienda;
import com.musicgallery.musicgallery.repository.CdRepository;
import com.musicgallery.musicgallery.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CdService {

    @Autowired
    private CdRepository cdRepository;

    @Autowired
    private TiendaRepository tiendaRepository;

    public List<CdDTO> findAll() {
        return cdRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CdDTO> findById(Long id) {
        return cdRepository.findById(id)
                .map(this::convertToDTO);
    }

    public List<CdDTO> findByTiendaId(Long tiendaId) {
        return cdRepository.findByTiendaId(tiendaId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CdDTO save(CdDTO dto) {
        Tienda tienda = tiendaRepository.findById(dto.getTiendaId())
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada con id: " + dto.getTiendaId()));
        Cd cd = convertToEntity(dto, tienda);
        Cd saved = cdRepository.save(cd);
        return convertToDTO(saved);
    }

    public void deleteById(Long id) {
        cdRepository.deleteById(id);
    }

    private CdDTO convertToDTO(Cd cd) {
        CdDTO dto = new CdDTO();
        dto.setId(cd.getId());
        dto.setTitulo(cd.getTitulo());
        dto.setArtista(cd.getArtista());
        dto.setGenero(cd.getGenero());
        dto.setPrecio(cd.getPrecio());
        dto.setAnio(cd.getAnio());
        dto.setTiendaId(cd.getTienda().getId());
        dto.setTiendaNombre(cd.getTienda().getNombre());
        return dto;
    }

    private Cd convertToEntity(CdDTO dto, Tienda tienda) {
        Cd cd = new Cd();
        cd.setTitulo(dto.getTitulo());
        cd.setArtista(dto.getArtista());
        cd.setGenero(dto.getGenero());
        cd.setPrecio(dto.getPrecio());
        cd.setAnio(dto.getAnio());
        cd.setTienda(tienda);
        return cd;
    }
}
