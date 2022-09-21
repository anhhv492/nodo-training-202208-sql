import { Component, Input, TemplateRef } from "@angular/core";

@Component({
  selector: 'tabs',
  templateUrl:'../day14/tab.component.html'
})
export class TabsComponent{
  @Input() navs : string[]| undefined;
  @Input() linkTemplate :TemplateRef<any>| undefined;
}
