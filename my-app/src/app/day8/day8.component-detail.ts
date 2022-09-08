import { Component, EventEmitter, Input, Output } from '@angular/core';
import {Author} from '../authors.model';
@Component({
  selector: 'app-day8-detail',
  templateUrl:'../day8/detail.html'
})
export class Day8ComponentDetail {
  @Input() author: Author|any;
  @Output() select = new EventEmitter<Author>();
  @Output() deleted = new EventEmitter<number>();
}
