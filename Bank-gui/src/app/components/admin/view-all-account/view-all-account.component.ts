import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-view-all-account',
  templateUrl: './view-all-account.component.html',
  styleUrls: ['./view-all-account.component.css']
})
export class ViewAllAccountComponent implements OnInit {
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
}
