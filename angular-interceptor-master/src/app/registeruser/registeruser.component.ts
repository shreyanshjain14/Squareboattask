import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Login, register } from '../service/httpclient.service';

@Component({
  selector: 'app-registeruser',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css']
})
export class RegisteruserComponent implements OnInit {

  users: register = new register("", "", "");
  constructor(private httpClientService: HttpClientService, private router: Router) { }

  ngOnInit() {
  }

  createUser(): void {
    this.httpClientService.createUser(this.users)
      .subscribe(data => {
        alert(" Registered successfully.");
      });
    this.router.navigate(["home"]);
  };
  setChangeHandler(event: any) {
    this.users.role = event.target.value;
  }
}
