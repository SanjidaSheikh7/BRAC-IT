import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductComponent } from './product-list/product/product.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './header/navbar/navbar.component';
import { NavSearchbarComponent } from './header/navbar/nav-searchbar/nav-searchbar.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductComponent,
    HeaderComponent,
    NavbarComponent,
    NavSearchbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
