import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiposDocumentoComponent } from './tipos-documento.component';

describe('TiposDocumentoComponent', () => {
  let component: TiposDocumentoComponent;
  let fixture: ComponentFixture<TiposDocumentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TiposDocumentoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TiposDocumentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
