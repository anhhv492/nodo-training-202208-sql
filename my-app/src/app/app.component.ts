import {Component, Input, OnInit, VERSION} from "@angular/core";

@Component({
  selector:'my-app',
  templateUrl:'./app.component.html',
  styleUrls:['./app.component.scss']
})
export class AppComponent{
  currentProgress=70;
  isChecked=true;
}
