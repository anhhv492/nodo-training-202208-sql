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
    Day11Component
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
