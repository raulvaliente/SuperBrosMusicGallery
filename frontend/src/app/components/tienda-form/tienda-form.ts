import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { TiendaService } from '../../services/tienda';

@Component({
  selector: 'app-tienda-form',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './tienda-form.html',
  styleUrl: './tienda-form.css'
})
export class TiendaFormComponent {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private tiendaService: TiendaService,
    private router: Router
  ) {
    this.form = this.fb.group({
      nombre:    ['', Validators.required],
      direccion: ['', Validators.required],
      telefono:  ['', Validators.required]
    });
  }

  guardar(): void {
    if (this.form.invalid) return;
    this.tiendaService.crearTienda(this.form.value).subscribe(() => {
      this.router.navigate(['/tiendas']);
    });
  }
}
