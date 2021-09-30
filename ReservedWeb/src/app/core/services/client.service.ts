import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Client } from '../model/client';
import { GenericCrudService } from './generic-crud';

const API_URL = environment.API_URL + '/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService extends GenericCrudService<Client,  string> {

  constructor(http: HttpClient) {
    super(http, API_URL);
  }
}
