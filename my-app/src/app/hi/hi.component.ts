import {Component, Input, OnInit, VERSION} from '@angular/core';

@Component({
  selector: 'app-hi',
  templateUrl: './hi.component.html',
  styleUrls: ['./hi.component.scss']
})
export class HiComponent {
  title='demo';
  name='Angular '+VERSION.major;
  user={
    name: 'Vietanh',
    age:20
  };

  handler(event: any) {
    console.log('click',event);
  }
  ngOnInit(){
    console.log('hello init');
  }
  ngOnDestroy(){
    console.log('hello destroy');
  }
}
