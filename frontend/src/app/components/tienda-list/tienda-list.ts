import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { TiendaService } from '../../services/tienda';
import { Tienda } from '../../models/tienda.model';

@Component({
  selector: 'app-tienda-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './tienda-list.component.html',
  styleUrl: './tienda-list.component.css'
})
export class TiendaListComponent implements OnInit {
  tiendas = signal<Tienda[]>([]);

  constructor(private tiendaService: TiendaService) {}

  ngOnInit(): void {
    this.tiendaService.getTiendas().subscribe(data => {
      this.tiendas.set(data);
    });
  }

  eliminar(id: number): void {
    this.tiendaService.eliminarTienda(id).subscribe(() => {
      this.tiendas.update(t => t.filter(tienda => tienda.id !== id));
    });
  }
}