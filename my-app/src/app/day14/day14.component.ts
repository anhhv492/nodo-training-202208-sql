import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-day14',
  templateUrl: './day14.component.html',
  styleUrls: ['./day14.component.scss']
})
export class Day14Component implements OnInit {
  counter=1;
  navs=['Active','Link 1','Link 2','Link 3'];

  constructor() { }

  ngOnInit(): void {
  }

}
