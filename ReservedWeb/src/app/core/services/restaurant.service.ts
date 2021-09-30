import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenericCrudService } from './generic-crud';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService extends GenericCrudService<any, string> {

  constructor(http: HttpClient) {
    super(http, 'http://localhost:9191/restaurant')
  }
}
