import { ScorebookComponent } from './scorebook/scorebook.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: '',
    component: ScorebookComponent,
    data: {
      title: "",
      breadcrumb: ""
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ScorebookRoutingModule { }