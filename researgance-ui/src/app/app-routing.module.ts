import { NgModule } from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';
import { ContentLayoutComponent } from './shared/components/layout/content-layout/content-layout.component';
import { content } from "./shared/routes/content-routes";
import { AdminGuard } from './shared/guard/admin.guard';
import { LoginmainComponent } from './auth/loginmain/loginmain.component';
import { ArticlesComponent } from './components/articles/articles.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },
  {
    path: 'auth/login',
    component: LoginmainComponent
  },
  {
    path: '',
    component: ContentLayoutComponent,
    canActivate: [AdminGuard],
    children: content
  },
  { path: 'article/art/:recordId/:slNo',
   component: ArticlesComponent
   },
 {
    path: '**',
    redirectTo: 'dashboard'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    // preloadingStrategy: PreloadAllModules,
    anchorScrolling: 'enabled',
    scrollPositionRestoration: 'enabled',
    relativeLinkResolution: 'legacy'
})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
