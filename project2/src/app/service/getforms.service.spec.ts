import { TestBed } from '@angular/core/testing';

import { GetformsService } from './getforms.service';

describe('GetformsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetformsService = TestBed.get(GetformsService);
    expect(service).toBeTruthy();
  });
});
