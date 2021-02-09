import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from "../../model/login.model";
import { Router } from '@angular/router';
import { AuthService } from "../../auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  customer: [];

  user: User = {
    email: "",
    password: "",
    role: "customer"
  }

  constructor(private authservice: AuthService, private _router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    this.authservice.loginCustomer(this.user).subscribe((res) => {
      if (res == "Customer Not Found") {
        console.log(res);
      }
      else if (res != null && res.customerid > 0) {
alert("Login Successful");
        this.customer = res;
        localStorage.setItem('userId', res.customerid);
        localStorage.setItem('userName', res.firstname + " " + res.middlename + " " + res.lastname);
        localStorage.setItem('email', res.email);
        localStorage.setItem('role', this.user.role);

        this._router.navigate(['/customerdashboard']);

      } else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )
  }

  reloadCurrentRoute() {
    let currentUrl = this._router.url;
    this._router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this._router.navigate([currentUrl]);
    });
  }
}

