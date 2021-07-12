import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Candidate, HttpClientService } from '../service/httpclient.service';

@Component({
  selector: 'app-diagtable',
  templateUrl: './diagtable.component.html',
  styleUrls: ['./diagtable.component.css']
})
export class DiagtableComponent implements OnInit {

  cand: Candidate;
  constructor(private httpClientService: HttpClientService, private loginService: AuthenticationService) { }

  ngOnInit() {
    this.httpClientService.getdiag().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response) {
    this.cand = response;
  }
}
