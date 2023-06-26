import { Routes } from '@angular/router';
import { FacultiesListComponent } from './faculties-list/faculties-list.components'
import {  FacultiesDetailComponent} from './faculties-detail/faculties-detail.components'

export const PagesRoutes: Routes = [
    { path: ':id', component: FacultiesDetailComponent},
    { path: '', component: FacultiesListComponent },
    { path: '**', redirectTo: '' }
];

