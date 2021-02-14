import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../../auth.service';

import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CreditToAccount } from 'src/app/model/credittoaccount.model';

@Component({
  selector: 'app-credittoaccount',
  templateUrl: './credittoaccount.component.html',
  styleUrls: ['./credittoaccount.component.css']
})
export class CredittoaccountComponent implements OnInit {

 credittoaccount: CreditToAccount =
    {
      fromEmailId: "",
      creditAmount: "",
    };

  constructor(private route: ActivatedRoute, private authservice: AuthService, private _router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.credittoaccount.fromEmailId = params['email'];
    });

  }

  onSubmit(form: NgForm) {

    if (this.credittoaccount.fromEmailId === undefined || this.credittoaccount.fromEmailId === "") {
      this.toastr.error("Please Enter Valid Account", "error");
      return;
    }
    


    console.log(this.credittoaccount);

    this.authservice.credittoaccount(this.credittoaccount).subscribe((res) => {
      if (res == null) {
        // alert("Amount Credited Successfully");
        this.toastr.success('Amount Credited Successfully', "Success");
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
