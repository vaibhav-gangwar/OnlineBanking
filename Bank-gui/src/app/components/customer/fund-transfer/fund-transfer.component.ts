import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FundTransfer } from 'src/app/model/fundtransfer.model';
import { AuthService } from '../../../auth.service';
import { Customer } from '../../../model/customer.model';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  fundtransfer: FundTransfer =
    {
      fromEmailId: "",
      toEmailId: "",
      transferAmount: "",
    };

  constructor(private authservice: AuthService, private _router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.fundtransfer.fromEmailId=localStorage.getItem("email");
  }

  onSubmit(form: NgForm) {

    console.log(this.fundtransfer);

    this.authservice.fundtransfer(this.fundtransfer).subscribe((res) => {
      if (res == null) {
        //alert("Fund Trasferred Succesflly");
        this.toastr.success('Fund Trasferred Succesfully', "Success");
        this._router.navigate(['/customerdashboard']);
      }else {
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )
  }
}
