import { NgModule } from '@angular/core';

import { ClientsRoutingModule } from './clients-routing.module';
import { ClientsComponent } from './clients.component';
import { RestaurantPageComponent } from './components/restaurant-page/restaurant-page.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    ClientsComponent,
    RestaurantPageComponent
  ],
  imports: [
    SharedModule,
    ClientsRoutingModule
  ]
})
export class ClientsModule { }
