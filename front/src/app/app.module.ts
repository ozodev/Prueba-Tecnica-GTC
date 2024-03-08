import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DocentesComponent } from './docentes/docentes.component';
import { EstudiantesComponent } from './estudiantes/estudiantes.component';
import { AsignaturasComponent } from './asignaturas/asignaturas.component';
import { TiposDocumentoComponent } from './tipos-documento/tipos-documento.component';
import { DaneComponent } from './dane/dane.component';
import { GradosComponent } from './grados/grados.component';
import { TiposDaneComponent } from './tipos-dane/tipos-dane.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    DocentesComponent,
    EstudiantesComponent,
    AsignaturasComponent,
    TiposDocumentoComponent,
    DaneComponent,
    GradosComponent,
    TiposDaneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
