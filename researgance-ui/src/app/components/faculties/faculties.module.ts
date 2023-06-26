import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ChartistModule } from 'ng-chartist';
import { NgChartsModule } from 'ng2-charts';
import { CountToModule } from 'angular-count-to';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { Ng2GoogleChartsModule } from 'ng2-google-charts';
import { SharedModule } from "../../shared/shared.module";
import { FacultiesService } from './faculties.service'
import { FacultiesDetailComponent } from './faculties-detail/faculties-detail.components';
import { PagesRoutes } from './faculties.routing';
import { RouterModule } from '@angular/router';
import { FacultiesListComponent } from './faculties-list/faculties-list.components';
import { SearchFilterPipe } from './search-filter.pipe';
import { HttpClientModule } from '@angular/common/http';
import {ShareButtonsModule} from 'ngx-sharebuttons/buttons';
import {ShareIconsModule} from 'ngx-sharebuttons/icons';


@NgModule({
  declarations: [
    FacultiesDetailComponent,FacultiesListComponent, SearchFilterPipe],
  providers:[FacultiesService],
  imports: [
    CommonModule,
    FormsModule,
    CarouselModule,
    NgbModule,
    ChartistModule,
    NgChartsModule,
    CountToModule,
    RouterModule.forChild(PagesRoutes),
    NgxChartsModule,
    Ng2GoogleChartsModule,
    SharedModule,
    HttpClientModule,
    ShareButtonsModule.withConfig({
      debug:true,
    }),

    ShareIconsModule
    

  ],
  
})
export class FacultiesModule { }
