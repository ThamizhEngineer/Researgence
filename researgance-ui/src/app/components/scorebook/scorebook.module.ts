import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScorebookRoutingModule } from './scorebook-routing.module';
import {ScorebookService} from './scorebook.service';
import { ScorebookComponent } from './scorebook/scorebook.component';

@NgModule({
  declarations: [ScorebookComponent],
  imports: [
    ScorebookRoutingModule,
    CommonModule
  ],
  providers:[ScorebookService],

})
export class ScorebookModule { }
