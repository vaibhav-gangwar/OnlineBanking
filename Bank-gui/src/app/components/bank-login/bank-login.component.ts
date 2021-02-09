import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from "../../model/login.model";
import { Router } from '@angular/router';
import { AuthService } from "../../auth.service"

@Component({
  selector: 'app-bank-login',
  templateUrl: './bank-login.component.html',
  styleUrls: ['./bank-login.component.css']
})
export class BankLoginComponent implements OnInit {
  employee: [];

  user: User = {
    email: "",
    password: "",
    role: "employee"
  }

  constructor(private authservice: AuthService, private _router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    this.authservice.loginEmployee(this.user).subscribe((res) => {
      if (res == "Employee Not Found") {
        console.log(res);
      }
      else if (res != null && res.employeeid > 0) {
        console.log("Login Success");
        this.employee = res;
        localStorage.setItem('userId', res.employeeid);
        localStorage.setItem('userName', res.firstname + " " + res.middlename + " " + res.lastname);
        localStorage.setItem('email', res.email);
        localStorage.setItem('role', this.user.role);

        this._router.navigate(['/admindashboard']);
      } else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )
  }

}
