import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { RestaurantService } from 'src/app/core/services/restaurant.service';

@Component({
  selector: 'app-restaurant-page',
  templateUrl: './restaurant-page.component.html',
  styleUrls: ['./restaurant-page.component.css']
})
export class RestaurantPageComponent implements OnInit {
  restaurant: any | undefined;
  client: any | undefined;

  reservationForm= this.formBuilder.group({
    time: ['', Validators.required],
    amount: ['', Validators.required],
    restaurantId: ['', Validators.required],
    clientId: ['', Validators.required]
  });

  constructor(
    private restaurantService: RestaurantService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.fetchRestaurant();
    this.getClient();
  }

  getClient(): void{
    this.client = JSON.parse(sessionStorage.getItem("client")!);
  }

  fetchRestaurant(): void{
    this.restaurantService.getById('default').subscribe(
      (data) => {
        if(data) {
          this.restaurant = data;
        }
      }
    )
  }

  submit(): void{
    
  }
}
