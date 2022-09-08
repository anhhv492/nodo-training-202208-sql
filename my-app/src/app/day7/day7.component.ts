import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-day7',
  templateUrl:'./day7.component.html',
  styleUrls:['./day7.component.scss']
})
export class Day7Component implements OnInit,OnChanges{
  @Input() set progress(val:number){
    if(typeof val!="number"){
      const progress =Number(val);
      if(Number.isNaN(progress)){
        this._progress=0;
      }else if(val<100){
        this._progress=val;
      }
    }
    this._progress=val;
  };
  private _progress=50;
  get progress() {
    return this._progress;
  }
  @Input() backgroundColor = '#cccc';
  @Input() progressColor = 'tomato';
  constructor() {
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log('changes',{
      progress:this.progress,
      backgroundColor:this.backgroundColor,
      progressColor:this.progressColor});
  }

  ngOnInit(): void {
  }

}
