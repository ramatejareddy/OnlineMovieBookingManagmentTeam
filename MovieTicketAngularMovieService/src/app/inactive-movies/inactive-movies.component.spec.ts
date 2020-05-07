import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InactiveMoviesComponent } from './inactive-movies.component';

describe('InactiveMoviesComponent', () => {
  let component: InactiveMoviesComponent;
  let fixture: ComponentFixture<InactiveMoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InactiveMoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InactiveMoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
