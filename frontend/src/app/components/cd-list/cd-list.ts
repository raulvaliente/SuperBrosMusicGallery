import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { CdService } from '../../services/cd';
import { Cd } from '../../models/cd.model';

@Component({
  selector: 'app-cd-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './cd-list.html',
  styleUrl: './cd-list.css'
})
export class CdListComponent implements OnInit {
  cds = signal<Cd[]>([]);

  constructor(private cdService: CdService) {}

  ngOnInit(): void {
    this.cdService.getCds().subscribe(data => {
      this.cds.set(data);
    });
  }

  eliminar(id: number): void {
    this.cdService.eliminarCd(id).subscribe(() => {
      this.cds.update(c => c.filter(cd => cd.id !== id));
    });
  }
}