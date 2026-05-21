import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tienda, CrearTiendaRequest } from '../models/tienda.model';
import { Cd } from '../models/cd.model';

@Injectable({
  providedIn: 'root'
})
export class TiendaService {

  private apiUrl = '/api/tiendas';

  constructor(private http: HttpClient) {}

  getTiendas(): Observable<Tienda[]> {
    return this.http.get<Tienda[]>(this.apiUrl);
  }

  getTiendaById(id: number): Observable<Tienda> {
    return this.http.get<Tienda>(`${this.apiUrl}/${id}`);
  }

  getCdsByTienda(tiendaId: number): Observable<Cd[]> {
    return this.http.get<Cd[]>(`${this.apiUrl}/${tiendaId}/cds`);
  }

  crearTienda(tienda: CrearTiendaRequest): Observable<Tienda> {
    return this.http.post<Tienda>(this.apiUrl, tienda);
  }

  eliminarTienda(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}