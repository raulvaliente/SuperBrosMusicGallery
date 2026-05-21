import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: '/tiendas', pathMatch: 'full' },

  {
    path: 'tiendas',
    loadComponent: () =>
      import('./components/tienda-list/tienda-list.component')
        .then(m => m.TiendaListComponent)
  },
  {
    path: 'tiendas/nueva',
    loadComponent: () =>
      import('./components/tienda-form/tienda-form.component')
        .then(m => m.TiendaFormComponent)
  },
  {
    path: 'tiendas/:id',
    loadComponent: () =>
      import('./components/tienda-detail/tienda-detail.component')
        .then(m => m.TiendaDetailComponent)
  },
  {
    path: 'cds',
    loadComponent: () =>
      import('./components/cd-list/cd-list.component')
        .then(m => m.CdListComponent)
  },
  {
    path: 'cds/nuevo',
    loadComponent: () =>
      import('./components/cd-form/cd-form.component')
        .then(m => m.CdFormComponent)
  },

  { path: '**', redirectTo: '/tiendas' }
];