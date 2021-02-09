import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Customer } from '../model/customer.model';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  customer: Customer = {
    // customerid: "",
    firstname: "",
    middlename: "",
    lastname: "",
    dateofbirth: "",
    gender: "",
    email: "",
    password: "",
    contact: "",
    pan: "",
    nationality: "",
    salary: 0,
    street: "",
    city: "",
    state: "",
    pin: ""
  };
  constructor(private authservice: AuthService, private _router: Router) { }

  ngOnInit(): void {
  }
  
  onSubmit(form: NgForm) {
    // console.log("Login Success");
    // this.authservice.signup(this.customer).subscribe((res) => {
    //   console.log(res);
    // }
  }
}
