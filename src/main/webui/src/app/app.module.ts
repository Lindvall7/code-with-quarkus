import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {StartPageComponent} from "./start/start-page.component";
import {HttpClientModule} from '@angular/common/http'

@NgModule({
  declarations: [
    StartPageComponent

  ],
  imports: [
    BrowserModule,
    AppComponent,
    StartPageComponent
    HttpClientModule
  ]
})
