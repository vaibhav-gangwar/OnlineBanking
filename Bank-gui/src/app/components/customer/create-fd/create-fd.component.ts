import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CreateFD } from 'src/app/model/createfd.model';
import { FundTransfer } from 'src/app/model/fundtransfer.model';
import { AuthService } from '../../../auth.service';
import { Customer } from '../../../model/customer.model';

@Component({
  selector: 'app-create-fd',
  templateUrl: './create-fd.component.html',
  styleUrls: ['./create-fd.component.css']
})
export class CreateFdComponent implements OnInit {

  createfd: CreateFD =
    {
      toEmailId: "",
      amount: "",
    };

  constructor() { }

  ngOnInit(): void {
    this.createfd.toEmailId=localStorage.getItem("email");
  }

  onSubmit(form: NgForm) {

    console.log(this.createfd);
    alert("FD Created");
    // this.authservice.createBankAccount(this.customer).subscribe((res) => {
    //   if (res == "Customer Not Found") {
    //     console.log(res);
    //   }
    //   else if (res != null && res.customerid == 0) {
    //     this._router.navigate(['/customerlogin']);

    //   } else {
    //     console.log(res.error());
    //   }
    // },
    //   () => console.log("network error")
    // )
  }
}
