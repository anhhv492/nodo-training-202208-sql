import { Component, HostBinding, Input, OnInit } from '@angular/core';

type FlexDirection = 'row' | 'column' | 'row-reverse' | 'column-reverse';

@Component({
  selector: 'app-flex-container',
  templateUrl: './flex-container.component.html',
  styleUrls: ['./flex-container.component.scss']
})
export class FlexContainerComponent implements OnInit {
  @Input() flexDirection: FlexDirection = 'row';

  @HostBinding('style.display') get display() {
    return 'flex';
  }

  @HostBinding('style.flex-direction') get direction() {
    return this.flexDirection;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
