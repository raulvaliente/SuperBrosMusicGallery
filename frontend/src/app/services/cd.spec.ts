import { TestBed } from '@angular/core/testing';

import { Cd } from './cd';

describe('Cd', () => {
  let service: Cd;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cd);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
