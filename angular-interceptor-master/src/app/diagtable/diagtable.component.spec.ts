import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagtableComponent } from './diagtable.component';

describe('DiagtableComponent', () => {
  let component: DiagtableComponent;
  let fixture: ComponentFixture<DiagtableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiagtableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiagtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
