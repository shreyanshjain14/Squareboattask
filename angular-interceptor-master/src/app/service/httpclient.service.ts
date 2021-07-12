import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Employee {
  constructor(
    public patient_ID:Number,
    public pat_Name:String,
    public pat_Symptoms:string,
    public v_date:string,
    public last_vdate:string,
    //  public doc_ID:number,
   public ename:String
  ) {}
}
export class Employee2 {
  constructor(
    public skills:String,
    public designation:string,
    public location:string,
    public ctc:string,
    public cat:string,
  ) {}
}
export class Names{
  constructor(
    public name:String,
  ){}
}

export class Candidate
{
  constructor(
    public username:String,
    public email:String,
    public job_ID:Number
  ){}
}
export class Login{
  constructor(
    public docUser:String,
    public docPass:String
  ){}
}
export class register
{
  constructor(
    public username:String,
    public password:String,
    public role:String,
  ){}
}
@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getEmployees() {
    return this.httpClient.get<Employee[]>('http://localhost:8086/');
  }

  getNames() {
    return this.httpClient.get<Names[]>('http://localhost:8086/getdoc');
  }

  public deleteEmployee(employee) {
    return this.httpClient.delete<Employee>("http://localhost:8086/pat" + "/"+ employee.patient_ID);
  }

  public createEmployee(employee2:Employee2) {
    return this.httpClient.post<Employee2>("http://localhost:8086/add", employee2);
  }
  public updateEmployees(employee){
    return this.httpClient.put("http://localhost:8086/patupdate/",employee);
  }
  public createUser(login)
  {
    return this.httpClient.post<register>("http://localhost:8086/register",login);
  }
  public getDoc(log)
  {
    return this.httpClient.post<Login>("http://localhost:8086/val",log);
  }
 
  public savediag(diag)
  {
    return this.httpClient.post<Candidate>("http://localhost:8086/diagsave",diag);
  }
  public getdiag()
  {
    return this.httpClient.get<Candidate[]>("http://localhost:8086/applieduser");
  }
  public chosen(id)
  {
    return this.httpClient.get<Candidate[]>("http://localhost:8086/chosen/"+id);
  }
}