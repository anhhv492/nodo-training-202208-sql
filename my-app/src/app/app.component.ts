import {Component, ElementRef, Input, OnInit, QueryList, VERSION, ViewChild} from "@angular/core";
import { Day10Component } from "./day10/day10.component";

@Component({
  selector:'my-app',
  templateUrl:'./app.component.html',
  styleUrls:['./app.component.scss']
})
export class AppComponent{
  name = 'Angular: '+VERSION.major;
  // @ViewChild('toggleComp') toggleComp: Day10Component | undefined;
  @ViewChild(Day10Component,{static:true}) toggleComp!: Day10Component;
  @ViewChild('toggleButton',{static:true}) toggleBtn!: ElementRef<HTMLButtonElement> ;
  currentProgress=70;
  isChecked=true;
  questions={
    question1:true,
    question2:false
  };
  ngOnInit(){
    console.log('on init',this.toggleComp,this.toggleBtn);
  }
  ngAfterViewInit() {
    console.log(this.toggleComp);
    // apiCall.subscribe(() => {
    //   this.toggleComp?.toggle();
    // }
  }
}
