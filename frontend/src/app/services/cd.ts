import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cd, CrearCdRequest } from '../models/cd.model';

@Injectable({
  providedIn: 'root'
})
export class CdService {

  private apiUrl = 'http://localhost:8080/api/cds';

  constructor(private http: HttpClient) {}

  getCds(): Observable<Cd[]> {
    return this.http.get<Cd[]>(this.apiUrl);
  }

  getCdById(id: number): Observable<Cd> {
    return this.http.get<Cd>(`${this.apiUrl}/${id}`);
  }

  crearCd(cd: CrearCdRequest): Observable<Cd> {
    return this.http.post<Cd>(this.apiUrl, cd);
  }

  eliminarCd(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}