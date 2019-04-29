import { TestBed } from '@angular/core/testing';

import { PuzzleLoaderService } from './puzzle-loader.service';

describe('PuzzleLoaderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PuzzleLoaderService = TestBed.get(PuzzleLoaderService);
    expect(service).toBeTruthy();
  });
});
