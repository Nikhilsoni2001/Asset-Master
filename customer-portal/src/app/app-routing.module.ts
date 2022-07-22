import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalculateNetworthComponent } from './pages/calculate-networth/calculate-networth.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SellAssetsComponent } from './pages/sell-assets/sell-assets.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
  {
    path: 'calculate-networth',
    component: CalculateNetworthComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
  {
    path: 'sell-assets',
    component: SellAssetsComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
