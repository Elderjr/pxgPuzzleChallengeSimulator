import { Injectable } from '@angular/core';
import {Piece} from './Piece';
import {Puzzle} from './Puzzle';

@Injectable({
  providedIn: 'root'
})
export class PuzzleLoaderService {

  private static readonly lines = 8;
  private static readonly columns = 13;

  constructor() { }

  public loadPuzzle() {
    return new Promise((resolve, reject) => {
      let img = new Image();
      img.src = 'assets/puzzle.jpg';
      img.onload = function() {
        const subWidth = img.width / PuzzleLoaderService.columns;
        const subHeight = img.height / PuzzleLoaderService.lines;
        const canvas = <HTMLCanvasElement> document.createElement('canvas');
        canvas.width = subWidth;
        canvas.height = subHeight;
        const ctx = canvas.getContext('2d');
        const pieces: Piece[][] = [];
        let x = 0, y = 0, index = 0;
        for (let i = 0; i < PuzzleLoaderService.lines; i++ ){
          pieces[i] = []
          for (let j = 0; j < PuzzleLoaderService.columns; j++) {
            ctx.drawImage(img, x, y, subWidth, subHeight, 0, 0, subWidth, subHeight);
            pieces[i][j] = new Piece(index,  canvas.toDataURL());
            index++;
            x += subWidth;
          }
          x = 0;
          y += subHeight;
        }
        resolve(new Puzzle(pieces));
      };
      img.onerror = reject;
    });
  }
}
