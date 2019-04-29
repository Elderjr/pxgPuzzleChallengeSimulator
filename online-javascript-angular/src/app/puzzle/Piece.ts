export class Piece {
  private index: number;
  private dataImg: string;

  constructor(index: number, dataImg: string) {
    this.index = index;
    this.dataImg = dataImg;
  }

  public getIndex(): number {
    return this.index;
  }

  public getDataImg(): string {
    return this.dataImg;
  }
}
