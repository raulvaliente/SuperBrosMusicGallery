import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, ActivatedRoute } from '@angular/router';
import { TiendaService } from '../../services/tienda';
import { Tienda } from '../../models/tienda.model';
import { Cd } from '../../models/cd.model';

@Component({
  selector: 'app-tienda-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './tienda-detail.component.html',
  styleUrl: './tienda-detail.component.css'
})
export class TiendaDetailComponent implements OnInit {
  tienda = signal<Tienda | null>(null);
  cds = signal<Cd[]>([]);

  constructor(
    private route: ActivatedRoute,
    private tiendaService: TiendaService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.tiendaService.getTiendaById(id).subscribe((data: Tienda | null) => {
      this.tienda.set(data);
    });
    this.tiendaService.getCdsByTienda(id).subscribe((data: Cd[]) => {
      this.cds.set(data);
    });
  }
}