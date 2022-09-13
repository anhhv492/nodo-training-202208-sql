import { Component, EventEmitter, Input, OnInit, Output, VERSION } from '@angular/core';

@Component({
  selector: 'app-day13',
  templateUrl: './day13.component.html',
  styleUrls: ['./day13.component.scss']
})
export class Day13Component implements OnInit {
  name = 'Angular '+VERSION.major;
  // @Input() header:string| undefined;
  // @Input() question:string| undefined;
  // @Input() content:string| undefined;
  @Input() canSkip:boolean=true;
  @Input() checked: boolean |any;
  @Output() checkedChange = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit(): void {
  }

}
