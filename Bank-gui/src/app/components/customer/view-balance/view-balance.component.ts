import { Component, OnInit } from '@angular/core';
import { ViewBalance } from 'src/app/model/balance.model';
import { AuthService } from '../../../auth.service';

@Component({
  selector: 'app-view-balance',
  templateUrl: './view-balance.component.html',
  styleUrls: ['./view-balance.component.css']
})
export class ViewBalanceComponent implements OnInit {

  bal: ViewBalance;
  constructor(private authservice: AuthService) {
    this.bal=new ViewBalance();
  }

  ngOnInit(): void {
    this.ViewBalance();
  }

  ViewBalance() {
    this.authservice.getBalByCustomerId().subscribe((res) => {
      if (res != null) {
        this.bal=res;
        console.log(this.bal);
      } else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )
  }
}
