import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from "../app-routing.module";
import { SharedModule } from "../shared/shared.module";
import { LoginRoutingModule } from "./login-routing.module";
import { LoginComponent } from "./login.component";





@NgModule({
    declarations: [
        LoginComponent
    ],
    imports: [
        CommonModule,
        AppRoutingModule,
        LoginRoutingModule,
        HttpClientModule,
        SharedModule,
        ReactiveFormsModule,
        FormsModule
    ],

    providers: []

})

export class LoginModule {

}