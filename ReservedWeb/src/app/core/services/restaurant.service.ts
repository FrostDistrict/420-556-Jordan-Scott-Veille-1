import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { GenericCrudService } from './generic-crud';

const API_URL = environment.API_URL + '/restaurant'

@Injectable({
  providedIn: 'root'
})
export class RestaurantService extends GenericCrudService<any, string> {

  constructor(http: HttpClient) {
    super(http, API_URL)
  }

  getAvailableTimeSlots(id: string, date: string): Observable<any[]> {
    return this.http.get<any>(API_URL+ "/getslots?id="+ id + "&date=" + date);
  }
}
