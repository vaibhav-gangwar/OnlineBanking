import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../../auth.service';
import { DebitFromAccount } from 'src/app/model/debitfromaccount.model';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-debitfromaccount',
  templateUrl: './debitfromaccount.component.html',
  styleUrls: ['./debitfromaccount.component.css']
})
export class DebitfromaccountComponent implements OnInit {
  debitfromaccount: DebitFromAccount =
    {
      fromEmailId: "",
      debitAmount: "",
    };

  constructor(private route: ActivatedRoute, private authservice: AuthService, private _router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.debitfromaccount.fromEmailId = params['email'];
    });

  }

  onSubmit(form: NgForm) {

    if (this.debitfromaccount.fromEmailId === undefined || this.debitfromaccount.fromEmailId === "") {
      this.toastr.error("Please Enter Valid Account", "error");
      return;
    }
    


    console.log(this.debitfromaccount);

    this.authservice.debitfromaccount(this.debitfromaccount).subscribe((res) => {
      if (res == null) {
        // alert("Amount Debited Successfully");
        this.toastr.success('Amount Debited Successfully', "Success");
        this._router.navigate(['/admindashboard']);
      } else {
        this.toastr.error(res.error(), "error");
        console.log(res.error());
      }
    },
      () => console.log("network error")
    )
  }

}
