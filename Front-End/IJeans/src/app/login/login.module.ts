import { NgModule } from "@angular/core";
import { AppRoutingModule } from "../app-routing.module";
import { LoginRoutingModule } from "./login-routing.module";
import { LoginComponent } from "./login.component";
import { HttpClientModule } from '@angular/common/http';


@NgModule({
    declarations: [
        LoginComponent
    ],
    imports: [
        AppRoutingModule,
        LoginRoutingModule,
        HttpClientModule
    ],
   
    providers: []
    
})

export class LoginModule {

}