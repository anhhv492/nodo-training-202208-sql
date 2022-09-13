import { Component, ElementRef, EventEmitter, Input, OnInit, Output, VERSION, ViewChild, ViewContainerRef } from '@angular/core';

@Component({
  selector: 'app-day10',
  templateUrl: './day10.component.html',
  styleUrls: ['./day10.component.scss']
})
export class Day10Component implements OnInit {
  @ViewChild('nameInput',{static:true}) nameInput!:ElementRef<HTMLInputElement> ;
  name = 'Angular '+VERSION.major;
  @Input() checked: boolean |any;
  @Output() checkedChange = new EventEmitter<boolean>();

  toggle(){
    this.checkedChange.emit(!this.checked);
  }
  constructor() { }

  ngOnInit(): void {
    console.log(this.nameInput);
    setTimeout(()=>{
      this.nameInput.nativeElement.focus();
    },2500);
  }

}
