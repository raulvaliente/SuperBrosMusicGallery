package com.musicgallery.musicgallery.repository;

import com.musicgallery.musicgallery.model.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CdRepository extends JpaRepository<Cd, Long> {
    List<Cd> findByTiendaId(Long tiendaId);
}