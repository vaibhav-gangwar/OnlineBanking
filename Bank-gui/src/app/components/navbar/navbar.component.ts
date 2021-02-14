import { Component, DoCheck, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  role: string = "";
  userName: string;
  logged: boolean = true;
  constructor(private authenticationService: AuthService, private _router: Router) { }

  ngOnInit(): void {
  }

  Logout() {
    // alert("LogOut Successful");
    localStorage.removeItem('userId')
    localStorage.removeItem('userName')
    localStorage.removeItem('email')
    localStorage.removeItem('role')
    this._router.navigate(['']);
    
    this.logged=true;
    this.ngDoCheck();
  }

  changeMenuLink() {
    if (localStorage.getItem("userId")) {
      this.role = localStorage.getItem('role');
      this.userName = localStorage.getItem('userName');
      this.logged = false;
    }
  }

  ngDoCheck() {
    this.changeMenuLink();
  }
}
