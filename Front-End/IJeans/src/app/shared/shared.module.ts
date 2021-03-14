import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MsgErroComponent } from './components/msg-erro/msg-erro.component';

@NgModule({
  declarations: [MsgErroComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    MsgErroComponent
  ]
})

export class SharedModule { }
