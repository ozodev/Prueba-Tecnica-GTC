import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiposDaneComponent } from './tipos-dane.component';

describe('TiposDaneComponent', () => {
  let component: TiposDaneComponent;
  let fixture: ComponentFixture<TiposDaneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TiposDaneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TiposDaneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
