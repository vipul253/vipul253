import { TestBed } from '@angular/core/testing';

import { Firstservice } from './firstservice';

describe('Firstservice', () => {
  let service: Firstservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Firstservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
