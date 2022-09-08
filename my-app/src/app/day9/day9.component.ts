import { Component, EventEmitter, Input, OnInit, Output, VERSION } from '@angular/core';

@Component({
  selector: 'app-day9',
  templateUrl: './day9.component.html',
  styleUrls: ['./day9.component.scss']
})
export class Day9Component {
  name = 'Angular '+VERSION.major;
  @Input() checked: boolean |any;
  @Output() checkedChange = new EventEmitter<boolean>();

}
