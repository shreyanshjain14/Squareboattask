import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Candidate, Employee, HttpClientService } from '../service/httpclient.service';
import * as html2pdf from 'html2pdf.js'
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-perioform',
  templateUrl: './perioform.component.html',
  styleUrls: ['./perioform.component.css']
})
export class PerioformComponent implements OnInit {

  id: Number;
  name: string;
  diag: Candidate = new Candidate("", "", 0);
  constructor(public activatedRoute: ActivatedRoute, private httpClientService: HttpClientService, private router: Router, private loginService: AuthenticationService) { }


  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
      // this.name = params['name'];
    });
  }



  adduser(): void {
    // this.diag.job_ID= this.id;

    this.httpClientService.savediag(this.diag)
      .subscribe(data => {
        alert("applied successfully.");
      });
    this.router.navigate(['']);
  }

}
