import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {IndexComponent} from "./index/index.component";
import {NavComponent} from "./nav/nav.component";
import {NavService} from "./nav/nav.service";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HttpClientModule} from "@angular/common/http";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import { AddressComponent } from './address/address.component';
import { CarrierComponent } from './carrier/carrier.component';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';
import { InvoiceComponent } from './invoice/invoice.component';


@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    NavComponent,
    AddressComponent,
    CarrierComponent,
    CustomerComponent,
    EmployeeComponent,
    InvoiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}, NavService],
  bootstrap: [AppComponent]
})
export class AppModule { }
