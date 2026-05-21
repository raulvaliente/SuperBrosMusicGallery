package com.musicgallery.musicgallery.dto;

public class CdDTO {

    private Long id;
    private String titulo;
    private String artista;
    private String genero;
    private Double precio;
    private Integer anio;
    private Long tiendaId;
    private String tiendaNombre;

    public CdDTO() {}

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
    public Long getTiendaId() { return tiendaId; }
    public void setTiendaId(Long tiendaId) { this.tiendaId = tiendaId; }
    public String getTiendaNombre() { return tiendaNombre; }
    public void setTiendaNombre(String tiendaNombre) { this.tiendaNombre = tiendaNombre; }
}
