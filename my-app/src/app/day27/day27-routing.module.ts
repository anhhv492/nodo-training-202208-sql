import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Day27Component } from './day27.component';

const routes: Routes = [{ path: '', component: Day27Component }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Day27RoutingModule { }
