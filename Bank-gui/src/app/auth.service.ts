import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/login.model';
import { Observable } from 'rxjs';
import { Customer } from './model/customer.model';
import { FundTransfer } from './model/fundtransfer.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpclient: HttpClient) { }

  //Admin Service
  loginEmployee(user: User): Observable<any> {
    let header = new HttpHeaders()
    header.append('Content-Type', 'application/json');

    return this.httpclient.post('http://localhost:8090/employee/validate', user, { headers: header });
  }

  //Customer Service
  loginCustomer(user: User): Observable<any> {
    let header = new HttpHeaders()
    header.append('Content-Type', 'application/json');

    return this.httpclient.post('http://localhost:8090/customer/validate', user, { headers: header });
  }

  //Account Service
  getAccountById(customer: Customer): Observable<any> {
    let header = new HttpHeaders()
    header.append('Content-Type', 'application/json');

    return this.httpclient.post('http://localhost:8090/customer/save', customer, { headers: header });
  }
  
  getAllAccount(): Observable<any> {
    return this.httpclient.get('http://localhost:8090/account/getall');
  }

  createBankAccount(customer: Customer): Observable<any> {
    let header = new HttpHeaders()
    header.append('Content-Type', 'application/json');

    return this.httpclient.post('http://localhost:8090/customer/save', customer, { headers: header });
  }

  getAccountByCustomerId(): Observable<any> {
    return this.httpclient.get('http://localhost:8090/account/getByCustomerId?customerId=' + localStorage.getItem('userId'));
  }
  
  getBalByCustomerId(): Observable<any> {
    let header = new HttpHeaders()
    header.append('Content-Type', 'application/json');

    return this.httpclient.get('http://localhost:8090/account/getBalByCustomerId?customerId=' + localStorage.getItem('userId'));
  }
  
  fundtransfer(fundtransfer: FundTransfer): Observable<any> {
    let header = new HttpHeaders()
    header.append('Content-Type', 'application/json');

    return this.httpclient.post('http://localhost:8090/account/transfer', fundtransfer, { headers: header });
  }
  
  deleteCustomer(cust_id): Observable<any> {
    return this.httpclient.delete('http://localhost:8090/customer/delete?id='+cust_id);
  }
}
