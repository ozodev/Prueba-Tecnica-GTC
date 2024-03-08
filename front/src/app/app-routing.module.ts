import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DocentesComponent } from './docentes/docentes.component';
import { EstudiantesComponent } from './estudiantes/estudiantes.component';
import { AsignaturasComponent } from './asignaturas/asignaturas.component';
import { TiposDocumentoComponent } from './tipos-documento/tipos-documento.component';
import { DaneComponent } from './dane/dane.component';
import { GradosComponent } from './grados/grados.component';
import { TiposDaneComponent } from './tipos-dane/tipos-dane.component';

const routes: Routes = [
  { path: 'docentes', component: DocentesComponent },
  { path: 'estudiantes', component: EstudiantesComponent },
  { path: 'asignaturas', component: AsignaturasComponent },
  { path: 'tipos-documento', component: TiposDocumentoComponent },
  { path: 'dane', component: DaneComponent },
  { path: 'grados', component: GradosComponent },
  { path: 'tipos-dane', component: TiposDaneComponent },
  { path: '', redirectTo: '/docentes', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
