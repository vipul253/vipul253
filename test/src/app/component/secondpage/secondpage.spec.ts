import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Secondpage } from './secondpage';

describe('Secondpage', () => {
  let component: Secondpage;
  let fixture: ComponentFixture<Secondpage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Secondpage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Secondpage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
