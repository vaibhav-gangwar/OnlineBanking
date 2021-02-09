import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ViewAccount } from 'src/app/model/viewaccount.model';
import { AuthService } from '../../../auth.service';
import { Customer } from '../../../model/customer.model';

@Component({
  selector: 'app-view-account',
  templateUrl: './view-account.component.html',
  styleUrls: ['./view-account.component.css']
})
export class ViewAccountComponent implements OnInit {
  viewaccount: ViewAccount;
  constructor(private authservice: AuthService) {
    this.viewaccount=new ViewAccount();
   }

  ngOnInit(): void {
    this.ViewAccount();
  }

  ViewAccount() {
    this.authservice.getAccountByCustomerId().subscribe((res) => {
      if (res != null) {
        this.viewaccount=res;
        console.log(this.viewaccount);
      } else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )
  }
}
