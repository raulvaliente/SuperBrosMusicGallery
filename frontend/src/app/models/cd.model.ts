export interface Cd {
  id?: number;
  titulo: string;
  artista: string;
  genero: string;
  precio: number;
  anio: number;
  tiendaId: number;
  tiendaNombre?: string;
}

export interface CrearCdRequest {
  titulo: string;
  artista: string;
  genero: string;
  precio: number;
  anio: number;
  tiendaId: number;
}