import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/core/services/reservation.service';
import { RestaurantService } from 'src/app/core/services/restaurant.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  client: any;
  reservations: any[];

  constructor(
    private reservationService: ReservationService,
    private restaurantService: RestaurantService
  ) { }

  ngOnInit(): void {
    this.getClient();
    this.fetchReservations();
  }

  getClient(): void{
    this.client = JSON.parse(sessionStorage.getItem("client")!);
  }

  getRestaurant(id: string): any {
    this.restaurantService.getById(id).subscribe(
      (data) => {
        if(data){
          return data.name;
        }
      }
    )
  }

  fetchReservations() :void{
    this.reservationService.getAllByClientId(this.client.id).subscribe(
      (data) => {
        this.reservations = data;
      }
    )
  }
}
