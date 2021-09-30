import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientsComponent } from './clients.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RestaurantPageComponent } from './components/restaurant-page/restaurant-page.component';

const routes: Routes = [
  { path: 'restaurant', component: RestaurantPageComponent},
  { path: 'dashboard', component: DashboardComponent},

  { path: '', redirectTo: '/clients/restaurant' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientsRoutingModule { }
