import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete-account.component.html',
  styleUrls: ['./delete-account.component.css']
})
export class DeleteAccountComponent implements OnInit {

  allAccount: [];
  constructor(private authservice: AuthService, private _router: Router) { }

  ngOnInit(): void {
    this.ViewAllAccount();
  }

  ViewAllAccount() {
    this.authservice.getAllAccount().subscribe((res) => {
      if (res != null) {
        console.log(res);
        this.allAccount=res;

      } else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )

  }
  
  deleteAccount(custid) {
    this.authservice.deleteCustomer(custid).subscribe((res) => {
      if (res != null) {
        this.ViewAllAccount();
      } else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )

  }
}
