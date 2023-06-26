import { Routes } from '@angular/router';

export const content: Routes = [
  {
    path: 'dashboard',
    loadChildren: () => import('../../components/dashboard/dashboard.module').then(m => m.DashboardModule),
    data: {
      breadcrumb: "Dashboard"
    }
  },
  {
    path: 'faculties',
    loadChildren: () => import('../../components/faculties/faculties.module').then(m => m.FacultiesModule),
    data: {
      breadcrumb: "My Profile"
    }
  },
  {
    path: 'scorebook',
    loadChildren: () => import('../../components/scorebook/scorebook.module').then(m => m.ScorebookModule),
    data: {
      breadcrumb: "Score Book"
    }
  },
  {
    path: 'outcome',
    loadChildren: () => import('../../components/researchoutcomes/researchoutcome.module').then(m =>m.ResearchoutcomeModule),
    data: {
      breadcrumb: "My Research Outcomes"
    }
  }

];