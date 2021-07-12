import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClientService, Employee, Employee2, Names } from '../service/httpclient.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user: Employee2 = new Employee2("", "", "", "", "");
  name2: Names;

  constructor(
    private httpClientService: HttpClientService, private loginService: AuthenticationService
  ) { }


  ngOnInit() {
    this.httpClientService.getNames().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response) {
    this.name2 = response;
  }

  createjob(): void {
    this.httpClientService.createEmployee(this.user)
      .subscribe(data => {
        alert("job Added successfully.");
      });

  };

  setChangeHandler(event: any) {
    this.user.cat = event.target.value;
  }
}