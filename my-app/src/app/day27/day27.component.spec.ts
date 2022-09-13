import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Day27Component } from './day27.component';

describe('Day27Component', () => {
  let component: Day27Component;
  let fixture: ComponentFixture<Day27Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Day27Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Day27Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
