import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CdService } from '../../services/cd';
import { TiendaService } from '../../services/tienda';
import { Tienda } from '../../models/tienda.model';

@Component({
  selector: 'app-cd-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './cd-form.html',
  styleUrl: './cd-form.css'
})
export class CdFormComponent implements OnInit {
  form: FormGroup;
  tiendas = signal<Tienda[]>([]);

  constructor(
    private fb: FormBuilder,
    private cdService: CdService,
    private tiendaService: TiendaService,
    private router: Router
  ) {
    this.form = this.fb.group({
      titulo:   ['', Validators.required],
      artista:  ['', Validators.required],
      genero:   ['', Validators.required],
      precio:   [null, [Validators.required, Validators.min(0)]],
      anio:     [null, [Validators.required, Validators.min(1900), Validators.max(2099)]],
      tiendaId: [null, Validators.required]
    });
  }

  ngOnInit(): void {
    this.tiendaService.getTiendas().subscribe((data: Tienda[]) => {
      this.tiendas.set(data);
    });
  }

  guardar(): void {
    if (this.form.invalid) return;
    this.cdService.crearCd(this.form.value).subscribe(() => {
      this.router.navigate(['/cds']);
    });
  }
}