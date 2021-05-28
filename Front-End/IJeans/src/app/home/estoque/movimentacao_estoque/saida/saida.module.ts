import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { SharedModule } from "src/app/shared/shared.module";
import { SaidaRoutingModule } from "./saida-routing.module";
import { SaidaComponent } from "./saida.component";


@NgModule({
    declarations: [
        SaidaComponent,
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        BrowserModule,
        SaidaRoutingModule,
        FormsModule,
        SharedModule
    ],

    providers: []

})

export class SaidaModule{
    
}
