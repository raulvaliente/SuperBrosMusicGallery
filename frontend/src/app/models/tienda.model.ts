export interface Tienda {
  id?: number;
  nombre: string;
  direccion: string;
  telefono: string;
}

export interface CrearTiendaRequest {
  nombre: string;
  direccion: string;
  telefono: string;
}