import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Article } from './article';

@Component({
  selector: 'app-day27',
  templateUrl: './day27.component.html',
  styleUrls: ['./day27.component.scss']
})
export class Day27Component implements OnInit {
  articles:observable<Article[]>| undefined;
  ngOnInit():void{
    this.articles=of<Article[]>([
      {title:'title 1',body:'body 1',slug:'slug 1'},
      {title:'title 2',body:'body 2',slug:'slug 2'},
    ])
  }
  constructor() { }

}
