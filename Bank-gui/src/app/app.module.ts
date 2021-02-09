import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModel, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { BackgroundComponent } from './components/background/background.component';
import { FooterComponent } from './components/footer/footer.component';
import { MatMenuModule } from '@angular/material/menu';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { BankLoginComponent } from './components/bank-login/bank-login.component';
import { AboutComponent } from './components/about/about.component';
import { ServiceComponent } from './components/service/service.component';
import { ContectComponent } from './components/contect/contect.component';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { AdminComponent } from './components/admin/admin.component';
import { DashboardComponent } from './components/admin/dashboard/dashboard.component';
import { ManageblogsComponent } from './components/admin/manageblogs/manageblogs.component';
import { CategoriesComponent } from './components/admin/categories/categories.component';
import { PagesComponent } from './components/admin/pages/pages.component';
import { AuthService } from './auth.service';
import { SignupComponent } from './signup/signup.component';
import { CustomerdashboardComponent } from './components/customer/customerdashboard/customerdashboard.component';
import { OpenBankAccountComponent } from './components/customer/open-bank-account/open-bank-account.component';
import { ViewBalanceComponent } from './components/customer/view-balance/view-balance.component';
import { FundTransferComponent } from './components/customer/fund-transfer/fund-transfer.component';
import { CreateFdComponent } from './components/customer/create-fd/create-fd.component';
import { ViewAllAccountComponent } from './components/admin/view-all-account/view-all-account.component';
import { DeleteAccountComponent } from './components/admin/delete-account/delete-account.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    BackgroundComponent,
    FooterComponent,
    NavbarComponent,
    LoginComponent,
    BankLoginComponent,
    AboutComponent,
    ServiceComponent,
    ContectComponent,
    AdminComponent,
    DashboardComponent,
    ManageblogsComponent,
    CategoriesComponent,
    PagesComponent,
    SignupComponent,
    CustomerdashboardComponent,
    OpenBankAccountComponent,
    ViewBalanceComponent,
    FundTransferComponent,
    CreateFdComponent,
    ViewAllAccountComponent,
    DeleteAccountComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatTabsModule,
    MatMenuModule,
    MatProgressBarModule,
    NgbModule
  ],
  providers: [AuthService, HttpClient, NgModel, Title],
  bootstrap: [AppComponent]
})
export class AppModule { }
