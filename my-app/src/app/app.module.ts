import {Input, NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HiComponent } from './hi/hi.component';
import {FormsModule} from "@angular/forms";
import { Day5Component } from './day5/day5.component';
import { Day6Component } from './day6/day6.component';
import { Day7Component } from './day7/day7.component';
import {Day8ComponentDetail} from "./day8/day8.component-detail";
import {Day8ComponentList} from "./day8/day8.component-list";
import { Day9Component } from './day9/day9.component';
import { Day10Component } from './day10/day10.component';
import { Day11Component } from './day11/day11.component';
import { Day12Component } from './day12/day12.component';
import { FlexContainerComponent } from './flex-container/flex-container.component';
import { Day13Component } from './day13/day13.component';
import { Day14Component } from './day14/day14.component';
import { TabsComponent } from './day14/tab.component';
import { Day18Component } from './day18/day18.component';
import { Day19Component } from './day19/day19.component';
import { FormatAddressPipe } from './day18/format-address.pipe';
import { AdultPipe } from './day18/adult.pipe';

@NgModule({
  // schemas: [NO_ERRORS_SCHEMA],
  declarations: [
    AppComponent,
    HiComponent,
    Day5Component,
    Day6Component,
    Day7Component,
    Day8ComponentDetail,
    Day8ComponentList,
    Day9Component,
    Day10Component,
    Day11Component,
    Day12Component,
    FlexContainerComponent,
    Day13Component,
    Day14Component,
    TabsComponent,
    Day18Component,
    Day19Component,
    FormatAddressPipe,
    AdultPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
