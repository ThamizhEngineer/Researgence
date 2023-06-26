import { Routes } from '@angular/router';
import { FacultiesComponent } from './faculties/faculties.components'
import { ProfileComponent } from './profile/profile.components'
export const PagesRoutes: Routes = [
    { path: 'profile/:id', component: ProfileComponent},
    { path: 'list', component: FacultiesComponent },
    { path: '**', redirectTo: 'list' }
];

