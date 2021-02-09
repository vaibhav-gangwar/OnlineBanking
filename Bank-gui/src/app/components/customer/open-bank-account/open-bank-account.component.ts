import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Gender } from 'src/app/model/gender.model';
import { AuthService } from '../../../auth.service';
import { Customer } from '../../../model/customer.model';

@Component({
  selector: 'app-open-bank-account',
  templateUrl: './open-bank-account.component.html',
  styleUrls: ['./open-bank-account.component.css']
})
export class OpenBankAccountComponent implements OnInit {

  dob: any;
  customer: Customer =
    {
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

  constructor(private authservice: AuthService, private _router: Router) {}

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {

    console.log(this.customer);

    // adjust 0 before single digit date
    let date = ("0" + this.customer.dateofbirth["day"]).slice(-2);

    // current month
    let month = ("0" + (this.customer.dateofbirth["month"] + 1)).slice(-2);

    // current year
    let year = this.customer.dateofbirth["year"];

    // prints date in DD-MM-YYYY format
    this.customer.dateofbirth = (year + "-" + month + "-" + date);
    console.log(this.customer.dateofbirth);

    this.authservice.createBankAccount(this.customer).subscribe((res) => {
      if (res == "Customer Not Found") {
        console.log(res);
      }
      else if (res != null && res.customerid == 0) {
        this._router.navigate(['/customerlogin']);

      } else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )
  }
}
