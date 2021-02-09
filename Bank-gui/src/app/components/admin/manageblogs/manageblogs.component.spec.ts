import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageblogsComponent } from './manageblogs.component';

describe('ManageblogsComponent', () => {
  let component: ManageblogsComponent;
  let fixture: ComponentFixture<ManageblogsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageblogsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageblogsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
