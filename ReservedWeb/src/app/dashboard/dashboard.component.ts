import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from '../service/restaurant.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  restaurantList: any[] | undefined;

  constructor(
    private router: Router,
    private restaurantService: RestaurantService
  ) { }

  ngOnInit(): void {
    this.fetchAllRestaurants();
  }

  fetchAllRestaurants() {
    this.restaurantService.getAll().subscribe(
      (data) => {
        if(data != null){
          this.restaurantList = data;
        }
      }
    )
  }

}
