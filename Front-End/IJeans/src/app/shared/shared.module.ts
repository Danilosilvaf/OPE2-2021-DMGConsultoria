import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MsgErroComponent } from './components/msg-erro/erro/msg-erro.component';
import { AlertModalComponent } from './components/alert-modal/alert-modal.component';
import { AlertModalService } from './services/alert-modal.service';

@NgModule({
  declarations: [MsgErroComponent,AlertModalComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    MsgErroComponent
  ],
  providers:[AlertModalService]
})

export class SharedModule { }
