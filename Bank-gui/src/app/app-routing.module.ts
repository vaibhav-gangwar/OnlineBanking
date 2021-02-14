import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//Common
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ServiceComponent } from './components/service/service.component';
import { AboutComponent } from './components/about/about.component';
import { ContectComponent } from './components/contect/contect.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './signup/signup.component';


//Admin
import { DashboardComponent } from './components/admin/dashboard/dashboard.component';
import { ViewAllAccountComponent } from './components/admin/view-all-account/view-all-account.component';
import { DeleteAccountComponent } from './components/admin/delete-account/delete-account.component';
import { DebitfromaccountComponent } from './components/admin/debitfromaccount/debitfromaccount.component';
import {CredittoaccountComponent} from './components/admin/credittoaccount/credittoaccount.component'

//Customer
import { BankLoginComponent } from './components/bank-login/bank-login.component';
import { CustomerdashboardComponent } from './components/customer/customerdashboard/customerdashboard.component';
import { OpenBankAccountComponent } from './components/customer/open-bank-account/open-bank-account.component';
import { ViewAccountComponent } from './components/customer/view-account/view-account.component';
import { ViewBalanceComponent } from './components/customer/view-balance/view-balance.component';
import { FundTransferComponent } from './components/customer/fund-transfer/fund-transfer.component';
import { CreateFdComponent } from './components/customer/create-fd/create-fd.component';

const routes: Routes = [
  // { path: '**', component: PageNotFoundComponent },
  // ,
  {
    path: '',
    component: HomeComponent,
    pathMatch: "full"
  }
  ,
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "services",
    component: ServiceComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "about",
    component: AboutComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "contact",
    component: ContectComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "openbankaccount",
    component: OpenBankAccountComponent,
    pathMatch: "full"
  }
  //Admin Routing
  ,
  {
    path: "adminlogin",
    component: BankLoginComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "admindashboard",
    component: DashboardComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "adminviewallaccount",
    component: ViewAllAccountComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "admindeleteaccount",
    component: DeleteAccountComponent,
    pathMatch: "full"
  }
  ,

  {
    path: "admindebitaccount",
    component: DebitfromaccountComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "admincreditaccount",
    component: CredittoaccountComponent,
    pathMatch: "full"
  }
  //Customer Routing
  ,
  {
    path: "customerlogin",
    component: LoginComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "customerdashboard",
    component: CustomerdashboardComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "customerviewaccount",
    component: ViewAccountComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "customerviewbalance",
    component: ViewBalanceComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "customerfundtransfer",
    component: FundTransferComponent,
    pathMatch: "full"
  }
  ,
  {
    path: "customercreatefd",
    component: CreateFdComponent,
    pathMatch: "full"
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
