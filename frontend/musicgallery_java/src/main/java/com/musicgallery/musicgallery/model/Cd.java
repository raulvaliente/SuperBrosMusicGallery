package com.musicgallery.musicgallery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cd")
public class Cd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String artista;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer anio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tienda_id", nullable = false)
    private Tienda tienda;

    public Cd() {}

    public Cd(String titulo, String artista, String genero, Double precio, Integer anio, Tienda tienda) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.precio = precio;
        this.anio = anio;
        this.tienda = tienda;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public Tienda getTienda() { return tienda; }
    public void setTienda(Tienda tienda) { this.tienda = tienda; }
}