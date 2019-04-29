import { Component, OnInit} from '@angular/core';
import {PuzzleLoaderService} from './puzzle/puzzle-loader.service';
import {Puzzle} from './puzzle/Puzzle';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  puzzle: Puzzle;
  loaded: boolean;
  selectedI: number;
  selectedJ: number;
  done: boolean;
  showOriginalImage: boolean;

  constructor(private puzzleService: PuzzleLoaderService) {
    this.loaded = false;
    this.done = false;
    this.showOriginalImage = false;
    this.selectedI = -1;
    this.selectedJ = -1;


  }

  public select(i: number, j: number) {
    if(this.selectedI === -1) {
      this.selectedI = i;
      this.selectedJ = j;
    } else {
      this.puzzle.move(this.selectedI, this.selectedJ, i, j);
      this.selectedI = -1;
      this.selectedJ = -1;
      if (this.puzzle.isCorrect()) {
        this.done = true;
      } else {
        this.done = false;
      }
    }
  }

  public isSelected(i: number, j: number) {
    return i === this.selectedI && j === this.selectedJ;
  }

  public showOrHideOriginalImage() {
    this.showOriginalImage = !this.showOriginalImage;
  }

  public shuffle() {
    this.puzzle.shuffle();
    this.done = false;
  }

  ngOnInit() {
    this.puzzleService.loadPuzzle().then( (puzzle: Puzzle) => {
      this.puzzle = puzzle;
      this.loaded = true;
    });
  }

}
