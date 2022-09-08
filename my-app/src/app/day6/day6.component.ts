import {Component, OnInit, VERSION} from '@angular/core';

@Component({
  selector: 'app-day6',
  templateUrl: './day6.component.html',
  styleUrls: ['./day6.component.scss']
})
export class Day6Component implements OnInit {
  name = 'Angular '+VERSION.major;

  isDanger = false;
  isWarning=false;
  constructor() { }

  ngOnInit(): void {
  }

}
