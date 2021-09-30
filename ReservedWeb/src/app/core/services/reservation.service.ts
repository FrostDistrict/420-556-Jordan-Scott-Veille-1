import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { GenericCrudService } from './generic-crud';

const API_URL = environment.API_URL + '/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService extends GenericCrudService<any, string> {

  constructor(http: HttpClient) {
    super(http, API_URL);
  }
}
