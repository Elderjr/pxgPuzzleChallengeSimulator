import {Piece} from './Piece';

export class Puzzle {
  private pieces: Piece[][];

  constructor(pieces: Piece[][]) {
    this.pieces = pieces;
  }

  public getLines(): number {
    return this.pieces.length;
  }

  public getColumns(): number {
    return this.pieces[0].length;
  }

  public getPieces(): Piece[][] {
    return this.pieces;
  }

  public getPiece(i: number, j: number): Piece {
    return this.pieces[i][j];
  }

  public move(i: number, j: number, k: number, l: number): void {
    const tmp = this.pieces[i][j];
    this.pieces[i][j] = this.pieces[k][l];
    this.pieces[k][l] = tmp;
  }

  private randomNumber(min: number, max: number): number {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  public shuffle(): void {
    let m: number, n: number;
    let tmp: Piece;
    for (let i = this.getLines() - 1; i > 0; i--) {
      for (let j = this.getColumns() - 1; j > 0; j--) {
        m = this.randomNumber(0, i);
        n = this.randomNumber(0, j);
        tmp = this.pieces[i][j];
        this.pieces[i][j] = this.pieces[m][n];
        this.pieces[m][n] = tmp;
      }
    }

  }
  public isCorrect(): boolean {
    let index = 0;
    for (let i = 0; i < this.getLines(); i++) {
      for (let j = 0; j < this.getColumns(); j++) {
        if (this.pieces[i][j].getIndex() !== index) {
          return false;
        }
        index++;
      }
    }
    return true;
  }
}
