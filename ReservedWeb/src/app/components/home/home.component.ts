import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/core/model/client';
import { ClientService } from 'src/app/core/services/client.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private router: Router,
    private clientService: ClientService
  ) { }

  ngOnInit(): void {
  }

  navigateToDashboard(type: string): void {
    if(type == 'client'){
      let client;
      this.clientService.getById("default").subscribe(
        (data) => {
          if (data != null) {
            client = data;
            window.sessionStorage.setItem("client", JSON.stringify(client));
            this.router.navigateByUrl('/clients');
            
          }
        }
      )
    }
    if(type == 'restaurant'){

    }
  }
}
