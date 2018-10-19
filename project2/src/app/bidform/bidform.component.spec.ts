import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BidformComponent } from './bidform.component';

describe('BidformComponent', () => {
  let component: BidformComponent;
  let fixture: ComponentFixture<BidformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BidformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BidformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
