import { NgModule, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Day27RoutingModule } from './day27-routing.module';
import { Day27Component } from './day27.component';
import { Article } from './article';


@NgModule({
  declarations: [
    Day27Component
  ],
  imports: [
    CommonModule,
    Day27RoutingModule
  ]
})
export class Day27Module{

}
