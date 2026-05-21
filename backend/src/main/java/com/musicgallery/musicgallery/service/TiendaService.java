package com.musicgallery.musicgallery.service;

import com.musicgallery.musicgallery.dto.TiendaDTO;
import com.musicgallery.musicgallery.model.Tienda;
import com.musicgallery.musicgallery.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    public List<TiendaDTO> findAll() {
        return tiendaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<TiendaDTO> findById(Long id) {
        return tiendaRepository.findById(id)
                .map(this::convertToDTO);
    }

    public TiendaDTO save(TiendaDTO dto) {
        Tienda tienda = convertToEntity(dto);
        Tienda saved = tiendaRepository.save(tienda);
        return convertToDTO(saved);
    }

    public void deleteById(Long id) {
        tiendaRepository.deleteById(id);
    }

    private TiendaDTO convertToDTO(Tienda tienda) {
        TiendaDTO dto = new TiendaDTO();
        dto.setId(tienda.getId());
        dto.setNombre(tienda.getNombre());
        dto.setDireccion(tienda.getDireccion());
        dto.setTelefono(tienda.getTelefono());
        return dto;
    }

    private Tienda convertToEntity(TiendaDTO dto) {
        Tienda tienda = new Tienda();
        tienda.setNombre(dto.getNombre());
        tienda.setDireccion(dto.getDireccion());
        tienda.setTelefono(dto.getTelefono());
        return tienda;
    }
}
