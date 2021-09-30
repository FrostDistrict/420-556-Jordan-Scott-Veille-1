import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../model/client';
import { GenericCrudService } from './generic-crud';

@Injectable({
  providedIn: 'root'
})
export class ClientService extends GenericCrudService<Client,  string> {

  constructor(http: HttpClient) {
    super(http, 'http://localhost:9191/client')
  }
}
