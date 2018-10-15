import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PformComponent } from './pform.component';

describe('PformComponent', () => {
  let component: PformComponent;
  let fixture: ComponentFixture<PformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
