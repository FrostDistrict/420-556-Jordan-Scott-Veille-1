import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ReservationService } from 'src/app/core/services/reservation.service';
import { RestaurantService } from 'src/app/core/services/restaurant.service';

@Component({
  selector: 'app-restaurant-page',
  templateUrl: './restaurant-page.component.html',
  styleUrls: ['./restaurant-page.component.css']
})
export class RestaurantPageComponent implements OnInit {
  restaurant: any | undefined;
  client: any | undefined;
  selectedDate: any;
  timeSlots: any[];

  reservationForm= this.formBuilder.group({
    date: [new Date(), Validators.required],
    time: ['', Validators.required],
    amount: ['', Validators.required],
    restaurantId: ['', Validators.required],
    clientId: ['', Validators.required]
  });

  constructor(
    private restaurantService: RestaurantService,
    private formBuilder: FormBuilder,
    private reservationService: ReservationService
  ) { }

  ngOnInit(): void {
    this.fetchRestaurant();
    this.getClient();
  }

  getClient(): void{
    this.client = JSON.parse(sessionStorage.getItem("client")!);
    this.reservationForm.controls['clientId'].setValue(this.client.id);
  }

  setTime(slot: any): void{
    if(slot.available){
      this.reservationForm.controls['time'].setValue(slot.time);
    }
  }

  fetchAvailabilities() {
    this.restaurantService.getAvailableTimeSlots(this.restaurant.id, this.reservationForm.get("date")?.value).subscribe(
      (data) => {
        if(data){
          this.timeSlots = data;
        }
      }
    );
  }

  fetchRestaurant(): void{
    this.restaurantService.getById('default').subscribe(
      (data) => {
        if(data) {
          this.restaurant = data;
          this.reservationForm.controls['restaurantId'].setValue(this.restaurant.id);
        }
      }
    )
  }

  submit(): void{
    console.log("submiting")
    if(this.reservationForm.valid){
      console.log(this.reservationForm.value)
      this.reservationService.save(this.reservationForm.value).subscribe(
        (data) => {
          console.log(data);
        }
      )
    }
  }
}
